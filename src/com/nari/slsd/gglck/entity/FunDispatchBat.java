package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 业务_调度_调度批次信息(主表)
 * @author z p x
 */
@Entity
@Table(name="fun_dispatchBat")//指明User实体对应的表名称，如果是同名的,可以不写 
public class FunDispatchBat {
	private String 	dispatchBatId;			// 调度ID
	private String 	dispatchBat;			// 调度批次
	private String 	workGroupName;			// 工班名称
	private String 	workGroupBatch;			// 班次信息
	private Integer location;				// 上下游(0=上游   1=下游)
	private Date 	dispatchBatTime;		// 调度时间
	private String 	staffId;				// 操作人ID
	private String 	lockNo;					// 闸室编号
	private String 	stationId;				// 船闸所编号
	private Date 	lockTime;				// 过闸时间
	private Date 	expectedLockTime;		// 预计过闸时间
	private Integer isNullBrake;			// 是否空闸(0否 1是)
	private Integer isDangerousGate;		// 是否危险品闸次(0否 1是)
	private Double 	theUtilizationRate;		// 闸室利用率
	private String 	batchCurrentLocation;	// 批次当前位置
	private String 	sendPosition;			// 发往位置
	
	public FunDispatchBat() {}
	
	public FunDispatchBat(String dispatchBatId, String dispatchBat, String workGroupName, String workGroupBatch,
			Integer location, Date dispatchBatTime, String staffId,
			String lockNo, String stationId, Date lockTime, Date expectedLockTime, Integer isNullBrake,
			Integer isDangerousGate, Double theUtilizationRate, String batchCurrentLocation, String sendPosition) {
		this.dispatchBatId = dispatchBatId;
		this.dispatchBat = dispatchBat;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
		this.location = location;
		this.dispatchBatTime = dispatchBatTime;
		this.staffId = staffId;
		this.lockNo = lockNo;
		this.stationId = stationId;
		this.lockTime = lockTime;
		this.expectedLockTime = expectedLockTime;
		this.isNullBrake = isNullBrake;
		this.isDangerousGate = isDangerousGate;
		this.theUtilizationRate = theUtilizationRate;
		this.batchCurrentLocation = batchCurrentLocation;
		this.sendPosition = sendPosition;
	}
	
	@Id 
	public String getDispatchBatId() {
		return dispatchBatId;
	}
	public void setDispatchBatId(String dispatchBatId) {
		this.dispatchBatId = dispatchBatId;
	}
	public String getDispatchBat() {
		return dispatchBat;
	}
	public void setDispatchBat(String dispatchBat) {
		this.dispatchBat = dispatchBat;
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
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public Date getDispatchBatTime() {
		return dispatchBatTime;
	}
	public void setDispatchBatTime(Date dispatchBatTime) {
		this.dispatchBatTime = dispatchBatTime;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getLockNo() {
		return lockNo;
	}
	public void setLockNo(String lockNo) {
		this.lockNo = lockNo;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
	public Date getExpectedLockTime() {
		return expectedLockTime;
	}
	public void setExpectedLockTime(Date expectedLockTime) {
		this.expectedLockTime = expectedLockTime;
	}
	public Integer getIsNullBrake() {
		return isNullBrake;
	}
	public void setIsNullBrake(Integer isNullBrake) {
		this.isNullBrake = isNullBrake;
	}
	public Integer getIsDangerousGate() {
		return isDangerousGate;
	}
	public void setIsDangerousGate(Integer isDangerousGate) {
		this.isDangerousGate = isDangerousGate;
	}
	public Double getTheUtilizationRate() {
		return theUtilizationRate;
	}
	public void setTheUtilizationRate(Double theUtilizationRate) {
		this.theUtilizationRate = theUtilizationRate;
	}
	public String getBatchCurrentLocation() {
		return batchCurrentLocation;
	}
	public void setBatchCurrentLocation(String batchCurrentLocation) {
		this.batchCurrentLocation = batchCurrentLocation;
	}
	public String getSendPosition() {
		return sendPosition;
	}
	public void setSendPosition(String sendPosition) {
		this.sendPosition = sendPosition;
	}
	
}
