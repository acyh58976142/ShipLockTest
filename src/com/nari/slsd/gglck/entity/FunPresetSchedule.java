package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 业务_调度_预调批次(子表)
 * @author z p x
 */
@Entity
@Table(name="fun_preset_schedule")//指明User实体对应的表名称，如果是同名的,可以不写 
public class FunPresetSchedule {
	
	private String 	secondBatchId;			// 调度船舶信息ID
	private String 	dispatchBatId;			// 预调批次ID
	private String 	registerId;				// 登记ID
	private String 	vesselName;				// 船名
	private String 	workGroupBatch;			// 班次信息（到岗操作）
	private String 	workGroupName;			// 工班名称（到岗操作）
	private Integer isLockage;				// 是否过闸(0否 1是)
	private Integer isFleet;				// 是否船队(0否 1是)
	private Integer pewsetShipOrder;		// 预调顺序
	private Integer isBarge;				// 是否驳船(0否 1是)
	private String 	telephone;				// 移动电话
	private Integer isInport;				// 是否到港 0未到港 1已到港确认
	private String 	portManId;				// 确认到港人ID
	private Date 	portTime;				// 确认到港时间
	private Date 	lockageTime;			// 确认过闸时间
	private String 	gearPosition;			// 排挡位置
	private String 	stationId;				// 船闸所ID
	private String 	currentLocation;		// 当前位置
	//2017-01-09 新增
	private String 	lockageUserId;			// 确认过闸人ID
	//2017-02-25 新增
	private Double 	x;						// 排挡时船的x坐标
	private Double 	y;						// 排挡时船的y坐标
	private String 	workGroupBatch2;			// 班次信息（过闸操作）
	private String 	workGroupName2;			// 工班名称（过闸操作）
	
	public FunPresetSchedule() {}
	
	public FunPresetSchedule(String secondBatchId, String dispatchBatId, String registerId, String vesselName,
			String workGroupBatch, String workGroupName, Integer isLockage, Integer isFleet, Integer pewsetShipOrder,
			Integer isBarge, String telephone, Integer isInport, String portManId, Date portTime, Date lockageTime,
			String gearPosition, String stationId, String currentLocation, String lockageUserId, Double x, Double y) {
		this.secondBatchId = secondBatchId;
		this.dispatchBatId = dispatchBatId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.workGroupBatch = workGroupBatch;
		this.workGroupName = workGroupName;
		this.isLockage = isLockage;
		this.isFleet = isFleet;
		this.pewsetShipOrder = pewsetShipOrder;
		this.isBarge = isBarge;
		this.telephone = telephone;
		this.isInport = isInport;
		this.portManId = portManId;
		this.portTime = portTime;
		this.lockageTime = lockageTime;
		this.gearPosition = gearPosition;
		this.stationId = stationId;
		this.currentLocation = currentLocation;
		this.lockageUserId = lockageUserId;
		this.x = x;
		this.y = y;
	}

	
	public FunPresetSchedule(String secondBatchId, String dispatchBatId,
			String registerId, String vesselName, String workGroupBatch,
			String workGroupName, Integer isLockage, Integer isFleet,
			Integer pewsetShipOrder, Integer isBarge, String telephone,
			Integer isInport, String portManId, Date portTime,
			Date lockageTime, String gearPosition, String stationId,
			String currentLocation, String lockageUserId, Double x, Double y,
			String workGroupBatch2, String workGroupName2) {
		super();
		this.secondBatchId = secondBatchId;
		this.dispatchBatId = dispatchBatId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.workGroupBatch = workGroupBatch;
		this.workGroupName = workGroupName;
		this.isLockage = isLockage;
		this.isFleet = isFleet;
		this.pewsetShipOrder = pewsetShipOrder;
		this.isBarge = isBarge;
		this.telephone = telephone;
		this.isInport = isInport;
		this.portManId = portManId;
		this.portTime = portTime;
		this.lockageTime = lockageTime;
		this.gearPosition = gearPosition;
		this.stationId = stationId;
		this.currentLocation = currentLocation;
		this.lockageUserId = lockageUserId;
		this.x = x;
		this.y = y;
		this.workGroupBatch2 = workGroupBatch2;
		this.workGroupName2 = workGroupName2;
	}

	@Id
	public String getSecondBatchId() {
		return secondBatchId;
	}
	public void setSecondBatchId(String secondBatchId) {
		this.secondBatchId = secondBatchId;
	}
	public String getDispatchBatId() {
		return dispatchBatId;
	}
	public void setDispatchBatId(String dispatchBatId) {
		this.dispatchBatId = dispatchBatId;
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getWorkGroupBatch() {
		return workGroupBatch;
	}
	public void setWorkGroupBatch(String workGroupBatch) {
		this.workGroupBatch = workGroupBatch;
	}
	public String getWorkGroupName() {
		return workGroupName;
	}
	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}
	public Integer getIsLockage() {
		return isLockage;
	}
	public void setIsLockage(Integer isLockage) {
		this.isLockage = isLockage;
	}
	public Integer getIsFleet() {
		return isFleet;
	}
	public void setIsFleet(Integer isFleet) {
		this.isFleet = isFleet;
	}
	public Integer getPewsetShipOrder() {
		return pewsetShipOrder;
	}
	public void setPewsetShipOrder(Integer pewsetShipOrder) {
		this.pewsetShipOrder = pewsetShipOrder;
	}
	public Integer getIsBarge() {
		return isBarge;
	}
	public void setIsBarge(Integer isBarge) {
		this.isBarge = isBarge;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getIsInport() {
		return isInport;
	}
	public void setIsInport(Integer isInport) {
		this.isInport = isInport;
	}
	public String getPortManId() {
		return portManId;
	}
	public void setPortManId(String portManId) {
		this.portManId = portManId;
	}
	public Date getPortTime() {
		return portTime;
	}
	public void setPortTime(Date portTime) {
		this.portTime = portTime;
	}
	public Date getLockageTime() {
		return lockageTime;
	}
	public void setLockageTime(Date lockageTime) {
		this.lockageTime = lockageTime;
	}
	public String getGearPosition() {
		return gearPosition;
	}
	public void setGearPosition(String gearPosition) {
		this.gearPosition = gearPosition;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getLockageUserId() {
		return lockageUserId;
	}

	public void setLockageUserId(String lockageUserId) {
		this.lockageUserId = lockageUserId;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getWorkGroupBatch2() {
		return workGroupBatch2;
	}

	public void setWorkGroupBatch2(String workGroupBatch2) {
		this.workGroupBatch2 = workGroupBatch2;
	}

	public String getWorkGroupName2() {
		return workGroupName2;
	}

	public void setWorkGroupName2(String workGroupName2) {
		this.workGroupName2 = workGroupName2;
	}
	
}
