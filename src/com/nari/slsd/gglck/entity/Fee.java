package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;


/**
 * 缴费信息表
 * @author squirrel
 */
@Entity
@Table(name="fee")//指明实体对应的表名称，如果是同名的,可以不写 
public class Fee{
	private String feeId;          // 缴费Id */
	private String registerId;     // 登记Id */
	private String vesselName;     // 船名 */
	private String workGroupName;  // 工班名称 */
	private String workGroupBatch; // 班次信息 */
	private Integer location;      // 上下游（0=上游   1=下游） */
	private Integer isFleet;       // 是否船队(0否 1是) */
	private String conductorId;    // 售票人Id */
	private String invoiceNum;     // 发票号码 */
	private Date feeTime;          // 缴费时间 */
	private String feeState;       // 缴费状态(1已缴费 2待缴费 3已退费 4待退费5已销号) */
	private String feeType;        // 缴费类型(1过闸费 2.查补闸费 3提放费) */
	private String feeChannel;     // 缴费方式【POS,现金,网银】 */
	private Double lockFee;        // 应收闸费 */
	private Double realFee;        // 实收闸费 */
	private String ext1;           // 扩展1 */
	private String ext2;           // 扩展2 */
	private String stationId;	   // 站点ID*/
	private String oldFeeId;	   // 原费用ID */
	/*--POS新增字段--*/
	private String feeflowId;           // 缴费记录的流水号
	private String bankflowId;	   // 银行返回的流水号
	private String exchangeTime;	   // 刷卡时间
	private String card;	//银行卡号
	
	private Double stadd_lckg_ra;//标准闸费-应收
	private Double ovr_ld_fee_ra;//超载费-应收
	private Double ovr_lw_fee_ra;//超长宽费-应收
	private Double dagr_fee_ra;//危险品货物加收费-应收
	private Double stadd_lckg_all;//标准闸费-合计
	private Double ovr_ld_fee_all;//超载费-合计
	private Double ovr_lw_fee_all;//超长宽费-合计
	private Double dagr_fee_all;//危险品货物加收费-合计
	private Double amount_fee_all;//费用总计-合计
	
	
	public Fee(String feeId, String registerId, String vesselName,
			String workGroupName, String workGroupBatch, Integer location,
			Integer isFleet, String conductorId, String invoiceNum,
			Date feeTime, String feeState, String feeType, String feeChannel,
			Double lockFee, Double realFee, String ext1, String ext2,
			String stationId, String oldFeeId, String feeflowId,
			String bankflowId, String exchangeTime, String card) {
		super();
		this.feeId = feeId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
		this.location = location;
		this.isFleet = isFleet;
		this.conductorId = conductorId;
		this.invoiceNum = invoiceNum;
		this.feeTime = feeTime;
		this.feeState = feeState;
		this.feeType = feeType;
		this.feeChannel = feeChannel;
		this.lockFee = lockFee;
		this.realFee = realFee;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.stationId = stationId;
		this.oldFeeId = oldFeeId;
		this.feeflowId = feeflowId;
		this.bankflowId = bankflowId;
		this.exchangeTime = exchangeTime;
		this.card = card;
	}

	public Fee(String feeId, String registerId, String vesselName, Integer location, Integer isFleet, String feeState,
			String feeType, Double lockFee, String oldFeeId,String feeChannel) {
		super();
		this.feeId = feeId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.location = location;
		this.isFleet = isFleet;
		this.feeState = feeState;
		this.feeType = feeType;
		this.feeChannel = feeChannel;
		this.lockFee = lockFee;
		this.oldFeeId = oldFeeId;
	}

