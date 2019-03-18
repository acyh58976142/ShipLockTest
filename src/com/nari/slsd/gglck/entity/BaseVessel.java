package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 单机船注册信息
 * @author zhangpeixin
 *
 */
@Entity
@Table(name="base_vessel")//指明User实体对应的表名称，如果是同名的,可以不写 
public class BaseVessel{
	
	private String vesselId;			//船舶ID	 		nvarchar(32) NOT NULL ,
	private String cargoValue;			//载货品种	 		nvarchar(32) NULL ,
	private String cargoType;			//载货类型	 		nvarchar(32) NULL ,
	private Integer isDangerous;		//是否危险品(0否 1是)	tinyint NULL  ,
	private String vesselName;			//船名(船队名称)	nvarchar(128) NULL ,
	private Double vesselLength;		//船长(拖头总长)	decimal(6,2) NULL  ,
	private Double vesselWidth;			//船宽(拖头总宽)	decimal(6,2) NULL  ,
	private Double MD;					//型深	 		decimal(6,2) NULL  ,
	private Double LBP;					//型长	 		decimal(6,2) NULL  ,
	private Double MB;					//型宽	 		decimal(6,2) NULL  ,
	private Double totalTnng;			//总吨位	 		decimal(8,2) NULL  ,
	private Double tonnageTns;			//准载吨位	 		decimal(8,2) NULL  ,
	private String shipOwner;			//船主	 		nvarchar(64) NULL ,
	private String phoneNumber;			//手机号码	 		nvarchar(32) NULL ,
	private String regUserId;			//注册人ID	 	nvarchar(32) NULL ,
	private Date regTime;				//注册时间	 		datetime NULL ,
	private Date updateTime;			//修改时间	 		datetime NULL ,
	private String updateUserId;		//修改人ID	 	nvarchar(32) NULL ,
	private String shipNation;			//船籍港	 		nvarchar(128) NULL ,
	private String nationMark;			//船籍号	 		nvarchar(64) NULL ,
	private Double lockFee;				//闸费	 		decimal(8,2) NULL  ,
	private String mmsi;				//九位码	 		nvarchar(10) NULL ,
	private String company;				//航运公司	 		nvarchar(128) NULL ,
	private String shipExamCode;		//船检号	 		nvarchar(32) NULL ,
	private String ext1;				//预留1	 		nvarchar(256) NULL ,
	private String ext2;				//预留2	 		nvarchar(256) NULL ,
	private String vesselType;			//船舶类型	 		nvarchar(32) NULL ,
	private Double headTnng;			//拖头吨位	 		decimal(8,2) NULL ,
	private Double emptyTnng;			//空载吨位	 		decimal(8,2) NULL ,
	private String isFleet;				//是否船队(0否,单机船 1是船队)	tinyint NULL ,
	private Integer bargeNum;			//驳船数	 		int NULL ,
	private Integer collection;			//托收托收(0否 1是)	 		int NULL ,
	private String operationCertificate;//运营证	 		nvarchar(64) NULL ,
	private Integer operationType;		//营运类型	 		int NULL ,
	private Integer priorityLevel;		//优先级	 		int NULL ,
	private Integer isInstallTerminal;	//是否终端船舶(0-非终端船 1-北斗 2-ETC)	 int NULL ,
	private String terminalNum;			//终端号	 		nvarchar(64) NULL ,
	private Integer isExempt;			//是否免征(0否 1是)	int NULL ,
	private String shipownerIdNum;		//船主身份证号		nvarchar(32) NULL ,
	private String entryLockPosition;	//录入船闸位置		nvarchar(128) NULL ,
	private Double noLoadDraft;			//空载吃水	 		decimal(6,2) NULL ,
	private Double fullDraft;			//满载吃水	 		decimal(6,2) NULL ,
	private String captainName;			//船长名	 		nvarchar(64) NULL ,
	private String captainPhone;		//船长电话	 		nvarchar(32) NULL ,
	private Double vesselHigh;			//船高	 		decimal(6,2) NULL,
	private Integer isAudit;		    //是否复核(0否 1是)	tinyint NULL  ,
	private Date auditTime;				//复核时间  		datetime NULL ,
	private String auditStaffId;		//复核人ID 		nvarchar(32) NULL 
	public Date getPeriod_validity() {
		return period_validity;
	}

