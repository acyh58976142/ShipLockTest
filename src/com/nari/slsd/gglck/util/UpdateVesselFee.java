package com.nari.slsd.gglck.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nari.slsd.gglck.dao.BatchType;
import com.nari.slsd.gglck.dao.HibernateDao;
import com.nari.slsd.gglck.dao.Page;
import com.nari.slsd.gglck.dao.SysParamItem;
import com.nari.slsd.gglck.entity.BaseVessel;
import com.nari.slsd.gglck.entity.Register;

public class UpdateVesselFee {
	private static Map<String, String> SystemParamMap;
	
	public static void main(String[] args) {
		//运行时     修改  dao.xml  在  /WEB-INF/jdbc.properties前加上 /WebContent目录
		FileSystemXmlApplicationContext bean = new FileSystemXmlApplicationContext("WebContent/WEB-INF/dao.xml");
		HibernateDao hdao = (HibernateDao) bean.getBean("hibernateDao");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) bean.getBean("jdbcTemplateDao");
		SystemParamMap = new HashMap<String,String>();
		
		String sql = "select sysKey,sysValue  from system_params  order by sysKey";
		
		List<Map<String, Object>> dictionaryList = jdbcTemplate.queryForList(sql);
		for(Map<String, Object> map : dictionaryList){
			String sysKey = (String)map.get("sysKey");
			String sysValue = map.get("sysValue")==null?"":map.get("sysValue").toString();
			SystemParamMap.put(sysKey, sysValue);
		}
		
