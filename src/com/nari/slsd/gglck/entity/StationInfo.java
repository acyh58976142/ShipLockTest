package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="station")//指明User实体对应的表名称，如果是同名的,可以不写 
public class StationInfo
{
	private String stationId;               //闸所编号 */
	private String staPho;//电话
	private String staName; //名称
	private String simpleName;//简名
	private String staAddr;//地址
	private String staDes;  //简介
	private String staCmmt;    //备注             	    
	private String ext1;            	 
	private String ext2;   
	
	private String staOnTagLine;//上闸首标记线  	 
	private String staUnderTagLine;//下闸首标记线
	private String staLocationCoordinates;// 船闸地理位置坐标        	 
	private String staLocationOrder;//上下游显示顺序
	private int staIsFees;      // 是否缴费  0否 1是     	 
	private String staOnLandmarks;//上锚地标记线
	private String staUnderLandmarks;//下锚地标记线	
	private int isActive;//是否启用 0  否 1  是
	private String upRunMode;//上游运行模式
	private String downRunMode;//下游运行模式
	private String regMode;//登记模式
	private String dispatchMode;//调度模式
	private String lockageConfirmMode;//过闸 确认模式
	
	public StationInfo() {
		super();
	}

	@Id
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getStaPho() {
		return staPho;
	}

	public void setStaPho(String staPho) {
		this.staPho = staPho;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public String getStaAddr() {
		return staAddr;
	}

	public void setStaAddr(String staAddr) {
		this.staAddr = staAddr;
	}

	public String getStaDes() {
		return staDes;
	}

	public void setStaDes(String staDes) {
		this.staDes = staDes;
	}

	public String getStaCmmt() {
		return staCmmt;
	}

	public void setStaCmmt(String staCmmt) {
		this.staCmmt = staCmmt;
	}

	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getStaOnTagLine() {
		return staOnTagLine;
	}

	public void setStaOnTagLine(String staOnTagLine) {
		this.staOnTagLine = staOnTagLine;
	}

	public String getStaUnderTagLine() {
		return staUnderTagLine;
	}

	public void setStaUnderTagLine(String staUnderTagLine) {
		this.staUnderTagLine = staUnderTagLine;
	}

	public String getStaLocationCoordinates() {
		return staLocationCoordinates;
	}

	public void setStaLocationCoordinates(String staLocationCoordinates) {
		this.staLocationCoordinates = staLocationCoordinates;
	}

	public String getStaLocationOrder() {
		return staLocationOrder;
	}

	public void setStaLocationOrder(String staLocationOrder) {
		this.staLocationOrder = staLocationOrder;
	}

	

	public String getStaOnLandmarks() {
		return staOnLandmarks;
	}

	public void setStaOnLandmarks(String staOnLandmarks) {
		this.staOnLandmarks = staOnLandmarks;
	}

	public String getStaUnderLandmarks() {
		return staUnderLandmarks;
	}

	public void setStaUnderLandmarks(String staUnderLandmarks) {
		this.staUnderLandmarks = staUnderLandmarks;
	}

	

	public String getUpRunMode() {
		return upRunMode;
	}

	public void setUpRunMode(String upRunMode) {
		this.upRunMode = upRunMode;
	}

	public String getDownRunMode() {
		return downRunMode;
	}

	public void setDownRunMode(String downRunMode) {
		this.downRunMode = downRunMode;
	}

	public String getRegMode() {
		return regMode;
	}

	public void setRegMode(String regMode) {
		this.regMode = regMode;
	}

	
	public int getStaIsFees() {
		return staIsFees;
	}

	public void setStaIsFees(int staIsFees) {
		this.staIsFees = staIsFees;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getDispatchMode() {
		return dispatchMode;
	}

	public void setDispatchMode(String dispatchMode) {
		this.dispatchMode = dispatchMode;
	}

	public String getLockageConfirmMode() {
		return lockageConfirmMode;
	}

	public void setLockageConfirmMode(String lockageConfirmMode) {
		this.lockageConfirmMode = lockageConfirmMode;
	}

	public String getSimpleName() {
		return simpleName;
	}

	public void setSimpleName(String simpleName) {
		this.simpleName = simpleName;
	}
}