	public Fee() {
		super();
	}

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="feeId")
	/** 缴费Id */
	public String getFeeId() {
		return feeId;
	}

	/** 缴费Id */
	public void setFeeId(String feeId) {
		this.feeId = feeId;
	}

	/** 登记Id */
	public String getRegisterId() {
		return registerId;
	}

	/** 登记Id */
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	/** 船名 */
	public String getVesselName() {
		return vesselName;
	}

	/** 船名 */
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	/** 工班名称 */
	public String getWorkGroupName() {
		return workGroupName;
	}

	/** 工班名称 */
	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}

	/** 班次信息 */
	public String getWorkGroupBatch() {
		return workGroupBatch;
	}

	/** 班次信息 */
	public void setWorkGroupBatch(String workGroupBatch) {
		this.workGroupBatch = workGroupBatch;
	}

	/** 上下游（0=上游   1=下游） */
	public Integer getLocation() {
		return location;
	}

	/** 上下游（0=上游   1=下游） */
	public void setLocation(Integer location) {
		this.location = location;
	}

	/** 是否船队 */
	public Integer getIsFleet() {
		return isFleet;
	}

	/** 是否船队 */
	public void setIsFleet(Integer isFleet) {
		this.isFleet = isFleet;
	}

	/** 售票人Id */
	public String getConductorId() {
		return conductorId;
	}

	/** 售票人Id */
	public void setConductorId(String conductorId) {
		this.conductorId = conductorId;
	}

	/** 发票号码 */
	public String getInvoiceNum() {
		return invoiceNum;
	}

	/** 发票号码 */
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	/** 缴费时间 */
	public Date getFeeTime() {
		return feeTime;
	}

	/** 缴费时间 */
	public void setFeeTime(Date feeTime) {
		this.feeTime = feeTime;
	}

	/** 缴费状态(1已缴费 2代缴费)  */
	public String getFeeState() {
		return feeState;
	}

	/** 缴费状态(1已缴费 2代缴费)  */
	public void setFeeState(String feeState) {
		this.feeState = feeState;
	}

	/** 缴费类型 */
	public String getFeeType() {
		return feeType;
	}

	/** 缴费类型 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	/** 缴费方式【POS,现金,网银】 */
	public String getFeeChannel() {
		return feeChannel;
	}

	/** 缴费方式【POS,现金,网银】 */
	public void setFeeChannel(String feeChannel) {
		this.feeChannel = feeChannel;
	}

	/** 应收闸费 */
	public Double getLockFee() {
		return lockFee;
	}

	/** 应收闸费 */
	public void setLockFee(Double lockFee) {
		this.lockFee = lockFee;
	}

	/** 实收闸费 */
	public Double getRealFee() {
		return realFee;
	}

	/** 实收闸费 */
	public void setRealFee(Double realFee) {
		this.realFee = realFee;
	}

	/** 扩展1 */
	public String getExt1() {
		return ext1;
	}

	/** 扩展1 */
	public void setExt1(String ext1) {
		this.ext1 = ext1;
	}

	/** 扩展2 */
	public String getExt2() {
		return ext2;
	}

	/** 扩展2 */
	public void setExt2(String ext2) {
		this.ext2 = ext2;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getOldFeeId() {
		return oldFeeId;
	}

	public void setOldFeeId(String oldFeeId) {
		this.oldFeeId = oldFeeId;
	}

	public Fee(String feeId, String registerId, String vesselName, String workGroupName, String workGroupBatch,
			Integer location, Integer isFleet, String conductorId, String invoiceNum, Date feeTime, String feeState,
			String feeType, String feeChannel, Double lockFee, Double realFee, String ext1, String ext2,
			String stationId, String oldFeeId) {
		super();
		this.feeId = feeId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
		this.location = location;
		this.isFleet = isFleet;
		this.conductorId = conductorId;
		this.invoiceNum = invoiceNum;
		this.feeTime = feeTime;
		this.feeState = feeState;
		this.feeType = feeType;
		this.feeChannel = feeChannel;
		this.lockFee = lockFee;
		this.realFee = realFee;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.stationId = stationId;
		this.oldFeeId = oldFeeId;
	}

	public String getFeeflowId() {
		return feeflowId;
	}

	public void setFeeflowId(String feeflowId) {
		this.feeflowId = feeflowId;
	}

	public String getBankflowId() {
		return bankflowId;
	}

	public void setBankflowId(String bankflowId) {
		this.bankflowId = bankflowId;
	}

	public String getExchangeTime() {
		return exchangeTime;
	}

	public void setExchangeTime(String exchangeTime) {
		this.exchangeTime = exchangeTime;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Double getStadd_lckg_ra() {
		return stadd_lckg_ra;
	}

	public void setStadd_lckg_ra(Double stadd_lckg_ra) {
		this.stadd_lckg_ra = stadd_lckg_ra;
	}

	public Double getOvr_ld_fee_ra() {
		return ovr_ld_fee_ra;
	}

	public void setOvr_ld_fee_ra(Double ovr_ld_fee_ra) {
		this.ovr_ld_fee_ra = ovr_ld_fee_ra;
	}

	public Double getOvr_lw_fee_ra() {
		return ovr_lw_fee_ra;
	}

	public void setOvr_lw_fee_ra(Double ovr_lw_fee_ra) {
		this.ovr_lw_fee_ra = ovr_lw_fee_ra;
	}

	public Double getDagr_fee_ra() {
		return dagr_fee_ra;
	}

	public void setDagr_fee_ra(Double dagr_fee_ra) {
		this.dagr_fee_ra = dagr_fee_ra;
	}

	public Double getStadd_lckg_all() {
		return stadd_lckg_all;
	}

	public void setStadd_lckg_all(Double stadd_lckg_all) {
		this.stadd_lckg_all = stadd_lckg_all;
	}

	public Double getOvr_ld_fee_all() {
		return ovr_ld_fee_all;
	}

	public void setOvr_ld_fee_all(Double ovr_ld_fee_all) {
		this.ovr_ld_fee_all = ovr_ld_fee_all;
	}

	public Double getOvr_lw_fee_all() {
		return ovr_lw_fee_all;
	}

	public void setOvr_lw_fee_all(Double ovr_lw_fee_all) {
		this.ovr_lw_fee_all = ovr_lw_fee_all;
	}

	public Double getDagr_fee_all() {
		return dagr_fee_all;
	}

	public void setDagr_fee_all(Double dagr_fee_all) {
		this.dagr_fee_all = dagr_fee_all;
	}

	public Double getAmount_fee_all() {
		return amount_fee_all;
	}

	public void setAmount_fee_all(Double amount_fee_all) {
		this.amount_fee_all = amount_fee_all;
	}
	
	

}
