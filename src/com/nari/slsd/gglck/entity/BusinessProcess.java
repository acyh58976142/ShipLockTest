package com.nari.slsd.gglck.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 申请审批流程信息
 * @author acer
 */
@Entity 
@Table(name="business_process")
public class BusinessProcess {
	   private String processId;				//流程ID
	   private String businessId ;				//特殊业务关联ID
	   private Integer businessType;			//业务类型
	   private Integer operType;				//操作类型
	   private String staffId;					//操作人ID
	   private Date operTime;					//操作时间
	   private String summary;					//备注
	   private String workGroupName;			//工班名称
	   private String workGroupBatch;			//班次信息
	   private String stationId;				//站点Id
	public BusinessProcess() {
		super();
	}
	

	public BusinessProcess(String processId) {
		super();
		this.processId = processId;
	}


	public BusinessProcess(String processId, String businessId,
			Integer businessType, Integer operType, String staffId,
			Date operTime, String summary, String workGroupName,
			String workGroupBatch,String stationId) {
		super();
		this.processId = processId;
		this.businessId = businessId;
		this.businessType = businessType;
		this.operType = operType;
		this.staffId = staffId;
		this.operTime = operTime;
		this.summary = summary;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
		this.stationId=stationId;
	}

	@Id
	public String getProcessId() {
		return processId;
	}


	public void setProcessId(String processId) {
		this.processId = processId;
	}


	public String getBusinessId() {
		return businessId;
	}


	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}


	public Integer getBusinessType() {
		return businessType;
	}


	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}


	public Integer getOperType() {
		return operType;
	}


	public void setOperType(Integer operType) {
		this.operType = operType;
	}


	public String getStaffId() {
		return staffId;
	}


	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}


	public Date getOperTime() {
		return operTime;
	}


	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public String getWorkGroupName() {
		return workGroupName;
	}


	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}


	public String getWorkGroupBatch() {
		return workGroupBatch;
	}


	public void setWorkGroupBatch(String workGroupBatch) {
		this.workGroupBatch = workGroupBatch;
	}


	public String getStationId() {
		return stationId;
	}


	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	   
}
