package com.nari.slsd.gglck.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nari.slsd.gglck.util.CommonTool;
import com.nari.slsd.gglck.util.HttpSessionFilter;

/**
 * 根据发票信息数据操作
 * @author
 *
 */
@Repository("passoverDayReportDao")
public class PassoverDayReportDao {
	
	private static final Logger LOG = Logger.getLogger(PassoverDayReportDao.class);
	
	@Autowired
	protected HibernateDao hibernateDAO;
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/*
	 * 根据站点和确认过闸时间，查询出船舶过闸的信息
	 * @param String lockageTime
	 * @throws
	 */
	public List<Map<String, Object>> queryPassoverDayReportListMap(String lockageTime){
		List<Object> params = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("select vesselName,registerId,registerTime,tonnageTns,realFee "
				    + " ,cargoName,itemName,workGroupName,location,lockageTime,arriving,isBarge,stationId"
				    + " from passover_day_report where 1=1 ");
		
		if (!CommonTool.isNullOrEmpty(lockageTime)) {
			sql.append(" and lockageTime >= ?");
			params.add(lockageTime+" 00:00:00");
			sql.append(" and lockageTime <= ?");
			params.add(lockageTime+" 23:59:59");
		}	
		
		if (!CommonTool.isObjNullOrEmpty(HttpSessionFilter.getSessionValue("stationId"))) {
			sql.append(" and stationId = ? ");
			params.add(HttpSessionFilter.getSessionValue("stationId").toString());
		}		
		
		
		sql.append(" order by registerTime,isBarge ");
		return jdbcTemplate.queryForList(sql.toString(), params.toArray());
	}
}
