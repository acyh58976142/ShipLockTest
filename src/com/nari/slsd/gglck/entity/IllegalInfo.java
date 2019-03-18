package com.nari.slsd.gglck.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 违章信息
 * @author cs
 *
 */
@Entity
@Table(name="illegal_info")//指明IllegalInfo实体对应的表名称，如果是同名的,可以不写 
public class IllegalInfo{
	
	private String illegalId;			//违章ID	 		nvarchar(32) NOT NULL ,
	private String vesselName;			//船名	 		nvarchar(64) NULL ,
	private String vesselId;			//船舶ID	 		nvarchar(32) NULL ,
	private String registerId;		    //登记ID	        nvarchar(32) NULL ,
	private String telephone;			//手机号码    	    nvarchar(16) NULL , 
	private Integer isHandle;		    //是否处理(1待审批 2已审批  3违章已取消(驳回）4待缴费 5已缴费 )	tinyint NULL  ,
	private String stationId;			//录入违章信息人 所在船闸所ID	 		nvarchar(32) NULL ,
	private String illegalPerson;       //违章人			nvarchar(32) NULL ,
	private Date   illegalTime;         //违章时间                              datetime,
	private String ext1;				//预留1	 		nvarchar(256) NULL ,
	private String ext2;				//预留2	 		nvarchar(256) NULL ,
	private String registerCode;		//登记号			nvarchar(32) 
	private String violationType;		//违章类型
	private String processingMethod;	//处理方式
	private Double penaltyAmount;			//处罚金额
	private String  inputPerson;      	//录入人 
	private Date  inputTime;			//录入时间
	private String approver;			//审批人员
	private Date approverTime;			//审批时间
	private String approverStationId;   //审批人所在船闸所
	private String  chargePerson;       //收费人
	private Date    chargeTime;    		//收费时间 
	private  String chargeStationId;   	//收费人所在船闸所
	private  String violationSituation; //违章情况
	private  String approvalOpinion;  	//审批意见
	private String invoiceCode; 		//发票编码
	private String feeChannel;				//缴费方式
	private String workClass;				//工班
	private String shift;					//班次
	private String location;				//上下游
	public IllegalInfo() {}

	@Id 
    @Column(name="illegalId")
	public String getIllegalId() {
		return illegalId;
	}

	public void setIllegalId(String illegalId) {
		this.illegalId = illegalId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getVesselId() {
		return vesselId;
	}

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}
	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getIsHandle() {
		return isHandle;
	}

	public void setIsHandle(Integer isHandle) {
		this.isHandle = isHandle;
	}
	
	public String getIllegalPerson() {
		return illegalPerson;
	}

	public void setIllegalPerson(String illegalPerson) {
		this.illegalPerson = illegalPerson;
	}

	public Date getIllegalTime() {
		return illegalTime;
	}

	public void setIllegalTime(Date illegalTime) {
		this.illegalTime = illegalTime;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
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

	public String getRegisterCode() {
		return registerCode;
	}

	public void setRegisterCode(String registerCode) {
		this.registerCode = registerCode;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public String getProcessingMethod() {
		return processingMethod;
	}

	public void setProcessingMethod(String processingMethod) {
		this.processingMethod = processingMethod;
	}


	public Double getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(Double penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}

	public String getInputPerson() {
		return inputPerson;
	}

	public void setInputPerson(String inputPerson) {
		this.inputPerson = inputPerson;
	}

	public Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public Date getApproverTime() {
		return approverTime;
	}

	public void setApproverTime(Date approverTime) {
		this.approverTime = approverTime;
	}

	public String getApproverStationId() {
		return approverStationId;
	}

	public void setApproverStationId(String approverStationId) {
		this.approverStationId = approverStationId;
	}

	public String getChargePerson() {
		return chargePerson;
	}

	public void setChargePerson(String chargePerson) {
		this.chargePerson = chargePerson;
	}

	public Date getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}

	public String getChargeStationId() {
		return chargeStationId;
	}

	public void setChargeStationId(String chargeStationId) {
		this.chargeStationId = chargeStationId;
	}

	public String getViolationSituation() {
		return violationSituation;
	}

	public void setViolationSituation(String violationSituation) {
		this.violationSituation = violationSituation;
	}

	public String getApprovalOpinion() {
		return approvalOpinion;
	}

	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	

	public String getFeeChannel() {
		return feeChannel;
	}

	public void setFeeChannel(String feeChannel) {
		this.feeChannel = feeChannel;
	}

	public String getWorkClass() {
		return workClass;
	}

	public void setWorkClass(String workClass) {
		this.workClass = workClass;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	
}
