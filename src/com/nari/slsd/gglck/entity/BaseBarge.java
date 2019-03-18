package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 驳船注册实体
 * @author zpx
 */
@Entity
@Table(name="base_barge")
public class BaseBarge {
	
	private String bargeId;     			// 注册-驳船ID   nvarchar(32) NOT NULL ,
	private String fleetId;     			// 船队ID   nvarchar(32) NULL ,
	private String cargoValue;     			// 载货品种   nvarchar(32) NULL ,
	private String cargoType;     			// 载货类型   nvarchar(32) NULL ,
	private Integer isDangerous;     		// 是否危险品(0否 1是)   tinyint NULL  ,
	private String vesselName;     			// 船名   nvarchar(128) NULL ,
	private Double vesselLength;     		// 船长   decimal(6,2) NULL  ,
	private Double vesselWidth;     		// 船宽   decimal(6,2) NULL  ,
	private Double LBP;     				// 型长   decimal(6,2) NULL  ,
	private Double MD;     					// 型深   decimal(6,2) NULL  ,
	private Double MB;     					// 型宽   decimal(6,2) NULL  ,
	private Double totalTnng;     			// 总吨位   decimal(6,2) NULL  ,
	private Double tonnageTns;     			// 准载吨位   decimal(6,2) NULL  ,
	private String shipOwner;     			// 船主   nvarchar(64) NULL ,
	private String phoneNumber;     		// 手机号码   nvarchar(32) NULL ,
	private String regUserId;     			// 注册人ID   nvarchar(32) NULL ,
	private Date regTime;     				// 注册时间   datetime NULL ,
	private Date updateTime;     			// 修改时间   datetime NULL ,
	private String updateUserId;     		// 修改人ID   nvarchar(32) NULL ,
	private String shipNation;     			// 船籍港   nvarchar(128) NULL ,
	private String nationMark;     			// 船籍号   nvarchar(64) NULL ,
	private Double lockFee;     			// 闸费   decimal(8,2) NULL  ,
	private String mmsi;     				// 九位码   nvarchar(10) NULL ,
	private String company;     			// 航运公司   nvarchar(128) NULL ,
	private String shipExamCode;     		// 船检号   nvarchar(32) NULL ,
	private String ext1;     				//    nvarchar(256) NULL ,
	private String ext2;     				//    nvarchar(256) NULL
	private String isAudit;				//是否复核(0 未复核,1 已复核)
	private String auditStaffId;			//复核人ID
	private Date auditTime;					//复合时间
	private String isExistImg;				//是否存在图片（0无 1有）
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
	private String biling_base;//计费基数
	private String host_power;//主机功率
	private String first_recorded_ship;//首录船闸所
	private String review_ship;//复核船闸所
	private String credit_rating;//信用等级（数据字典）
	private String freeboard_a;//a航区干舷（毫米）
	private String freeboard_b;//b航区干舷（毫米）
	private String freeboard_c;//c航区干舷（毫米）
	private String shipping_a;//a航区准载吨
	private String shipping_b;//b航区准载吨
	private String shipping_c;//c航区准载吨
	private Double to_review_mv_lgth;//复核最大船长
	private Double to_review_mv_brd;//复核最大船宽
	private Double to_review_mv_hgth;//复核最大船高
	private Double to_review_b_dft;//复核吊水线
	private String to_review_freeboard;//复核干舷
	private Double to_review_tonnage;//复核吨位
	private String to_review_remarks;//复核备注
	private String with_certificate_type;//随船人证件类型
	private String with_certificate_number;//随船人证件号码
	private String to_measure;//已丈量
	
	private Double vesselHeight;//	总高
	private String with_ship;//	随船人
	private String with_phoneNumber;//	随船人手机号码
	private String shipOwner_certificate_type;//	船主证件类型
	private String shipOwner_certificate_number;//	船主证件号码
	private String operation_type;// 营运类型
	private Double net_ton;// 净吨
	private String unit_vessel;//	船只所属单位
	private String nuclear_carrying_water;// 核载吃水
	private String to_review_type_width;// 复核型宽
	
