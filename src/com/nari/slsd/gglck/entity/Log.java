package com.nari.slsd.gglck.entity;

import com.nari.slsd.gglck.util.OperationType;

/**
 * 操作日志表
 * @author squirrel
 */
public class Log{
	private String registerId;			//登记Id
	private String ip; 					//操作机器Ip
	private OperationType operationType; //操作类型
	private String staffId; 		//操作人ID
	private String summary; 		//备注（操作内容详细）
	private String workGroupName; 	//名称
	private String workGroupBatch;	//班次
	private String bussinessId; 	//关联ID
	private String stationId;	//船闸所ID
	private String vesselName;//船舶名称（登记，缴费，特殊业务 等只记录一条的放拖头名）
	
	public Log(String registerId, String ip, OperationType operationType,
			String staffId,String summary,
			String workGroupName, String workGroupBatch, String bussinessId,
			String stationId, String vesselName) {
		super();
		this.registerId = registerId;
		this.ip = ip;
		this.operationType = operationType;
		this.staffId = staffId;
		this.summary = summary;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
		this.bussinessId = bussinessId;
		this.stationId = stationId;
		this.vesselName = vesselName;
	}

	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public OperationType getOperationType() {
		return operationType;
	}
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
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
	public String getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(String bussinessId) {
		this.bussinessId = bussinessId;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	

}
