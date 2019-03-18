package com.nari.slsd.gglck.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 登记信息
 * @author wangcaichao
 */
@Entity
@Table(name="register")//指明User实体对应的表名称，如果是同名的,可以不写 
public class Register implements Serializable
{
	private String registerId;			//登记信息ID
	private String registerNum;			//登记号
	private Integer registerType;		//登记方式(0人工 1自动)
	private String fleetName;			//船(队)名
	private String cargoType;			//载货类型
	private String cargoValue;			//载货品种
	private Integer bargeNum;			//驳船数
	private Double fleetTotalLgth;		//船队总长
	private Double dragHeadTns;			//拖头吨位
	private Double dragHeadLgth;		//拖头总长(船长)
	private Double dragHeadBrd;			//拖头总宽（船宽）
	private Integer isDangerous;		//是否危险品(0否 1是)
	private Double tonnageTns;			//准载吨位
	private Double loadTns;				//实载吨位
	private Double overLoadTns;			//超载吨位
	private Double lockFee;				//应收闸费
	private String shipOwner;			//船主
	private String phoneNumber;			//手机号码
	private Integer location;			//上下游上下游(0上游 1下游)
	private String registrantId;		//登记人Id
	private Date registerTime;			//登记时间
	private String feeBase;				//计费基数
	private Double LBP;					//型长	
	private Double MB;					//型宽
	private Double MD;					//型深
	private Integer isOverWidth;		//是否超宽(0否 1是)
	private Integer isNoLoad;			//是否空载(0否 1是)
	private String overloadStandard;	//超载标准
	private String workGroupName;		//工班名称
	private String workGroupBatch;		//班次信息
	private String vesselType;			//船舶类型(1普通单机船，2普通船队，3危险品单机船，4危险品船队)
	private String mmsi;				//九位码
	private String company;				//航运公司
	private String ext1;				//预留1
	private String ext2;				//预留2
	
	//2017-01-07 新增字段
	private String startingPlace;		//出发地
	private String arriving;			//抵达地
	private String stationId;			//船闸所ID
	private String voyageNumber;		//航次ID
	private String subsequentLock;		//后续船闸
	private String waybillID;			//运单ID
	//2017-01-09 新增字段
	private Integer lockFrequency;		//闸次(船队分几个闸次通过,只看)
	//2017-01-10 新增字段
	private Integer isFleet;			//是否船队(0否,单机船 1是船队)
	//2017-01-20 新增字段
	private String maxVesselWidth;		//最大船宽
	
	private String overLengthWide;//超长宽级别
	private Double draught;//船舶吃水
	private String registerStationId;//登记船闸
	private Integer isArchives;			//是否无档案(0否 1是)
	private String vesselSubType;//船舶
    public Register() {}
	
	public Register(String registerId, String registerNum, Integer registerType, String fleetName, String cargoType,
			String cargoValue, Integer bargeNum, Double fleetTotalLgth, Double dragHeadTns,
			Double dragHeadLgth, Double dragHeadBrd, Integer isDangerous, Double tonnageTns,
			Double loadTns, Double overLoadTns, Double lockFee, String shipOwner, String phoneNumber, Integer location,
			String registrantId, Date registerTime, String feeBase, Double lBP, Double mB, Double mD,
			Integer isOverWidth, Integer isNoLoad, String overloadStandard, String workGroupName, String workGroupBatch,
			String vesselType, String mmsi, String company, String ext1, String ext2, String startingPlace,
			String arriving, String stationId, String voyageNumber, String subsequentLock, String waybillID,
			Integer lockFrequency, Integer isFleet, String maxVesselWidth) {
		this.registerId = registerId;
		this.registerNum = registerNum;
		this.registerType = registerType;
		this.fleetName = fleetName;
		this.cargoType = cargoType;
		this.cargoValue = cargoValue;
		this.bargeNum = bargeNum;
		this.fleetTotalLgth = fleetTotalLgth;
		this.dragHeadTns = dragHeadTns;
		this.dragHeadLgth = dragHeadLgth;
		this.dragHeadBrd = dragHeadBrd;
		this.isDangerous = isDangerous;
		this.tonnageTns = tonnageTns;
		this.loadTns = loadTns;
		this.overLoadTns = overLoadTns;
		this.lockFee = lockFee;
		this.shipOwner = shipOwner;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.registrantId = registrantId;
		this.registerTime = registerTime;
		this.feeBase = feeBase;
		LBP = lBP;
		MB = mB;
		MD = mD;
		this.isOverWidth = isOverWidth;
		this.isNoLoad = isNoLoad;
		this.overloadStandard = overloadStandard;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
		this.vesselType = vesselType;
		this.mmsi = mmsi;
		this.company = company;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.startingPlace = startingPlace;
		this.arriving = arriving;
		this.stationId = stationId;
		this.voyageNumber = voyageNumber;
		this.subsequentLock = subsequentLock;
		this.waybillID = waybillID;
		this.lockFrequency = lockFrequency;
		this.isFleet = isFleet;
		this.maxVesselWidth = maxVesselWidth;
	}

