package com.nari.slsd.gglck.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nari.slsd.gglck.biz.cache.SystemParamCache;
import com.nari.slsd.gglck.dao.HibernateDao;
import com.nari.slsd.gglck.dao.SysParamItem;
import com.nari.slsd.gglck.entity.Blacklist;
import com.nari.slsd.report.edit.setter.Tools;

/**
 * 一般来说过闸24小时之内不允许再次登记
 * 
 * @author fenghuiyang
 * 
 */
public class BlacklistUtil
{
	private static final Logger LOG = Logger.getLogger(BlacklistUtil.class);
	/**
	 * 是否是锁定中
	 * 
	 * @param vesselName
	 *            船名
	 * @param location
	 *            上下游
	 * @return 时间字符串:锁定中；"":未锁定
	 */
	@SuppressWarnings("rawtypes")
	public static String isLocked(String vesselName, String location)
	{
		String hql = "from Blacklist where vesselName=?";
		HibernateDao hibernateDao = (HibernateDao)ContextUtil.getBean("hibernateDao");
		List find = hibernateDao.find(hql, vesselName);
		if(find == null || find.size() <= 0)
		{
			return "";
		}
		else
		{
			Blacklist black = (Blacklist)find.get(0);
			Long date = new Date().getTime();
			Date up = black.getExpireTime();// 上游锁定时间
			Date down = black.getExpireTimeDown();// 下游锁定时间
			if("0".equals(location))
			{// 上下游(0上游 1下游)
				if(!CommonTool.isObjNullOrEmpty(up) && date < up.getTime())
				{
					String res = CommonTool.FORMAT_yyyy_MM_dd_HH_mm_ss.format(up);
					return res;
				}
			}
			else
			{
				if(!CommonTool.isObjNullOrEmpty(down) && date < down.getTime())
				{
					String res = CommonTool.FORMAT_yyyy_MM_dd_HH_mm_ss.format(down);
					return res;
				}
			}
			return "";
		}
	}