	public void setPeriod_validity(Date period_validity) {
		this.period_validity = period_validity;
	}

	public String getTnng_deck_brd() {
		return tnng_deck_brd;
	}

	public void setTnng_deck_brd(String tnng_deck_brd) {
		this.tnng_deck_brd = tnng_deck_brd;
	}

	public String getTnng_deck_lgth() {
		return tnng_deck_lgth;
	}

	public void setTnng_deck_lgth(String tnng_deck_lgth) {
		this.tnng_deck_lgth = tnng_deck_lgth;
	}

	public String getTo_review_type_dpth() {
		return to_review_type_dpth;
	}

	public void setTo_review_type_dpth(String to_review_type_dpth) {
		this.to_review_type_dpth = to_review_type_dpth;
	}

	public String getTo_review_type_lgth() {
		return to_review_type_lgth;
	}

	public void setTo_review_type_lgth(String to_review_type_lgth) {
		this.to_review_type_lgth = to_review_type_lgth;
	}

	public String getB_dft() {
		return b_dft;
	}

	public void setB_dft(String b_dft) {
		this.b_dft = b_dft;
	}

	public String getFl_typ() {
		return fl_typ;
	}

	public void setFl_typ(String fl_typ) {
		this.fl_typ = fl_typ;
	}

	public String getSta_nm() {
		return sta_nm;
	}

	public void setSta_nm(String sta_nm) {
		this.sta_nm = sta_nm;
	}

	public String getHull_material() {
		return hull_material;
	}

	public void setHull_material(String hull_material) {
		this.hull_material = hull_material;
	}

	public String getCertification_authority() {
		return certification_authority;
	}

