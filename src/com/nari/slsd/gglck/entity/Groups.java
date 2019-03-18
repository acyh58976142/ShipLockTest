package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 岗位实体类
 * @author dhx
 */
@Entity
@Table(name="groups")
public class Groups {
	private String groupId;     			// 岗位Id   nvarchar(32) NOT NULL ,
	private String groupName;     			// 岗位名称   nvarchar(32) NULL ,
	private String ipAddr;     				// IP地址   nvarchar(32) NULL ,
	private String stationId;     			// 船闸所Id  nvarchar(32) NULL ,
	private String LockNo;
	private String    location;
	private Integer    isSpecial;//特殊岗位（0 否，1 是）
	private Integer groupSeq;//索引
	private Integer    isFee;//是否收费
	
	public Groups() {}

	public Groups(String groupId, String groupName, String ipAddr, String stationId) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.ipAddr = ipAddr;
		this.stationId = stationId;
	}

	
	
	/** 岗位ID 主键  */
	@Id 
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getIpAddr() {
		return ipAddr;
	}
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getLockNo() {
		return LockNo;
	}

	public void setLockNo(String lockNo) {
		LockNo = lockNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(Integer isSpecial) {
		this.isSpecial = isSpecial;
	}
	
	public Integer getIsFee() {
		return isFee;
	}

	public void setIsFee(Integer isFee) {
		this.isFee = isFee;
	}

	public int getGroupSeq() {
		return groupSeq;
	}
	public void setGroupSeq(Integer groupSeq) {
		this.groupSeq = groupSeq;
	}
	
}
