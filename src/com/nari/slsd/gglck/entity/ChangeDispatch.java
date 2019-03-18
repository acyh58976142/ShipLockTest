package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="change_dispatch")
public class ChangeDispatch {
	private String id;			//调度变更信息ID
	private String dispatchBat;	//原来预调批次
	private String registerId;	//登记ID
	private String vesselName;	//船名
	private String staffId;	//操作人ID
	private Date presetTime;	//调度时间
	private Integer location;	//上下游（0=上游   1=下游）
	private Date rollOutTime;	// 转出时间
	private String workGroupName;	//工班名称
	private String workGroupBatch;	//班次信息
	
	public ChangeDispatch() {
		super();
	}
	public ChangeDispatch(String id, String dispatchBat, String registerId,
			String vesselName, String staffId, Date presetTime,
			Integer location, Date rollOutTime, String workGroupName,
			String workGroupBatch) {
		super();
		this.id = id;
		this.dispatchBat = dispatchBat;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.staffId = staffId;
		this.presetTime = presetTime;
		this.location = location;
		this.rollOutTime = rollOutTime;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
	}
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDispatchBat() {
		return dispatchBat;
	}
	public void setDispatchBat(String dispatchBat) {
		this.dispatchBat = dispatchBat;
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
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public Date getPresetTime() {
		return presetTime;
	}
	public void setPresetTime(Date presetTime) {
		this.presetTime = presetTime;
	}
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	public Date getRollOutTime() {
		return rollOutTime;
	}
	public void setRollOutTime(Date rollOutTime) {
		this.rollOutTime = rollOutTime;
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
	
}