	public void setCertification_authority(String certification_authority) {
		this.certification_authority = certification_authority;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public Date getBuilding_date() {
		return building_date;
	}

	public void setBuilding_date(Date building_date) {
		this.building_date = building_date;
	}

	public String getBiling_base() {
		return biling_base;
	}

	public void setBiling_base(String biling_base) {
		this.biling_base = biling_base;
	}

	public String getHost_power() {
		return host_power;
	}

	public void setHost_power(String host_power) {
		this.host_power = host_power;
	}

	public String getFirst_recorded_ship() {
		return first_recorded_ship;
	}

	public void setFirst_recorded_ship(String first_recorded_ship) {
		this.first_recorded_ship = first_recorded_ship;
	}

	public String getReview_ship() {
		return review_ship;
	}

	public void setReview_ship(String review_ship) {
		this.review_ship = review_ship;
	}

	public String getCredit_rating() {
		return credit_rating;
	}

	public void setCredit_rating(String credit_rating) {
		this.credit_rating = credit_rating;
	}

	public String getFreeboard_a() {
		return freeboard_a;
	}

	public void setFreeboard_a(String freeboard_a) {
		this.freeboard_a = freeboard_a;
	}

	public String getFreeboard_b() {
		return freeboard_b;
	}

	public void setFreeboard_b(String freeboard_b) {
		this.freeboard_b = freeboard_b;
	}

	public String getFreeboard_c() {
		return freeboard_c;
	}

	public void setFreeboard_c(String freeboard_c) {
		this.freeboard_c = freeboard_c;
	}

	public String getShipping_a() {
		return shipping_a;
	}

	public void setShipping_a(String shipping_a) {
		this.shipping_a = shipping_a;
	}

	public String getShipping_b() {
		return shipping_b;
	}

	public void setShipping_b(String shipping_b) {
		this.shipping_b = shipping_b;
	}

	public String getShipping_c() {
		return shipping_c;
	}

	public void setShipping_c(String shipping_c) {
		this.shipping_c = shipping_c;
	}

	public String getTo_review_mv_lgth() {
		return to_review_mv_lgth;
	}

	public void setTo_review_mv_lgth(String to_review_mv_lgth) {
		this.to_review_mv_lgth = to_review_mv_lgth;
	}

	public String getTo_review_mv_brd() {
		return to_review_mv_brd;
	}

	public void setTo_review_mv_brd(String to_review_mv_brd) {
		this.to_review_mv_brd = to_review_mv_brd;
	}

	public String getTo_review_mv_hgth() {
		return to_review_mv_hgth;
	}

	public void setTo_review_mv_hgth(String to_review_mv_hgth) {
		this.to_review_mv_hgth = to_review_mv_hgth;
	}

	public String getTo_review_b_dft() {
		return to_review_b_dft;
	}

	public void setTo_review_b_dft(String to_review_b_dft) {
		this.to_review_b_dft = to_review_b_dft;
	}

	public String getTo_review_freeboard() {
		return to_review_freeboard;
	}

	public void setTo_review_freeboard(String to_review_freeboard) {
		this.to_review_freeboard = to_review_freeboard;
	}

	public String getTo_review_tonnage() {
		return to_review_tonnage;
	}

	public void setTo_review_tonnage(String to_review_tonnage) {
		this.to_review_tonnage = to_review_tonnage;
	}

	public String getTo_review_remarks() {
		return to_review_remarks;
	}

	public void setTo_review_remarks(String to_review_remarks) {
		this.to_review_remarks = to_review_remarks;
	}

	public String getWith_certificate_type() {
		return with_certificate_type;
	}

	public void setWith_certificate_type(String with_certificate_type) {
		this.with_certificate_type = with_certificate_type;
	}

	public String getWith_certificate_number() {
		return with_certificate_number;
	}

	public void setWith_certificate_number(String with_certificate_number) {
		this.with_certificate_number = with_certificate_number;
	}

	public String getTo_measure() {
		return to_measure;
	}

	public void setTo_measure(String to_measure) {
		this.to_measure = to_measure;
	}

	private Integer isExistImg;		    //是否存在图片（0无 1有）
	//2017-01-09 新增字段
	private Integer lockFrequency;		//闸次  注册时根据驳船的长宽计算出 闸次(N次可以全部过闸)
	//2017/3/25
	private String pinyin; //拼音搜
	/*
	 * 新增
	 */
	private Date period_validity;//有效期止
	private String tnng_deck_brd;//量吨甲板宽
	private String tnng_deck_lgth;//量吨甲板长
	private String to_review_type_dpth;//复核型深
	private String to_review_type_lgth;//复核型长
	private String b_dft;//空船吊水线
	private String fl_typ;//燃料类型
	private String sta_nm;//注册地
	private String hull_material;//船体材料
	private String certification_authority;//发证机构
	private Date issue_date;//发证日期
	private Date building_date;//建筑日期
	private String  biling_base;//计费基数
	private String  host_power;//主机功率
	private String  first_recorded_ship;//首录船闸所
	private String  review_ship;//复核船闸所
	private String  credit_rating;//信用等级（数据字典）
	private String  freeboard_a;//a航区干舷（毫米）
	private String  freeboard_b;//b航区干舷（毫米）
	private String  freeboard_c;//c航区干舷（毫米）
	private String  shipping_a;//a航区准载吨
	private String  shipping_b;//b航区准载吨
	private String  shipping_c;//c航区准载吨
	private String  to_review_mv_lgth;//复核最大船长
	private String  to_review_mv_brd;//复核最大船宽
	private String  to_review_mv_hgth;//复核最大船高
	private String  to_review_b_dft;//复核吊水线
	private String  to_review_freeboard;//复核干舷
	private String  to_review_tonnage;//复核吨位
	private String  to_review_remarks;//复核备注
	private String  with_certificate_type;//随船人证件类型
	private String  with_certificate_number;//随船人证件号码
	private String  shipyard;//造船厂
	private String  to_measure;//已丈量
	private String  vessel_sub_type;//船舶子类型
	
	private String with_ship;//	随船人
	private String with_phoneNumber;//	随船人手机号码
	private String shipOwner_certificate_type;//	船主证件类型
	private String shipOwner_certificate_number;//	船主证件号码
	private String operation_type;// 营运类型
	private Double net_ton;// 净吨
	private String nuclear_carrying_water;// 核载吃水
	private String to_review_type_width;// 复核型宽
	

	
	public String getWith_ship() {
		return with_ship;
	}

	public void setWith_ship(String with_ship) {
		this.with_ship = with_ship;
	}

	public String getWith_phoneNumber() {
		return with_phoneNumber;
	}

	public void setWith_phoneNumber(String with_phoneNumber) {
		this.with_phoneNumber = with_phoneNumber;
	}

	public String getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}

