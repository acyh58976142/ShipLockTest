package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 交班管理 实体
 * 
 * @author st
 */
@Entity
@Table(name = "change_shift") // 指明User实体对应的表名称，如果是同名的,可以不写
public class ChangeShift {

	private String workId; // 交接班ID nvarchar(32) NOT NULL ,
	private String groupId; // 岗位Id nvarchar(32) NULL ,
	private String location; // 上下游(0上游 1下游) tinyint NULL ,
	private String lockNo; // 闸室编号 int NULL ,
	private String handOverId; // 值班人(交班人)ID nvarchar(32) NULL ,
	private Date handOverTime; // 交班时间 datetime NULL ,
	private String takeOverId; //  接班人ID nvarchar(32) NULL ,
	private Date takeOverTime; // 接班时间 datetime NULL ,
	private Integer isShift; // 是否交班 tinyint NULL ,
	private Date recordTime; // 记录时间 datetime NULL ,
	private String workGroupName; // 交班工班名称 nvarchar(32) NULL ,
	private String workGroupBatch; // 交班班次信息 nvarchar(32) NULL ,
	private String workGroupName2; // 接班工班名称 nvarchar(32) NULL ,
	private String workGroupBatch2; // 接班班次信息 nvarchar(32) NULL ,
	private String shiftInformation; //值班记录   nvarchar(2000) NULL ,
	private String stationId; //船闸所ID(暂时不用)   nvarchar(32) NULL ,
	private String takeAdvice;//接班意见  nvarchar(512) NULL ,
	private String weather; // 天气  nvarchar(256) NULL ,
	/** 交班ID 主键 */
	
	@Id
	@Column(name = "workId")
	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	/** 岗位Id */
	@Column(name = "groupId")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/** 上下游(0上游 1下游) */
	@Column(name = "location")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	public String getLockNo() {
		return lockNo;
	}

	public void setLockNo(String lockNo) {
		this.lockNo = lockNo;
	}

	/** 交班人班次ID */
	@Column(name = "handOverId")
	public String getHandOverId() {
		return handOverId;
	}

	public void setHandOverId(String handOverId) {
		this.handOverId = handOverId;
	}

	/** 交班时间 */
	@Column(name = "handOverTime")
	public Date getHandOverTime() {
		return handOverTime;
	}

	public void setHandOverTime(Date handOverTime) {
		this.handOverTime = handOverTime;
	}

	/** 接班时间 */
	@Column(name = "takeOverTime")
	public Date getTakeOverTime() {
		return takeOverTime;
	}

	public void setTakeOverTime(Date takeOverTime) {
		this.takeOverTime = takeOverTime;
	}

	/** 是否交班 */
	@Column(name = "isShift")
	public Integer getIsShift() {
		return isShift;
	}

	public void setIsShift(Integer isShift) {
		this.isShift = isShift;
	}

	/** 记录时间 */
	@Column(name = "recordTime")
	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	/** 交班工班名称 */
	@Column(name = "workGroupName")
	public String getWorkGroupName() {
		return workGroupName;
	}

	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}

	/** 交班班次信息 */
	@Column(name = "workGroupBatch")
	public String getWorkGroupBatch() {
		return workGroupBatch;
	}

	public void setWorkGroupBatch(String workGroupBatch) {
		this.workGroupBatch = workGroupBatch;
	}

	/** 接班工班名称 */
	@Column(name = "workGroupName2")
	public String getWorkGroupName2() {
		return workGroupName2;
	}

	public void setWorkGroupName2(String workGroupName2) {
		this.workGroupName2 = workGroupName2;
	}

	/** 接班班次信息 */
	@Column(name = "workGroupBatch2")
	public String getWorkGroupBatch2() {
		return workGroupBatch2;
	}

	public void setWorkGroupBatch2(String workGroupBatch2) {
		this.workGroupBatch2 = workGroupBatch2;
	}
	/** 接班人班次ID*/
	@Column(name = "takeOverId")
	public String getTakeOverId() {
		return takeOverId;
	}

	public void setTakeOverId(String takeOverId) {
		this.takeOverId = takeOverId;
	}

	/**  值班记录   */
	@Column(name = "shiftInformation")
	public String getShiftInformation() {
		return shiftInformation;
	}

	public void setShiftInformation(String shiftInformation) {
		this.shiftInformation = shiftInformation;
	}
	/** 船闸所ID(暂时不用)*/
	@Column(name = "stationId")
	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	/** 接班意见*/
	@Column(name = "takeAdvice")
	public String getTakeAdvice() {
		return takeAdvice;
	}

	public void setTakeAdvice(String takeAdvice) {
		this.takeAdvice = takeAdvice;
	}
	/** 天气*/
	@Column(name = "weather")
	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public ChangeShift() {
		super();

	}

	public ChangeShift(String workId, String groupId, String location, Integer lockNo, String handOverId,
			Date handOverTime, String takeOverId, Date takeOverTime, Integer isShift, Date recordTime,
			String workGroupName, String workGroupBatch, String workGroupName2, String workGroupBatch2,
			String shiftInformation, String stationId, String takeAdvice, String weather) {
		super();
		this.workId = workId;
		this.groupId = groupId;
		this.location = location;
		this.handOverId = handOverId;
		this.handOverTime = handOverTime;
		this.takeOverId = takeOverId;
		this.takeOverTime = takeOverTime;
		this.isShift = isShift;
		this.recordTime = recordTime;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
		this.workGroupName2 = workGroupName2;
		this.workGroupBatch2 = workGroupBatch2;
		this.shiftInformation = shiftInformation;
		this.stationId = stationId;
		this.takeAdvice = takeAdvice;
		this.weather = weather;
	}

	 

	 
	
}