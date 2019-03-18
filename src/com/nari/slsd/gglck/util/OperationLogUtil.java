package com.nari.slsd.gglck.util;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nari.slsd.gglck.entity.Log;

public class OperationLogUtil
{
	private static final String S1 = "CREATE TABLE ";
	private static final String S2 = " ( " + "operationId nvarchar(32) NOT NULL , " + "registerId nvarchar(32) NULL , " + "ip nvarchar(64) NULL , "
			+ "operationType smallint NULL , " + "staffId nvarchar(32) NULL ,  " + "operationTime datetime NULL , " + "summary nvarchar(512) NULL , "
			+ "workGroupName nvarchar(32) NULL DEFAULT '' , " + "workGroupBatch nvarchar(32) NULL DEFAULT '', " + "businessId nvarchar(32) NULL , "
			+ "stationId nvarchar(32) NULL , " + "vesselName nvarchar(64) NULL , " + "PRIMARY KEY (operationId));";
	private static final String S3 = "CREATE INDEX operationTimeIndex ON ";
	private static final String S4 = "(operationTime ASC);";
	private static final String S5 = "CREATE INDEX registerIdIndex ON ";
	private static final String S6 = "(registerId ASC);";

	private static final String LOG_TABLE_NAME = "operation_log_";
	private static final String INDEX_TABLE_NAME = "operation_log_index";

	private static Logger LOG = Logger.getLogger(OperationLogUtil.class);

	public static void main(String[] args)
	{
		// log("abcdefg", "127.0.0.1", OperationType.REGISTE, "1111",
		// "2017-03-23 12:00:00", "jiaofei", "workGroupName", "workGroupBatch",
		// "bussinessId", "stationId");

		System.out.println(getAvailableTable("abcdefg"));
	}
	/**
	 * 每张log表里面最多存的registerId的个数
	 */
	private static final int MAX_PER_TABLE = 20000;

	private static JdbcTemplate jdbcTemplate = (JdbcTemplate)ContextUtil.getBean("jdbcTemplateDao");
	// private static JdbcTemplate jdbcTemplate =
	// FunctionUtil.getJdbcTemplate();

	/**
	 * 往操作日志里面记录信息
	 * 
	 * @param registerId
	 *            登记号
	 * @param ip
	 *            操作人的IP地址
	 * @param operationType
	 *            操作类型
	 * @param staffId
	 *            操作人员的ID
	 * @param summary
	 *            详细内容(如果有)
	 * @param workGroupName
	 *            操作的工班ID(如果有)
	 * @param workGroupBatch
	 *            操作的班次(如果有)
	 * @param bussinessId
	 *            关联的业务的ID 如缴费(如果有)
	 * @param stationId
	 *            站号
	 * @param vesselName
	 *            船舶名称（登记，缴费，特殊业务操作只记录一条，其他操作记录每条船只信息）
	 * @return
	 */
	public static int log(String registerId, String ip, OperationType operationType, String staffId, String summary, String workGroupName, String workGroupBatch,
			String bussinessId, String stationId, String vesselName)
	{
		return log(registerId, ip, operationType, staffId, CommonTool.FORMAT_yyyy_MM_dd_HH_mm_ss.format(new Date()), summary, workGroupName, workGroupBatch, bussinessId, stationId,
				vesselName);
	}
	/**
	 * 往操作日志里面记录信息
	 * 
	 * @param registerId
	 *            登记号
	 * @param ip
	 *            操作人的IP地址
	 * @param operationType
	 *            操作类型
	 * @param staffId
	 *            操作人员的ID
	 * @param operationTime
	 *            操作时间
	 * @param summary
	 *            详细内容(如果有)
	 * @param workGroupName
	 *            操作的工班ID(如果有)
	 * @param workGroupBatch
	 *            操作的班次(如果有)
	 * @param bussinessId
	 *            关联的业务的ID 如缴费(如果有)
	 * @param stationId
	 *            站号
	 * @param vesselName
	 *            船舶名称
	 * @return
	 */
	public static int log(String registerId, String ip, OperationType operationType, String staffId, String operationTime, String summary, String workGroupName,
			String workGroupBatch, String bussinessId, String stationId, String vesselName)
	{
		return log(registerId, ip, operationType.getCode() + "", staffId, operationTime, summary, workGroupName, workGroupBatch, bussinessId, stationId, vesselName);
	}

	/**
	 * 往操作日志里面记录信息
	 * 
	 * @param registerId
	 *            登记号
	 * @param ip
	 *            操作人的IP地址
	 * @param operationType
	 *            操作类型
	 * @param staffId
	 *            操作人员的ID
	 * @param operationTime
	 *            操作时间
	 * @param summary
	 *            操作内容
	 * @param workGroupName
	 *            操作的工班ID(如果有)
	 * @param workGroupBatch
	 *            操作的班次(如果有)
	 * @param bussinessId
	 *            关联的业务的ID 如缴费(如果有)
	 * @param stationId
	 *            站号
	 * @return
	 */
	private static int log(String registerId, String ip, String operationType, String staffId, String operationTime, String summary, String workGroupName, String workGroupBatch,
			String bussinessId, String stationId, String vesselName)
	{
		try
		{
			String operationId = CommonTool.createUUID();
			String tableName = getAvailableTable(registerId);
			String sql = "INSERT INTO " + tableName + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
			return jdbcTemplate.update(sql, operationId, registerId, ip, operationType, staffId, operationTime, summary, workGroupName, workGroupBatch, bussinessId, stationId,
					vesselName);
		}
		catch(Exception e)
		{
			LOG.error(e);
			return 0;
		}
	}