	public String getNuclear_carrying_water() {
		return nuclear_carrying_water;
	}

	public void setNuclear_carrying_water(String nuclear_carrying_water) {
		this.nuclear_carrying_water = nuclear_carrying_water;
	}

	public String getTo_review_type_width() {
		return to_review_type_width;
	}

	public void setTo_review_type_width(String to_review_type_width) {
		this.to_review_type_width = to_review_type_width;
	}

	public String getShipOwner_certificate_type() {
		return shipOwner_certificate_type;
	}

	public void setShipOwner_certificate_type(String shipOwner_certificate_type) {
		this.shipOwner_certificate_type = shipOwner_certificate_type;
	}

	public String getShipOwner_certificate_number() {
		return shipOwner_certificate_number;
	}

	public void setShipOwner_certificate_number(String shipOwner_certificate_number) {
		this.shipOwner_certificate_number = shipOwner_certificate_number;
	}

	public String getShipyard() {
		return shipyard;
	}

	public void setShipyard(String shipyard) {
		this.shipyard = shipyard;
	}

	public Double getNet_ton() {
		return net_ton;
	}

	public void setNet_ton(Double net_ton) {
		this.net_ton = net_ton;
	}

	public String getVessel_sub_type() {
		return vessel_sub_type;
	}

	public void setVessel_sub_type(String vessel_sub_type) {
		this.vessel_sub_type = vessel_sub_type;
	}

	public BaseVessel() {}
	
	/** 船队用-zpx */
	public BaseVessel(String vesselId, String vesselName,String phoneNumber,
			String shipOwner,Double tonnageTns,Double headTnng,Double vesselLength,Double vesselWidth,Double mD) {
		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.phoneNumber = phoneNumber;
		this.shipOwner = shipOwner;
		this.tonnageTns = tonnageTns;
		this.headTnng = headTnng;
		this.vesselLength = vesselLength;
		this.vesselWidth = vesselWidth;
		this.MD = mD;
	}
	