		Long total = hdao.getCountByQuery("from BaseVessel ",  new Object[]{});
		int num = 0;
		int pageSize = 500;
		if(total>=1000)
		{
			num = (int) Math.ceil((double)total/pageSize);
		}
		else if(total>0 && total<pageSize)
		{
			num = 1;
		}
		if(num>0)
		{
			for(int k=0;k<num;k++)
			{
				int startIndex = pageSize * k; 
				Page page = hdao.findPageByQuery(total, "from BaseVessel order by regTime", pageSize, startIndex,  new Object[]{});
				
				List<BaseVessel> list = (List<BaseVessel>) page.getItems();
				if(!CommonTool.isListNullOrEmpty(list))
				{
					
					for(BaseVessel bv : list)
					{
						Register reg = new Register();
//						if(!CommonTool.isObjNullOrEmpty(bv.getVesselType()))
//						{
//							reg.setVesselType(bv.getVesselType());
//						}
//						else
//						{
							if(bv.getIsFleet().equals("0") && bv.getIsDangerous() == 0)
							{
								reg.setVesselType("1");
								bv.setVesselType("1");
							}
							else if(bv.getIsFleet().equals("0") && bv.getIsDangerous() == 1)
							{
								reg.setVesselType("3");
								bv.setVesselType("3");
							}
							else if(bv.getIsFleet().equals("1") && bv.getIsDangerous() == 0)
							{
								reg.setVesselType("2");
								bv.setVesselType("2");
							}
							else if(bv.getIsFleet().equals("1") && bv.getIsDangerous() == 1)
							{
								reg.setVesselType("4");
								bv.setVesselType("4");
							}
//						}
						
						reg.setTonnageTns(bv.getTonnageTns());
						reg.setDragHeadTns(bv.getHeadTnng());
						reg.setCargoType(bv.getCargoType());
						
						double a = calculateMoney(reg);
						bv.setLockFee(a);
					}
					int count = hdao.batchExcute(list, BatchType.UPDATE);
					System.out.println("修改数量"+count  + "========"+list.size());
				}
			}
		}
		
	}
	
	public static Double calculateMoney(Object params)
	{
		Register register =  (Register) params;
		double money = Double.NaN;
		//类型
		String vesselType = register.getVesselType();
		//普通单机船
		if(vesselType.equals("1"))
		{
			money = generalVessel(register);
		}
		//普通船队
		else if(vesselType.equals("2"))
		{
			money = generalFleet(register);
		}
		//危险品单机船
		else if(vesselType.equals("3"))
		{
			money = dangerVessel(register);
		}
		else if(vesselType.equals("4"))
		{
			money = dangerFleet(register);
		}
		if(money != Double.NaN)
		{
			//不满一角不计费(取小数后1位即可)
			return getDeciamlCastOff(money, 1);
		}
		return null;
	}
	
	/**
	 * 危险品船队计费
	 * @param register
	 * @return
	 */
	private static double dangerFleet(Register register)
	{
		//判断空载还是重载(危险品船队，10是空载)
		boolean emptyLoad = false;
		String cargoType = register.getCargoType();
		if(!CommonTool.isNullOrEmpty(cargoType))
		{
			if(cargoType.equals("10") || cargoType.equals("11") || cargoType.equals("12"))
			{
				emptyLoad = true;
			}
		}
		
		//超载计算系数
		double ratio = Constants.basic;
		//判断超载(肯定不空载)
		if(!emptyLoad)
		{
			String overLoadStandard = register.getOverloadStandard();
			if(!CommonTool.isNullOrEmpty(overLoadStandard))
			{
				if(overLoadStandard.equals("0.5"))
				{
					ratio = Constants.danager_fleet_over50;
				}
				else if(overLoadStandard.equals("1.0"))
				{
					ratio = Constants.danager_fleet_over100;
				}
			}
		}
		//船队的托头吨位和驳船总吨位
		double dragHeadTns = register.getDragHeadTns();//拖头吨位
		int calDragHeadTns = getTns(dragHeadTns);//拖头计算吨位
		double tonnageTns = register.getTonnageTns();//驳船吨位
		int calDragTotalTns = getTns(tonnageTns);//驳船计算吨位
		
		String headPrice = SystemParamMap.get(SysParamItem.DANGER_FLEET_HEAD_PRICE+"");
		String emptyPrice = SystemParamMap.get(SysParamItem.DANGER_FLEET_EMPTY_PRICE+"");
		String heavyPrice = SystemParamMap.get(SysParamItem.DANGER_FLEET_HEAVY_PRICE+"");
		
		BigDecimal bdhead = new BigDecimal(headPrice);
		BigDecimal bdemptyPrice = new BigDecimal(emptyPrice);
		BigDecimal bdheavyPrice = new BigDecimal(heavyPrice);
		//空载计费
		if(emptyLoad)
		{
			//危险品船队空载单价 = 拖头吨 * 0.28 + 驳船总和吨 * 2.04
			return calDragHeadTns * bdhead.setScale(2).doubleValue() + calDragTotalTns * bdemptyPrice.setScale(2).doubleValue();
		}
		//重载计费
		else
		{
			//危险品船队重载单价 =  拖头吨 * 0.28 + 驳船总和吨 * 2.34
			//危险品船队超载50%收费单价 =  拖头吨 * 0.28 + 驳船总和吨 * (1+0.8) * 2.34
			//危险品船队超载100%收费单价 = 拖头吨 * 0.28 + 驳船总和吨 * (1+1.2) * 2.34
			return calDragHeadTns * bdhead.setScale(2).doubleValue() + calDragTotalTns * ratio * bdheavyPrice.setScale(2).doubleValue();
		}
	}

	/**
	 * 普通船队计费
	 * @param register
	 * @return
	 */
	private static double generalFleet(Register register)
	{
		//判断空载还是重载(普通船队，7是空载)
		boolean emptyLoad = false;
		String cargoType = register.getCargoType();
		if(!CommonTool.isNullOrEmpty(cargoType))
		{
			if(cargoType.equals("7"))
			{
				emptyLoad = true;
			}
		}
		
		//超载计算系数
		double ratio = Constants.basic;
		//判断超载(肯定不空载)
		if(!emptyLoad)
		{
			String overLoadStandard = register.getOverloadStandard();
			if(!CommonTool.isNullOrEmpty(overLoadStandard))
			{
				if(overLoadStandard.equals("0.5"))
				{
					ratio = Constants.general_fleet_over50;
				}
				else if(overLoadStandard.equals("1.0"))
				{
					ratio = Constants.general_fleet_over100;
				}
			}
		}
		//船队的托头吨位和驳船总吨位
		double dragHeadTns = register.getDragHeadTns();//拖头吨位
		int calDragHeadTns = getTns(dragHeadTns);//拖头计算吨位
		double tonnageTns = register.getTonnageTns();//驳船吨位
		int calDragTotalTns = getTns(tonnageTns);//驳船计算吨位
		
		String headPrice = SystemParamMap.get(SysParamItem.NORMAL_FLEET_HEAD_PRICE+"");
		String emptyPrice = SystemParamMap.get(SysParamItem.NORMAL_FLEET_EMPTY_PRICE+"");
		String heavyPrice = SystemParamMap.get(SysParamItem.NORMAL_FLEET_HEAVY_PRICE+"");
		
		BigDecimal bdhead = new BigDecimal(headPrice);
		BigDecimal bdemptyPrice = new BigDecimal(emptyPrice);
		BigDecimal bdheavyPrice = new BigDecimal(heavyPrice);
		
		//空载计费
		if(emptyLoad)
		{
			//普通船队空载单价=拖头吨 * 0.28 + 驳船总和吨 * 0.68
			return calDragHeadTns * bdhead.setScale(2).doubleValue() + calDragTotalTns * bdemptyPrice.setScale(2).doubleValue();
		}
		//重载计费
		else
		{
			//普通船队重载单价 = 拖头吨 * 0.28 + 驳船总和吨 * 0.78
			//普通船队超载50%收费单价 =  拖头吨 * 0.28 + 驳船总和吨 * (1+0.6) * 0.78
			//普通船队超载100%收费单价 = 拖头吨 * 0.28 + 驳船总和吨 * (1+1.2) * 0.78
			return calDragHeadTns * bdhead.setScale(2).doubleValue() + calDragTotalTns * ratio * bdheavyPrice.setScale(2).doubleValue();
		}
	}
	/**
	 * 普通单机船费用
	 * @return
	 */
	private static double generalVessel(Register register)
	{
		//船舶注册时的荷载吨位
		double tonnageTns = register.getTonnageTns();
		//将荷载吨位转换为计费吨位
		int calTns = getTns(tonnageTns);
		//超载计算系数
		double ratio = Constants.basic;
		//判断超载
		String overLoadStandard = register.getOverloadStandard();
		if(!CommonTool.isNullOrEmpty(overLoadStandard))
		{
			if(overLoadStandard.equals("0.5"))
			{
				ratio = Constants.general_over50;
			}
			else if(overLoadStandard.equals("1.0"))
			{
				ratio = Constants.general_over100;
			}
		}
		String price = SystemParamMap.get(SysParamItem.NORMAL_VESSEL_PRICE+"");
		
		BigDecimal bd = new BigDecimal(price);
		double money = ratio * calTns * bd.setScale(2).doubleValue();
		return money;
	}
	
	/**
	 * 危险品单机船费用
	 * @return
	 */
	private static double dangerVessel(Register register)
	{
		//船舶注册时的荷载吨位
		double tonnageTns = register.getTonnageTns();
		//将荷载吨位转换为计费吨位
		int calTns = getTns(tonnageTns);
		
		double ratio = Constants.basic;
		//判断超载
		String overLoadStandard = register.getOverloadStandard();
		if(!CommonTool.isNullOrEmpty(overLoadStandard))
		{
			if(overLoadStandard.equals("0.5"))
			{
				ratio = Constants.danager_over50;
			}
			else if(overLoadStandard.equals("1.0"))
			{
				ratio = Constants.danager_over100;
			}
		}
		String price = SystemParamMap.get(SysParamItem.DANGER_VESSEL_PRICE+"");
		
		BigDecimal bd = new BigDecimal(price);
		
		double money = ratio * calTns * bd.setScale(2).doubleValue();
		return money;
	}
	/**
	 * 根据业务规则，计算核载吨位
	 * @param actual
	 * @return
	 */
	private static int getTns(double actual)
	{
		//强转，获得整数部分
		int tns = (int)actual;
		//不满半吨不计费，半吨及以上按一吨计费
		double decimalTns = getDecimal(actual);
		if(decimalTns >= 0.5)
		{
			tns = tns + 1;
		}
		return tns;
	}
	
	/**
	 * 获得浮点数的小数部分
	 * @param d
	 * @return
	 */
	private static double getDecimal (double d)
	{
		System.out.println(d);
		String str=String.valueOf(d).replaceAll("\\d+\\.", "");
		return Double.parseDouble("0."+str);
	}
	/**
	 * 非四舍五入方式处理浮点数
	 * @param d
	 * @param decimalNum 小数点位数
	 * @return
	 */
	private static double getDeciamlCastOff(double d,int decimalNum)
	{
		 String s=Double.toString(d);
		 String s1=s.substring(0,s.indexOf(".")+decimalNum+1);
		 return Double.parseDouble(s1);
	}
	
}
