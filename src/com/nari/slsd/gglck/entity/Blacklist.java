package com.nari.slsd.gglck.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统参数
 * @author zsq
 */
@Entity
@Table(name="blacklist")
public class Blacklist implements Serializable
{
	private String blacklistId;//黑名单ID
	private String vesselName;//船名
	private Date expireTime;//上游解锁时间
	private String reason;//锁定理由
	private Date lockTime;//锁定时间
	private String staffId;//操作人
	private Date expireTimeDown;//下游解锁时间
	private String stationId;
	
	public Blacklist(String blacklistId) {
		super();
		this.blacklistId = blacklistId;
	}
	
	public Blacklist() {
		super();
	}

	public Blacklist(String blacklistId, String vesselName, Date expireTime, String reason, Date lockTime) {
		super();
		this.blacklistId = blacklistId;
		this.vesselName = vesselName;
		this.expireTime = expireTime;
		this.reason = reason;
		this.lockTime = lockTime;
	}
	@Id
	public String getBlacklistId() {
		return blacklistId;
	}
	public void setBlacklistId(String blacklistId) {
		this.blacklistId = blacklistId;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getLockTime() {
		return lockTime;
	}
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public Blacklist(String blacklistId, String vesselName, Date expireTime, String reason, Date lockTime,
			String staffId) {
		super();
		this.blacklistId = blacklistId;
		this.vesselName = vesselName;
		this.expireTime = expireTime;
		this.reason = reason;
		this.lockTime = lockTime;
		this.staffId = staffId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Date getExpireTimeDown() {
		return expireTimeDown;
	}

	public void setExpireTimeDown(Date expireTimeDown) {
		this.expireTimeDown = expireTimeDown;
	}

	
	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public Blacklist(String blacklistId, String vesselName, Date expireTime,
			String reason, Date lockTime, String staffId, Date expireTimeDown) {
		super();
		this.blacklistId = blacklistId;
		this.vesselName = vesselName;
		this.expireTime = expireTime;
		this.reason = reason;
		this.lockTime = lockTime;
		this.staffId = staffId;
		this.expireTimeDown = expireTimeDown;
	}

	@Override
	public String toString() {
		return "Blacklist [blacklistId=" + blacklistId + ", vesselName=" + vesselName + ", expireTime=" + expireTime
				+ ", reason=" + reason + ", lockTime=" + lockTime + ", staffId=" + staffId + ", expireTimeDown="
				+ expireTimeDown + ", stationId=" + stationId + "]";
	}
    
	
	
}