	private String shipyard;//造船厂
	
	
	public BaseBarge() {}

	

	public BaseBarge(String bargeId, String fleetId, String cargoValue,
			String cargoType, Integer isDangerous, String vesselName,
			Double vesselLength, Double vesselWidth, Double lBP, Double mD,
			Double mB, Double totalTnng, Double tonnageTns, String shipOwner,
			String phoneNumber, String regUserId, Date regTime,
			Date updateTime, String updateUserId, String shipNation,
			String nationMark, Double lockFee, String mmsi, String company,
			String shipExamCode, String ext1, String ext2, String isAudit,
			String auditStaffId, Date auditTime,String isExistImg,
			Date period_validity,String tnng_deck_brd,
			String tnng_deck_lgth,String to_review_type_dpth,
			String to_review_type_lgth,String b_dft,String fl_typ,String sta_nm,
			String hull_material,String certification_authority,Date issue_date,Date building_date,
			String biling_base,String host_power,String first_recorded_ship,String review_ship,
			String credit_rating,String freeboard_a,String freeboard_b,String freeboard_c,
			String shipping_a,String shipping_b,String shipping_c,Double to_review_mv_lgth,
			Double to_review_mv_brd,Double to_review_mv_hgth,
			Double to_review_b_dft,String to_review_freeboard,Double to_review_tonnage,String to_review_remarks,
			String with_certificate_type,String with_certificate_number,
			String to_measure,Double vesselHeight,String with_ship,String with_phoneNumber,
			String shipOwner_certificate_type,String shipOwner_certificate_number,
			String operation_type,Double net_ton,String unit_vessel,String nuclear_carrying_water,
			String to_review_type_width,String shipyard) {
		super();
		this.bargeId = bargeId;
		this.fleetId = fleetId;
		this.cargoValue = cargoValue;
		this.cargoType = cargoType;
		this.isDangerous = isDangerous;
		this.vesselName = vesselName;
		this.vesselLength = vesselLength;
		this.vesselWidth = vesselWidth;
		this.LBP = lBP;
		this.MD = mD;
		this.MB = mB;
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
		this.isAudit = isAudit;
		this.auditStaffId = auditStaffId;
		this.auditTime = auditTime;
		this.isExistImg=isExistImg;
		
		this.period_validity=period_validity;
		this.tnng_deck_brd=tnng_deck_brd;
		this.tnng_deck_lgth=tnng_deck_lgth;
		this.to_review_type_dpth=to_review_type_dpth;
		this.to_review_type_lgth=to_review_type_lgth;
		this.b_dft=b_dft;
		this.fl_typ=fl_typ;
		this.sta_nm=sta_nm;
		this.hull_material=hull_material;
		this.certification_authority=certification_authority;
		this.issue_date=issue_date;
		this.building_date=building_date;
		this.biling_base=biling_base;
		this.host_power=host_power;
		this.first_recorded_ship=first_recorded_ship;
		this.review_ship=review_ship;
		this.credit_rating=credit_rating;
		this.freeboard_a=freeboard_a;
		this.freeboard_b=freeboard_b;
		this.freeboard_c=freeboard_c;
		this.shipping_a=shipping_a;
		this.shipping_b=shipping_b;
		this.shipping_c=shipping_c;
		this.to_review_mv_lgth=to_review_mv_lgth;
		this.to_review_mv_brd=to_review_mv_brd;
		this.to_review_mv_hgth=to_review_mv_hgth;
		this.to_review_b_dft=to_review_b_dft;
		this.to_review_freeboard=to_review_freeboard;
		this.to_review_tonnage=to_review_tonnage;
		this.to_review_remarks=to_review_remarks;
		this.with_certificate_type=with_certificate_type;
		this.with_certificate_number=with_certificate_number;
		this.to_measure=to_measure;
		this.vesselHeight=vesselHeight;
		this.with_ship=with_ship;
		this.with_phoneNumber=with_phoneNumber;
		this.shipOwner_certificate_type=shipOwner_certificate_type;
		this.shipOwner_certificate_number=shipOwner_certificate_number;
		this.operation_type=operation_type;
		this.net_ton=net_ton;
		this.unit_vessel=unit_vessel;
		this.nuclear_carrying_water=nuclear_carrying_water;
		this.to_review_type_width=to_review_type_width;
		this.shipyard = shipyard;
		
	}