	/** 船队注册用-cs */
	public BaseVessel(String vesselId,String vesselName,String phoneNumber,String cargoValue,Double vesselLength,
			Double vesselWidth,Double headTnng,Double tonnageTns,Double mD,Integer bargeNum,String regUserId,Date regTime) {
		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.phoneNumber = phoneNumber;
		this.cargoValue = cargoValue;
		this.vesselLength = vesselLength;
		this.vesselWidth = vesselWidth;
		this.headTnng = headTnng;
		this.tonnageTns = tonnageTns;
		this.MD = mD;
		this.bargeNum = bargeNum;
		this.regUserId = regUserId;
		this.regTime = regTime;
	}
	
	
	public BaseVessel(String vesselId, String cargoValue, String cargoType,
			Integer isDangerous, String vesselName, Double vesselLength,
			Double vesselWidth, Double mD, Double lBP, Double mB,
			Double totalTnng, Double tonnageTns, String shipOwner,
			String phoneNumber, String regUserId, Date regTime,
			Date updateTime, String updateUserId, String shipNation,
			String nationMark, Double lockFee, String mmsi, String company,
			String shipExamCode, String ext1, String ext2, String vesselType,
			Double headTnng, Double emptyTnng, String isFleet,
			Integer bargeNum, Integer collection, String operationCertificate,
			Integer operationType, Integer priorityLevel,
			Integer isInstallTerminal, String terminalNum, Integer isExempt,
			String shipownerIdNum, String entryLockPosition,
			Double noLoadDraft, Double fullDraft, String captainName,
			String captainPhone, Double vesselHigh, Integer isAudit,
			Date auditTime, String auditStaffId, Integer isExistImg,
			Integer lockFrequency, String pinyin) {
		super();
		this.vesselId = vesselId;
		this.cargoValue = cargoValue;
		this.cargoType = cargoType;
		this.isDangerous = isDangerous;
		this.vesselName = vesselName;
		this.vesselLength = vesselLength;
		this.vesselWidth = vesselWidth;
		MD = mD;
		LBP = lBP;
		MB = mB;
		this.totalTnng = totalTnng;
		this.tonnageTns = tonnageTns;
		this.shipOwner = shipOwner;
		this.phoneNumber = phoneNumber;
		this.regUserId = regUserId;
		this.regTime = regTime;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.shipNation = shipNation;
		this.nationMark = nationMark;
		this.lockFee = lockFee;
		this.mmsi = mmsi;
		this.company = company;
		this.shipExamCode = shipExamCode;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.vesselType = vesselType;
		this.headTnng = headTnng;
		this.emptyTnng = emptyTnng;
		this.isFleet = isFleet;
		this.bargeNum = bargeNum;
		this.collection = collection;
		this.operationCertificate = operationCertificate;
		this.operationType = operationType;
		this.priorityLevel = priorityLevel;
		this.isInstallTerminal = isInstallTerminal;
		this.terminalNum = terminalNum;
		this.isExempt = isExempt;
		this.shipownerIdNum = shipownerIdNum;
		this.entryLockPosition = entryLockPosition;
		this.noLoadDraft = noLoadDraft;
		this.fullDraft = fullDraft;
		this.captainName = captainName;
		this.captainPhone = captainPhone;
		this.vesselHigh = vesselHigh;
		this.isAudit = isAudit;
		this.auditTime = auditTime;
		this.auditStaffId = auditStaffId;
		this.isExistImg = isExistImg;
		this.lockFrequency = lockFrequency;
		this.pinyin = pinyin;
	}