	/**
	 * 添加一条船进黑名单
	 * 
	 * @param vesselName
	 *            船/船队名
	 * @param lockTo
	 *            要锁定到的时间
	 */
	public static int lock(String vesselName, Date lockTo, String reason, Date expireTimeDown)
	{
		JdbcTemplate jdbcTemplate = (JdbcTemplate)ContextUtil.getBean("jdbcTemplateDao");

		String sql = "SELECT * FROM blacklist WHERE vesselName = ? ";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, vesselName);
		if(list.isEmpty())
		{
			String blacklistId = CommonTool.createUUID();
			sql = "INSERT INTO blacklist(blacklistId,vesselName,expireTime,reason,lockTime,expireTimeDown) VALUES(?,?,?,?,?,?)";
			try
			{
				return jdbcTemplate.update(sql, blacklistId, vesselName, new Timestamp(lockTo.getTime()), reason, new Date(), new Date(expireTimeDown.getTime()));
			}
			catch(Exception e)
			{
				LOG.error(e);
				return 0;
			}
		}
		else
		{
			sql = "UPDATE blacklist SET expireTime=?,reason=?,lockTime=?,expireTimeDown=? WHERE vesselName=?";
			try
			{
				return jdbcTemplate.update(sql, new Timestamp(lockTo.getTime()), reason, new Date(), new Date(expireTimeDown.getTime()), vesselName);
			}
			catch(Exception e)
			{
				LOG.error("过闸锁定船舶", e);
				return 0;
			}
		}
	}

	/**
	 * 从现在起锁定hours小时
	 * 
	 * @param vesselName
	 * @param hours
	 */
	public static int lockHours(String vesselName, int hours, String reason)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return lock(vesselName, calendar.getTime(), reason, calendar.getTime());
	}

	/**
	 * 从现在起锁定value+unit指定的时长
	 * 
	 * @param vesselName
	 * @param value
	 *            value个时间单位。
	 * @param timeUnit
	 *            时间单位。Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,Calendar
	 *            .HOUR_OF_DAY,Calendar.MINUTE,Calendar.SECOND。
	 * @return
	 */
	public static int lockTime(String vesselName, int value, int timeUnit)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(timeUnit, value);
		return lock(vesselName, calendar.getTime(), "", calendar.getTime());
	}

	/**
	 * 从现在起锁定到系统设置的多少小时
	 * 
	 * @param vesselName
	 */
	public static int lockAfterLockage(String vesselName, String location, String isFleet)
	{
		String value = "";
		String value_down = "";// 下游锁定时间
		try
		{
			if("0".equals(location) && "0".equals(isFleet))// 上游单机船
			{
				value = SystemParamCache.getInstance().getSysValue(SysParamItem.UP_PC_REGIST_INTERVAL_TIME.toString());
				value_down = SystemParamCache.getInstance().getSysValue(SysParamItem.UP_PC_REGIST_INTERVAL_TIME_DOWN.toString());
			}
			else if("0".equals(location) && "1".equals(isFleet))// 上游船队
			{
				value = SystemParamCache.getInstance().getSysValue(SysParamItem.UP_PD_REGIST_INTERVAL_TIME.toString());
				value_down = SystemParamCache.getInstance().getSysValue(SysParamItem.UP_PD_REGIST_INTERVAL_TIME_DOWN.toString());
			}
			else if("1".equals(location) && "0".equals(isFleet))// 下游单机船
			{
				value = SystemParamCache.getInstance().getSysValue(SysParamItem.DOWN_PC_REGIST_INTERVAL_TIME.toString());
				value_down = SystemParamCache.getInstance().getSysValue(SysParamItem.DOWN_PC_REGIST_INTERVAL_TIME_DOWN.toString());
			}
			else if("1".equals(location) && "1".equals(isFleet))// 下游船队
			{
				value = SystemParamCache.getInstance().getSysValue(SysParamItem.DOWN_PD_REGIST_INTERVAL_TIME.toString());
				value_down = SystemParamCache.getInstance().getSysValue(SysParamItem.DOWN_PD_REGIST_INTERVAL_TIME_DOWN.toString());
			}
		}
		catch(Exception e)
		{
			LOG.error(e);
			throw new RuntimeException(e);
		}
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(value));
		Calendar calendarDown = Calendar.getInstance();
		calendarDown.add(Calendar.HOUR_OF_DAY, Integer.parseInt(value_down));
		return lock(vesselName, calendar.getTime(), "已过闸,上游" + value + "小时内不能再次登记,下游" + value_down + "小时内不能再次登记", calendarDown.getTime());
	}
	/**
	 * 销号后 从现在起锁定到系统设置的多少小时
	 * 
	 * @param vesselName
	 */
	public static int unRegistLockAfter(String vesselName)
	{
		int hour = 0;
		int cancelCount = queryVesselCancelCount(vesselName) + 1;
		
		String describe = "第" +cancelCount+ "次销号，销号参数不正确，锁定0小时，请修改销号的系统参数.";
		String value = SystemParamCache.getInstance().getSysValue(SysParamItem.UNREGIST_INTERVAL_TIME.toString());
		String[] strAry = value.split(";");
		if (!CommonTool.isObjNullOrEmpty(strAry) && strAry.length == 2)
		{
			String[] countAry = strAry[0].split("-");//次数
			String[] timeAry = strAry[1].split("-");//小时
			if(countAry.length == timeAry.length)
			{
				for(int i=0 ; i < countAry.length ; i++)
				{
					int count = CommonTool.ConvertToInt(countAry[i], 0);
					if(i != countAry.length-1)
					{
						int count1 = CommonTool.ConvertToInt(countAry[i+1], 0);
						if(cancelCount >= count && cancelCount < count1)
						{
							hour = CommonTool.ConvertToInt(timeAry[i], 0);
							break;
						}
						else if (cancelCount < count)
						{
							break;
						}
					}
					else
					{
						if(cancelCount >= count )
						{
							hour = CommonTool.ConvertToInt(timeAry[i], 0);
							break;
						}
						else if (cancelCount < count)
						{
							break;
						}
						hour = CommonTool.ConvertToInt(timeAry[i], 0);
						break;
					}
					
				}
			}
			describe = "第" +cancelCount+ "次销号，" + hour + "小时内不能再次登记";
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY, hour);
		return lock(vesselName, calendar.getTime(),describe, calendar.getTime());
	}
	/**
	 * 注销后 从现在起锁定到系统设置的多少小时
	 * 
	 * @param vesselName
	 */
	public static int cancelLockAfter(String vesselName)
	{
		String value = SystemParamCache.getInstance().getSysValue(SysParamItem.CANCEL_INTERVAL_TIME.toString());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR_OF_DAY, Integer.parseInt(value));
		return lock(vesselName, calendar.getTime(), "已注销，" + value + "小时内不能再次登记", calendar.getTime());
	}
	
	/**
	 * 查询船舶今年的销号次数
	 * 
	 * @param vesselName
	 */
	public static int queryVesselCancelCount(String vesselName)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MONTH, 0);//1月
		calendar.set(Calendar.DAY_OF_MONTH, 1);// 1号
		calendar.set(Calendar.HOUR_OF_DAY,0);//0时
		calendar.set(Calendar.MINUTE, 0);//0分
		calendar.set(Calendar.SECOND, 0);//0秒
		JdbcTemplate jdbcTemplate = (JdbcTemplate)ContextUtil.getBean("jdbcTemplateDao");

		String sql = "SELECT COUNT(0) cancelCount from  cancel_register where unRegistState ='4' and cancelType=1 AND  createTime >? and vesselName = ?";

		Map<String,Object> map = jdbcTemplate.queryForMap(sql,calendar.getTime() , vesselName);
		if(!CommonTool.isObjNullOrEmpty(map))
		{
			return CommonTool.ConvertToInt(map.get("cancelCount")+"",0);
		}
		return 0;
	}
	
}