	public String getIsExistImg() {
		return isExistImg;
	}



	public void setIsExistImg(String isExistImg) {
		this.isExistImg = isExistImg;
	}



	/** 驳船ID 主键  */
	@Id 
    @Column(name="bargeId")
	public String getBargeId() {
		return bargeId;
	}

	public void setBargeId(String bargeId) {
		this.bargeId = bargeId;
	}

	public String getFleetId() {
		return fleetId;
	}

	public void setFleetId(String fleetId) {
		this.fleetId = fleetId;
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

	public Double getLBP() {
		return LBP;
	}

	public void setLBP(Double lBP) {
		this.LBP = lBP;
	}

	public Double getMD() {
		return MD;
	}

	public void setMD(Double mD) {
		this.MD = mD;
	}

	public Double getMB() {
		return MB;
	}

	public void setMB(Double mB) {
		this.MB = mB;
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



	public String getIsAudit() {
		return isAudit;
	}



	public void setIsAudit(String isAudit) {
		this.isAudit = isAudit;
	}



	public String getAuditStaffId() {
		return auditStaffId;
	}



	public void setAuditStaffId(String auditStaffId) {
		this.auditStaffId = auditStaffId;
	}



	public Date getAuditTime() {
		return auditTime;
	}



	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}



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






	public String getTo_review_freeboard() {
		return to_review_freeboard;
	}



	public void setTo_review_freeboard(String to_review_freeboard) {
		this.to_review_freeboard = to_review_freeboard;
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



	public String getOperation_type() {
		return operation_type;
	}



	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}

	public String getUnit_vessel() {
		return unit_vessel;
	}



	public void setUnit_vessel(String unit_vessel) {
		this.unit_vessel = unit_vessel;
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



	public Double getTo_review_mv_lgth() {
		return to_review_mv_lgth;
	}



	public void setTo_review_mv_lgth(Double to_review_mv_lgth) {
		this.to_review_mv_lgth = to_review_mv_lgth;
	}



	public Double getTo_review_mv_brd() {
		return to_review_mv_brd;
	}



	public void setTo_review_mv_brd(Double to_review_mv_brd) {
		this.to_review_mv_brd = to_review_mv_brd;
	}



	public Double getTo_review_mv_hgth() {
		return to_review_mv_hgth;
	}



	public void setTo_review_mv_hgth(Double to_review_mv_hgth) {
		this.to_review_mv_hgth = to_review_mv_hgth;
	}



	public Double getTo_review_b_dft() {
		return to_review_b_dft;
	}



	public void setTo_review_b_dft(Double to_review_b_dft) {
		this.to_review_b_dft = to_review_b_dft;
	}



	public Double getTo_review_tonnage() {
		return to_review_tonnage;
	}



	public void setTo_review_tonnage(Double to_review_tonnage) {
		this.to_review_tonnage = to_review_tonnage;
	}



	public Double getVesselHeight() {
		return vesselHeight;
	}



	public void setVesselHeight(Double vesselHeight) {
		this.vesselHeight = vesselHeight;
	}



	public Double getNet_ton() {
		return net_ton;
	}



	public void setNet_ton(Double net_ton) {
		this.net_ton = net_ton;
	}



	public String getShipyard() {
		return shipyard;
	}



	public void setShipyard(String shipyard) {
		this.shipyard = shipyard;
	}
	
	
	
}