	@Id 
    @Column(name="vesselId")
	public String getVesselId() {
		return vesselId;
	}
	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}
	public String getCargoValue() {
		return cargoValue;
	}
	public void setCargoValue(String cargoValue) {
		this.cargoValue = cargoValue;
	}
	public String getCargoType() {
		return cargoType;
	}
	public void setCargoType(String cargoType) {
		this.cargoType = cargoType;
	}
	public Integer getIsDangerous() {
		return isDangerous;
	}
	public void setIsDangerous(Integer isDangerous) {
		this.isDangerous = isDangerous;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public Double getVesselLength() {
		return vesselLength;
	}
	public void setVesselLength(Double vesselLength) {
		this.vesselLength = vesselLength;
	}
	public Double getVesselWidth() {
		return vesselWidth;
	}
	public void setVesselWidth(Double vesselWidth) {
		this.vesselWidth = vesselWidth;
	}
	public Double getMD() {
		return MD;
	}
	public void setMD(Double mD) {
		MD = mD;
	}
	public Double getLBP() {
		return LBP;
	}
	public void setLBP(Double lBP) {
		LBP = lBP;
	}
	public Double getMB() {
		return MB;
	}
	public void setMB(Double mB) {
		MB = mB;
	}
	public Double getTotalTnng() {
		return totalTnng;
	}
	public void setTotalTnng(Double totalTnng) {
		this.totalTnng = totalTnng;
	}
	
	public Double getTonnageTns() {
		return tonnageTns;
	}


	public void setTonnageTns(Double tonnageTns) {
		this.tonnageTns = tonnageTns;
	}
	public String getShipOwner() {
		return shipOwner;
	}
	public void setShipOwner(String shipOwner) {
		this.shipOwner = shipOwner;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRegUserId() {
		return regUserId;
	}
	public void setRegUserId(String regUserId) {
		this.regUserId = regUserId;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getShipNation() {
		return shipNation;
	}
	public void setShipNation(String shipNation) {
		this.shipNation = shipNation;
	}
	public String getNationMark() {
		return nationMark;
	}
	public void setNationMark(String nationMark) {
		this.nationMark = nationMark;
	}
	public Double getLockFee() {
		return lockFee;
	}
	public void setLockFee(Double lockFee) {
		this.lockFee = lockFee;
	}
	public String getMmsi() {
		return mmsi;
	}
	public void setMmsi(String mmsi) {
		this.mmsi = mmsi;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getShipExamCode() {
		return shipExamCode;
	}
	public void setShipExamCode(String shipExamCode) {
		this.shipExamCode = shipExamCode;
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
	public String getVesselType() {
		return vesselType;
	}
	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}
	public Double getHeadTnng() {
		return headTnng;
	}
	public void setHeadTnng(Double headTnng) {
		this.headTnng = headTnng;
	}
	public Double getEmptyTnng() {
		return emptyTnng;
	}
	public void setEmptyTnng(Double emptyTnng) {
		this.emptyTnng = emptyTnng;
	}
	public String getIsFleet() {
		return isFleet;
	}
	public void setIsFleet(String isFleet) {
		this.isFleet = isFleet;
	}
	public Integer getBargeNum() {
		return bargeNum;
	}
	public void setBargeNum(Integer bargeNum) {
		this.bargeNum = bargeNum;
	}
	public Integer getCollection() {
		return collection;
	}
	public void setCollection(Integer collection) {
		this.collection = collection;
	}
	public String getOperationCertificate() {
		return operationCertificate;
	}
	public void setOperationCertificate(String operationCertificate) {
		this.operationCertificate = operationCertificate;
	}
	public Integer getOperationType() {
		return operationType;
	}
	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	public Integer getPriorityLevel() {
		return priorityLevel;
	}
	public void setPriorityLevel(Integer priorityLevel) {
		this.priorityLevel = priorityLevel;
	}
	public Integer getIsInstallTerminal() {
		return isInstallTerminal;
	}
	public void setIsInstallTerminal(Integer isInstallTerminal) {
		this.isInstallTerminal = isInstallTerminal;
	}
	public String getTerminalNum() {
		return terminalNum;
	}
	public void setTerminalNum(String terminalNum) {
		this.terminalNum = terminalNum;
	}
	public Integer getIsExempt() {
		return isExempt;
	}
	public void setIsExempt(Integer isExempt) {
		this.isExempt = isExempt;
	}
	public String getShipownerIdNum() {
		return shipownerIdNum;
	}
	public void setShipownerIdNum(String shipownerIdNum) {
		this.shipownerIdNum = shipownerIdNum;
	}
	public String getEntryLockPosition() {
		return entryLockPosition;
	}
	public void setEntryLockPosition(String entryLockPosition) {
		this.entryLockPosition = entryLockPosition;
	}
	public Double getNoLoadDraft() {
		return noLoadDraft;
	}
	public void setNoLoadDraft(Double noLoadDraft) {
		this.noLoadDraft = noLoadDraft;
	}
	public Double getFullDraft() {
		return fullDraft;
	}
	public void setFullDraft(Double fullDraft) {
		this.fullDraft = fullDraft;
	}
	public String getCaptainName() {
		return captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	public String getCaptainPhone() {
		return captainPhone;
	}
	public void setCaptainPhone(String captainPhone) {
		this.captainPhone = captainPhone;
	}
	public Double getVesselHigh() {
		return vesselHigh;
	}
	public void setVesselHigh(Double vesselHigh) {
		this.vesselHigh = vesselHigh;
	}
	
	@Column(name="lockFrequency")
	public Integer getLockFrequency() {
		return lockFrequency;
	}

	public void setLockFrequency(Integer lockFrequency) {
		this.lockFrequency = lockFrequency;
	}
	
	public Integer getIsAudit() {
		return isAudit;
	}


	public void setIsAudit(Integer isAudit) {
		this.isAudit = isAudit;
	}


	public Date getAuditTime() {
		return auditTime;
	}


	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}


	public String getAuditStaffId() {
		return auditStaffId;
	}


	public void setAuditStaffId(String auditStaffId) {
		this.auditStaffId = auditStaffId;
	}

	public Integer getIsExistImg() {
		return isExistImg;
	}

	public void setIsExistImg(Integer isExistImg) {
		this.isExistImg = isExistImg;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	
}