	@Id 
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="registerId")
    public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	
	@Column(name="registerNum")
	public String getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}
	
	
	@Column(name="cargoType")
	public String getCargoType() {
		return cargoType;
	}
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	
	@Column(name="cargoValue")
	public String getCargoValue() {
		return cargoValue;
	}
	public void setCargoValue(String cargoValue) {
		this.cargoValue = cargoValue;
	}
	
	
	@Column(name="isDangerous")
	public Integer getIsDangerous() {
		return isDangerous;
	}
	public void setIsDangerous(Integer isDangerous) {
		this.isDangerous = isDangerous;
	}
	
	@Column(name="tonnageTns")
	public Double getTonnageTns() {
		return tonnageTns;
	}
	public void setTonnageTns(Double tonnageTns) {
		this.tonnageTns = tonnageTns;
	}
	
	@Column(name="loadTns")
	public Double getLoadTns() {
		return loadTns;
	}
	public void setLoadTns(Double loadTns) {
		this.loadTns = loadTns;
	}
	
	@Column(name="overLoadTns")
	public Double getOverLoadTns() {
		return overLoadTns;
	}
	public void setOverLoadTns(Double overLoadTns) {
		this.overLoadTns = overLoadTns;
	}
	
	@Column(name="LBP")
	public Double getLBP() {
		return LBP;
	}
	public void setLBP(Double lBP) {
		LBP = lBP;
	}
	
	@Column(name="MB")
	public Double getMB() {
		return MB;
	}
	public void setMB(Double mB) {
		MB = mB;
	}
	
	@Column(name="MD")
	public Double getMD() {
		return MD;
	}
	public void setMD(Double mD) {
		MD = mD;
	}
	
	@Column(name="isOverWidth")
	public Integer getIsOverWidth() {
		return isOverWidth;
	}
	public void setIsOverWidth(Integer isOverWidth) {
		this.isOverWidth = isOverWidth;
	}
	
	@Column(name="isNoLoad")
	public Integer getIsNoLoad() {
		return isNoLoad;
	}
	public void setIsNoLoad(Integer isNoLoad) {
		this.isNoLoad = isNoLoad;
	}
	
	@Column(name="overloadStandard")
	public String getOverloadStandard() {
		return overloadStandard;
	}
	public void setOverloadStandard(String overloadStandard) {
		this.overloadStandard = overloadStandard;
	}
	
	@Column(name="shipOwner")
	public String getShipOwner() {
		return shipOwner;
	}
	public void setShipOwner(String shipOwner) {
		this.shipOwner = shipOwner;
	}
	
	@Column(name="phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="lockFee")
	public Double getLockFee() {
		return lockFee;
	}
	public void setLockFee(Double lockFee) {
		this.lockFee = lockFee;
	}
	
	@Column(name="location")
	public Integer getLocation() {
		return location;
	}
	public void setLocation(Integer location) {
		this.location = location;
	}
	
	@Column(name="registrantId")
	public String getRegistrantId() {
		return registrantId;
	}
	public void setRegistrantId(String registrantId) {
		this.registrantId = registrantId;
	}
	
	@Column(name="registerTime")
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
	@Column(name="feeBase")
	public String getFeeBase() {
		return feeBase;
	}
	public void setFeeBase(String feeBase) {
		this.feeBase = feeBase;
	}
	
	@Column(name="vesselType")
	public String getVesselType() {
		return vesselType;
	}
	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}
	
	@Column(name="ext1")
	public String getExt1() {
		return ext1;
	}
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}
	
	@Column(name="ext2")
	public String getExt2() {
		return ext2;
	}
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}
	
	@Column(name="workGroupName")
	public String getWorkGroupName() {
		return workGroupName;
	}
	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}
	
	@Column(name="workGroupBatch")
	public String getWorkGroupBatch() {
		return workGroupBatch;
	}
	public void setWorkGroupBatch(String workGroupBatch) {
		this.workGroupBatch = workGroupBatch;
	}
	
	@Column(name="registerType")
	public Integer getRegisterType() {
		return registerType;
	}
	public void setRegisterType(Integer registerType) {
		this.registerType = registerType;
	}
	
	@Column(name="fleetName")
	public String getFleetName() {
		return fleetName;
	}
	public void setFleetName(String fleetName) {
		this.fleetName = fleetName;
	}
	
	@Column(name="bargeNum")
	public Integer getBargeNum() {
		return bargeNum;
	}
	public void setBargeNum(Integer bargeNum) {
		this.bargeNum = bargeNum;
	}
	
	@Column(name="fleetTotalLgth")
	public Double getFleetTotalLgth() {
		return fleetTotalLgth;
	}
	public void setFleetTotalLgth(Double fleetTotalLgth) {
		this.fleetTotalLgth = fleetTotalLgth;
	}
	
	@Column(name="dragHeadTns")
	public Double getDragHeadTns() {
		return dragHeadTns;
	}
	public void setDragHeadTns(Double dragHeadTns) {
		this.dragHeadTns = dragHeadTns;
	}
	
	@Column(name="dragHeadLgth")
	public Double getDragHeadLgth() {
		return dragHeadLgth;
	}
	public void setDragHeadLgth(Double dragHeadLgth) {
		this.dragHeadLgth = dragHeadLgth;
	}
	
	@Column(name="dragHeadBrd")
	public Double getDragHeadBrd() {
		return dragHeadBrd;
	}
	public void setDragHeadBrd(Double dragHeadBrd) {
		this.dragHeadBrd = dragHeadBrd;
	}
	
	@Column(name="mmsi")
	public String getMmsi() {
		return mmsi;
	}
	public void setMmsi(String mmsi) {
		this.mmsi = mmsi;
	}
	
	@Column(name="company")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Column(name="startingPlace")
	public String getStartingPlace() {
		return startingPlace;
	}
	public void setStartingPlace(String startingPlace) {
		this.startingPlace = startingPlace;
	}
	
	@Column(name="arriving")
	public String getArriving() {
		return arriving;
	}
	public void setArriving(String arriving) {
		this.arriving = arriving;
	}
	
	@Column(name="stationId")
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	
	@Column(name="voyageNumber")
	public String getVoyageNumber() {
		return voyageNumber;
	}
	public void setVoyageNumber(String voyageNumber) {
		this.voyageNumber = voyageNumber;
	}
	
	@Column(name="subsequentLock")
	public String getSubsequentLock() {
		return subsequentLock;
	}
	public void setSubsequentLock(String subsequentLock) {
		this.subsequentLock = subsequentLock;
	}
	
	@Column(name="waybillID")
	public String getWaybillID() {
		return waybillID;
	}
	public void setWaybillID(String waybillID) {
		this.waybillID = waybillID;
	}

	@Column(name="lockFrequency")
	public Integer getLockFrequency() {
		return lockFrequency;
	}

	public void setLockFrequency(Integer lockFrequency) {
		this.lockFrequency = lockFrequency;
	}
	@Column(name="isFleet")
	public Integer getIsFleet() {
		return isFleet;
	}
	
	public void setIsFleet(Integer isFleet) {
		this.isFleet = isFleet;
	}
	
	@Column(name="maxVesselWidth")
	public String getMaxVesselWidth() {
		return maxVesselWidth;
	}

	public void setMaxVesselWidth(String maxVesselWidth) {
		this.maxVesselWidth = maxVesselWidth;
	}

	public String getOverLengthWide() {
		return overLengthWide;
	}

	public void setOverLengthWide(String overLengthWide) {
		this.overLengthWide = overLengthWide;
	}

	public Double getDraught() {
		return draught;
	}

	public void setDraught(Double draught) {
		this.draught = draught;
	}

	public String getRegisterStationId() {
		return registerStationId;
	}

	public void setRegisterStationId(String registerStationId) {
		this.registerStationId = registerStationId;
	}

	public Integer getIsArchives() {
		return isArchives;
	}

	public void setIsArchives(Integer isArchives) {
		this.isArchives = isArchives;
	}

	public String getVesselSubType() {
		return vesselSubType;
	}

	public void setVesselSubType(String vesselSubType) {
		this.vesselSubType = vesselSubType;
	}
	
}
