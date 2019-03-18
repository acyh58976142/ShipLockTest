package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 船舶状态f
 * @author acer
 *
 */
@Entity
@Table(name="register_state")
public class RegisterState {
	private   String    stateId;		// 状态Id
	private   Integer   unRegistState;	// 注销状态（0=无 1=申请注销  2=审批通过  3=审批不通过）
    private   Integer   vipState;		// 提放状态(0无 1提放申请 2同意,待缴费  3申请驳回 4取消申请 5同意,已缴费)
    private   Integer   checkState;		// 当前的查补状态(0无 1待缴费 2已缴费 3已查补 4已撤销-考虑到多次查补)
    private   Integer   lockNum;		// 闸号
    private   Integer   enableDispatch;	// 是否可调度(0不可调 1可调)
    private   String    registerId;		// 登记Id
    private   String    vesselName;		// 船名
    private   Integer   freeState;		// 免征状态(0无 1申请免征 2同意免征 3驳回免征)    private   Integer   illegalState;	// 违章状态(0无违章 1违章未处理 2违章已处理)    private   String    updateUserId;	// 更新人Id
    private   Date  	updateTime;		// 更新时间
    private   String 	stationId;		// 船闸所Id
    private   Integer   autoRegisterAudit; // 自动报道审核（0 审核，1 已审核）
    
    
	// 2017-01-16 日合并字段
    private   Integer   vesselState;	// 默认:0-待缴费库 1-待调库 2-调度库 3-未调库 4-延时库 5-已归档
    // 2017-03-16日添加字段
    private Integer isBarge;			// 是否驳船(0否 1是)

	public RegisterState() {}
	
	public RegisterState(String stateId, Integer unRegistState, Integer vipState, Integer checkState, Integer lockNum,
			Integer enableDispatch, String registerId, String vesselName, Integer freeState, Integer illegalState,
			String updateUserId, Date updateTime, String stationId, Integer vesselState,Integer autoRegisterAudit) {
		this.stateId = stateId;
		this.unRegistState = unRegistState;
		this.vipState = vipState;
		this.checkState = checkState;
		this.lockNum = lockNum;
		this.enableDispatch = enableDispatch;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.freeState = freeState;
		this.illegalState = illegalState;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
		this.stationId = stationId;
		this.vesselState = vesselState;
		this.autoRegisterAudit = autoRegisterAudit;
	}

	public RegisterState(String stateId, Integer unRegistState, Integer vipState, Integer checkState, Integer lockNum,
			Integer enableDispatch, String registerId, String vesselName, Integer freeState, Integer illegalState,
			String updateUserId, Date updateTime, String stationId, Integer autoRegisterAudit, Integer vesselState,
			Integer isBarge) {
		this.stateId = stateId;
		this.unRegistState = unRegistState;
		this.vipState = vipState;
		this.checkState = checkState;
		this.lockNum = lockNum;
		this.enableDispatch = enableDispatch;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.freeState = freeState;
		this.illegalState = illegalState;
		this.updateUserId = updateUserId;
		this.updateTime = updateTime;
		this.stationId = stationId;
		this.autoRegisterAudit = autoRegisterAudit;
		this.vesselState = vesselState;
		this.isBarge = isBarge;
	}

	// 有在用...
	public RegisterState(String stateId, String vesselName, Integer vesselState) {
		this.stateId = stateId;
		this.vesselName = vesselName;
		this.vesselState = vesselState;
	}

	public RegisterState(String stateId) {
		super();
		this.stateId = stateId;
	}
	
	@Id
	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public Integer getUnRegistState() {
		return unRegistState;
	}

	public void setUnRegistState(Integer unRegistState) {
		this.unRegistState = unRegistState;
	}

	public Integer getVipState() {
		return vipState;
	}

	public void setVipState(Integer vipState) {
		this.vipState = vipState;
	}

	public Integer getCheckState() {
		return checkState;
	}

	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}

	public Integer getLockNum() {
		return lockNum;
	}

	public void setLockNum(Integer lockNum) {
		this.lockNum = lockNum;
	}

	public Integer getEnableDispatch() {
		return enableDispatch;
	}

	public void setEnableDispatch(Integer enableDispatch) {
		this.enableDispatch = enableDispatch;
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

	public Integer getFreeState() {
		return freeState;
	}

	public void setFreeState(Integer freeState) {
		this.freeState = freeState;
	}

	public Integer getIllegalState() {
		return illegalState;
	}

	public void setIllegalState(Integer illegalState) {
		this.illegalState = illegalState;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public Integer getVesselState() {
		return vesselState;
	}

	public void setVesselState(Integer vesselState) {
		this.vesselState = vesselState;
	}
	
	public Integer getAutoRegisterAudit() {
		return autoRegisterAudit;
	}

	public void setAutoRegisterAudit(Integer autoRegisterAudit) {
		this.autoRegisterAudit = autoRegisterAudit;
	}

	public Integer getIsBarge() {
		return isBarge;
	}

	public void setIsBarge(Integer isBarge) {
		this.isBarge = isBarge;
	}
	
} 