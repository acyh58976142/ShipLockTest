package com.nari.slsd.gglck.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MMSI的有效日期
 * @author zsq
 */
@Entity
@Table(name="wx_white_list")
public class WhiteList implements Serializable
{
	private String whitelistId;//白名单ID
	private String vesselName;//船名
	private Date effectiveDate;//有效期
	private String userId;//用户ID
	private Date updateTime;//操作时间

	public WhiteList() {
		super();
	}

	public WhiteList(String whitelistId, String vesselName, Date effectiveDate,
			String userId, Date updateTime) {
		super();
		this.whitelistId = whitelistId;
		this.vesselName = vesselName;
		this.effectiveDate = effectiveDate;
		this.userId = userId;
		this.updateTime = updateTime;
	}

	@Id
	public String getWhitelistId() {
		return whitelistId;
	}
	public void setWhitelistId(String whitelistId) {
		this.whitelistId = whitelistId;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
