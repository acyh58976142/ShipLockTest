package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 船队登记-驳船的实体类
 * @author zpx
 */
@Entity
@Table(name="barge_register")
public class BargeRegister {
	
	private String bargeRegId;      			//登记-驳船ID 		nvarchar(32) NOT NULL ,
	private String registerId;      		//登记Id 		nvarchar(32) NULL ,
	private String fleetName;      			//船队名称 		nvarchar(32) NULL ,
	private String cargoType;      			//载货类型 		nvarchar(64) NULL ,
	private String cargoValue;      			//载货品种 		nvarchar(64) NULL ,
	private String bargeName;      			//驳船名 		nvarchar(64) NULL ,
	private Double tonnageTns;      		//准载吨位 		decimal(6,2) NULL  ,
	private Double loadTns;      			//实载吨位 		decimal(6,2) NULL  ,
	private Double overLoadTns;      		//超载吨位 		decimal(6,2) NULL  ,
	private Double vesselLength;      		//船长 		decimal(6,2) NULL  ,
	private Double vesselWidth;      		//船宽 		decimal(6,2) NULL  ,
	private Double LBP;      				//型长 		decimal(6,2) NULL ,
	private Double MB;      				//型宽 		decimal(6,2) NULL ,
	private Double MD;      				//型深 		decimal(6,2) NULL  ,
	private Integer isDangerous;      		//是否危险品(0否 1是)	int NULL  ,
	private Integer location;      			//上下游(0上游 1下游) tinyint NULL  ,
	private String registrantId;      		//登记人Id 	nvarchar(32) NULL ,
	private Date registerTime;      		//登记时间 		datetime NULL ,
	private String feeBase;      			//计费基数 		nvarchar(64) NULL ,
	private String vesselType;      		//船舶类型 		nvarchar(64) NULL ,
	private String ext1;      				// 			nvarchar(256) NULL ,
	private String ext2;      				// 			nvarchar(256) SPARSE NULL
	
	public BargeRegister() {}

	public BargeRegister(String bargeRegId, String registerId, String fleetName, String cargoType, String cargoValue,
			String bargeName, Double tonnageTns, Double loadTns, Double overLoadTns,
			Double vesselLength, Double vesselWidth, Double lBP, Double mB, Double mD,
			Integer isDangerous, Integer location, String registrantId, Date registerTime, String feeBase,
			String vesselType, String ext1, String ext2) {
		this.bargeRegId = bargeRegId;
		this.registerId = registerId;
		this.fleetName = fleetName;
		this.cargoType = cargoType;
		this.cargoValue = cargoValue;
		this.bargeName = bargeName;
		this.tonnageTns = tonnageTns;
		this.loadTns = loadTns;
		this.overLoadTns = overLoadTns;
		this.vesselLength = vesselLength;
		this.vesselWidth = vesselWidth;
		this.LBP = lBP;
		this.MB = mB;
		this.MD = mD;
		this.isDangerous = isDangerous;
		this.location = location;
		this.registrantId = registrantId;
		this.registerTime = registerTime;
		this.feeBase = feeBase;
		this.vesselType = vesselType;
		this.ext1 = ext1;
		this.ext2 = ext2;
	}
	
	public BargeRegister(String bargeRegId, String registerId, String fleetName, String cargoType, String cargoValue,
			String bargeName, Double tonnageTns,
			Double vesselLength, Double vesselWidth, Double lBP, Double mB, Double mD,
			Integer isDangerous, String registrantId, Date registerTime,
			String vesselType,Integer location) {
		this.bargeRegId = bargeRegId;
		this.registerId = registerId;
		this.fleetName = fleetName;
		this.cargoType = cargoType;
		this.cargoValue = cargoValue;
		this.bargeName = bargeName;
		this.tonnageTns = tonnageTns;
		this.vesselLength = vesselLength;
		this.vesselWidth = vesselWidth;
		this.LBP = lBP;
		this.MB = mB;
		this.MD = mD;
		this.isDangerous = isDangerous;
		this.registrantId = registrantId;
		this.registerTime = registerTime;
		this.vesselType = vesselType;
		this.location = location;
	}

	/** 驳船ID 主键  */
	@Id 
    @Column(name="bargeRegId")
	public String getBargeId() {
		return bargeRegId;
	}

	public void setBargeId(String bargeRegId) {
		this.bargeRegId = bargeRegId;
	}