	/**
	 * 获得一个可以registerId的表名
	 * 
	 * @param registerId
	 */
	public static String getAvailableTable(String registerId)
	{
		String sql = "SELECT tableIndex FROM " + INDEX_TABLE_NAME + " WHERE registerId = '" + registerId + "'";

		List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		// 索引表里找到了就返回对应的表名。同一个registerId应放在同一张表里而不管这张表是不是超过设定的最大值了。
		if(map != null && map.size() > 0)
		{
			int index = (Integer)map.get(0).get("tableIndex");
			// System.out.println("找到了!" + index);
			return LOG_TABLE_NAME + index;
		}
		// 不然就看看最后一张表里面是不是还有空间
		else
		{
			// 当前的表的编号
			int curIndex = getCurrentTableIndex();
			// System.out.println("当前表的编号是:" + curIndex);
			// 索引表是空的或者没有空间了
			if(curIndex == 0 || !hasSpace(curIndex))
			{
				// 当前没有表，那么创建一个
				int newIndex = createNextTable(curIndex);
				// 然后把这个registerId记录进Index表
				addRecordToIndex(registerId, newIndex);

				return LOG_TABLE_NAME + newIndex;
			}
			// 记录表里面还能放下
			else
			{
				// System.out.println("还能放下,在" + curIndex);
				// 然后把这个registerId记录进Index表
				addRecordToIndex(registerId, curIndex);

				return LOG_TABLE_NAME + curIndex;
			}
		}
	}

	/**
	 * 查找当前用到的表名后面的序号的最大数
	 * 
	 * @return
	 */
	private static int getCurrentTableIndex()
	{
		String sql = "SELECT MAX(DISTINCT tableIndex) as num from " + INDEX_TABLE_NAME;
		List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		if(map != null && !map.isEmpty())
		{
			Object num = map.get(0).get("num");
			if(num == null)
			{
				return 0;
			}
			else
			{
				return (Integer)num;
			}
		}
		else
		{
			return 0;
		}
	}

	/**
	 * 看看记录表里面是不是还有空间可以放下。（每个记录表里面的registerId的数量有没有超过MAX_PER_TABLE）
	 * 
	 * @param index
	 * @return
	 */
	private static boolean hasSpace(int index)
	{
		String sql = "SELECT COUNT(registerId) as num FROM " + INDEX_TABLE_NAME + " WHERE tableIndex = '" + index + "'";

		List<Map<String, Object>> map = jdbcTemplate.queryForList(sql);
		if(map != null && !map.isEmpty())
		{
			Object num = map.get(0).get("num");
			if(num == null)
			{
				// System.out.println("还有空间!.");
				return true;
			}
			else
			{
				if((Integer)num < MAX_PER_TABLE)
				{
					// System.out.println("还有空间!" + num);
					return true;
				}
				else
				{
					// System.out.println("没有空间了!" + num);
					return false;
				}
			}
		}
		else
		{
			// System.out.println("还有空间!...");
			return true;
		}
	}

	private static int addRecordToIndex(String registerId, int toIndex)
	{
		String sql = "INSERT INTO " + INDEX_TABLE_NAME + " VALUES (?,?)";

		return jdbcTemplate.update(sql, registerId, toIndex);
	}

	/**
	 * 创建一个编号为curIndex+1的表
	 * 
	 * @param curIndex
	 */
	private static int createNextTable(int curIndex)
	{
		String tableName = LOG_TABLE_NAME + (curIndex + 1);
		String sql = S1 + tableName + S2 + S3 + tableName + S4 + S5 + tableName + S6;
		jdbcTemplate.execute(sql);

		return curIndex + 1;
	}
	// public static void main(String[] args)
	// {
	// for(int i = 1; i < 25; i++)
	// {
	// if(i < 20)
	// {
	// log("registerId" + i, "10.144.1." + i, "" + i, "" + i,
	// FunctionUtil.FORMAT.format(new Date()), i + "", "" + (i % 4), "" + (i %
	// 3), "bizid_" + i, "station" + i);
	// }
	// else
	// {
	// log("registerId" + i, "10.144.1." + i, "" + i, "" + i,
	// FunctionUtil.FORMAT.format(new Date()), i + "", null, null, null,
	// "station" + i);
	// }
	// }
	// }
	public static int log(Log lg)
	{
		return log(lg.getRegisterId(), lg.getIp(), lg.getOperationType(), lg.getStaffId(), lg.getSummary(), lg.getWorkGroupBatch(), lg.getWorkGroupBatch(), lg.getBussinessId(),
				lg.getStaffId(), lg.getVesselName());
	}
}
