package com.nari.slsd.gglck.entity;

import java.io.Serializable;

/**
 * Session 对象
 */
public class Session implements Serializable {

	private static final long serialVersionUID = 1L;

	public Session() {
		
	}
	
	/*
	 * 站点id
	 */
	private String stationId;
	/*
	 * 站名
	 */
	private String stationName;
	/*
	 *是否收费 1收费  0 不收费
	 */
	private String isFee;
	
	/**
	 * 上下游
	 */
	private Integer location;
	
	/**
	 * 工班名称
	 */
	private  String workGroupName;
	
	/**
	 * 班次
	 */
	private String WorkGroupBatch;
	
	//接班人
	private String takeName;
	
	private String login_gb;
	
	private String login_bc;
	
	//接班工班
	private String takegb;
	
	//接班班次
	private String takebc;
	
	/**
	 * 接班时间
	 */
	private String TakeOverTime;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/*
	 * 闸室编号
	 */
	private String lockNo;
	
	/*
	 * 岗位Id
	 */
	private String groupId;
	
	private String groupName;
	
	/*
	 * 登录帐号
	 */
	private String userName;
	
	/*
	 * 真实名字
	 */
	private String realName;
	
	/*
	 * 用户密码
	 */
	private String userPwd;
 
	/*
	 * 是否有工班
	 */
	private String isSpecial;
	
	public String getTakeName() {
		return takeName;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getLogin_gb() {
		return login_gb;
	}

	public void setLogin_gb(String login_gb) {
		this.login_gb = login_gb;
	}

	public String getLogin_bc() {
		return login_bc;
	}

	public void setLogin_bc(String login_bc) {
		this.login_bc = login_bc;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void setTakeName(String takeName) {
		this.takeName = takeName;
	}

	public String getTakegb() {
		return takegb;
	}

	public void setTakegb(String takegb) {
		this.takegb = takegb;
	}

	public String getTakebc() {
		return takebc;
	}

	public void setTakebc(String takebc) {
		this.takebc = takebc;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public String getWorkGroupName() {
		return workGroupName;
	}

	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}

	public String getWorkGroupBatch() {
		return WorkGroupBatch;
	}

	public void setWorkGroupBatch(String workGroupBatch) {
		WorkGroupBatch = workGroupBatch;
	}

	public String getTakeOverTime() {
		return TakeOverTime;
	}

	public void setTakeOverTime(String takeOverTime) {
		TakeOverTime = takeOverTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(String isSpecial) {
		this.isSpecial = isSpecial;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getLockNo() {
		return lockNo;
	}

	public void setLockNo(String lockNo) {
		this.lockNo = lockNo;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getIsFee() {
		return isFee;
	}

	public void setIsFee(String isFee) {
		this.isFee = isFee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