	/** 登记号  */
	@Column(name="registerId")
	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	/** 船队名称 */
    @Column(name="fleetName")
	public String getFleetName() {
		return fleetName;
	}

	public void setFleetName(String fleetName) {
		this.fleetName = fleetName;
	}

	/** 载货类型 */
    @Column(name="cargoType")
	public String getCargoType() {
		return cargoType;
	}

	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}

	/** 载货品种 */
    @Column(name="cargoValue")
	public String getCargoValue() {
		return cargoValue;
	}

	public void setCargoValue(String cargoValue) {
		this.cargoValue = cargoValue;
	}

	/** 驳船名 */
    @Column(name="bargeName")
	public String getBargeName() {
		return bargeName;
	}

	public void setBargeName(String bargeName) {
		this.bargeName = bargeName;
	}

	/** 准载吨位 */
    @Column(name="tonnageTns")
	public Double getTonnageTns() {
		return tonnageTns;
	}

	public void setTonnageTns(Double tonnageTns) {
		this.tonnageTns = tonnageTns;
	}

	/** 实载吨位 */
    @Column(name="loadTns")
	public Double getLoadTns() {
		return loadTns;
	}

	public void setLoadTns(Double loadTns) {
		this.loadTns = loadTns;
	}

	/** 超载吨位 */
    @Column(name="overLoadTns")
	public Double getOverLoadTns() {
		return overLoadTns;
	}

	public void setOverLoadTns(Double overLoadTns) {
		this.overLoadTns = overLoadTns;
	}

	/** 船长 */
    @Column(name="vesselLength")
	public Double getVesselLength() {
		return vesselLength;
	}

	public void setVesselLength(Double vesselLength) {
		this.vesselLength = vesselLength;
	}

	/** 船宽 */
    @Column(name="vesselWidth")
	public Double getVesselWidth() {
		return vesselWidth;
	}

	public void setVesselWidth(Double vesselWidth) {
		this.vesselWidth = vesselWidth;
	}

	/** 型长 */
    @Column(name="LBP")
	public Double getLBP() {
		return LBP;
	}

	public void setLBP(Double lBP) {
		LBP = lBP;
	}

	/** 型宽 */
    @Column(name="MB")
	public Double getMB() {
		return MB;
	}

	public void setMB(Double mB) {
		MB = mB;
	}

	/** 型深 */
    @Column(name="MD")
	public Double getMD() {
		return MD;
	}

	public void setMD(Double mD) {
		MD = mD;
	}

	/** 是否危险品 */
    @Column(name="isDangerous")
	public Integer getIsDangerous() {
		return isDangerous;
	}

	public void setIsDangerous(Integer isDangerous) {
		this.isDangerous = isDangerous;
	}

	/** 上下游(0=上游   1=下游) */
    @Column(name="location")
	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	/** 登记人Id */
    @Column(name="registrantId")
	public String getRegistrantId() {
		return registrantId;
	}

	public void setRegistrantId(String registrantId) {
		this.registrantId = registrantId;
	}

	/** 登记时间 */
    @Column(name="registerTime")
	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	/** 计费基数 */
    @Column(name="feeBase")
	public String getFeeBase() {
		return feeBase;
	}

	public void setFeeBase(String feeBase) {
		this.feeBase = feeBase;
	}

	/** 船舶类型 */
    @Column(name="vesselType")
	public String getVesselType() {
		return vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

	/**  */
    @Column(name="ext1")
	public String getExt1() {
		return ext1;
	}

	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	/**  */
    @Column(name="ext2")
	public String getExt2() {
		return ext2;
	}

	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	@Override
	public String toString()
	{
		return "BargeRegister [bargeRegId=" + bargeRegId + ", registerId="
				+ registerId + ", fleetName=" + fleetName + ", cargoType="
				+ cargoType + ", cargoValue=" + cargoValue + ", bargeName="
				+ bargeName + ", tonnageTns=" + tonnageTns + ", loadTns="
				+ loadTns + ", overLoadTns=" + overLoadTns + ", vesselLength="
				+ vesselLength + ", vesselWidth=" + vesselWidth + ", LBP="
				+ LBP + ", MB=" + MB + ", MD=" + MD + ", isDangerous="
				+ isDangerous + ", location=" + location + ", registrantId="
				+ registrantId + ", registerTime=" + registerTime
				+ ", feeBase=" + feeBase + ", vesselType=" + vesselType
				+ ", ext1=" + ext1 + ", ext2=" + ext2 + "]";
	}
	
}
