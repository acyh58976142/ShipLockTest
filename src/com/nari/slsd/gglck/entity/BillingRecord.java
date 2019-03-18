package com.nari.slsd.gglck.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 发票信息
 * @author zsq
 */
@Entity
@Table(name="billing_record")
public class BillingRecord implements Serializable
{
	private String billId;//票据ID
	private String oldBillNum; //红冲的原发票号码
	private String serialNum;//流水号
	private String invoiceCode;//发票代码
	private String invoiceNum;//发票号码
	private String invoiceType;//发票类型(1自开，2委托代开)
	private Double feeMoney;//合计金额(闸费不包含税)
	private Double valoremMoney;//价税合计
	private Double scottareMoney;//缴税金额
	private Date feeTime;//售票时间
	private String staffId;//操作人ID
	private Date billTime;//开票时间
	private String invoiceState;//发票状态【0正常，1红冲】
	private String billPdfPath;//票据pdf路径
	private String wxerm;//微信二维码
	private String vesselName;//购买方名称（船名船号）
	private Integer versionFile;//版本文件状态：1有，0无
	private String registerId;//登记ID
	private String feeId;//缴费ID
	private String stationId;//船闸所Id
	private String ext1;//预留1
	private String ext2;//预留2
	private Integer openBillState;//开票状态(0:待开票,1:已请求,2:请求超时,3:开票错误,4:已开，未生成PDF,5:已开，已完成)
	private Integer reCount;//开票次数
	private String errMsg;//错误信息
	private Integer pause;//暂停  0执行     1暂停  默认 0
    private String oldInvoiceCode;//原发票代码
    private String img_path;//PDF转的图片路径
    private String remark;//备注
    private String oldBillId;//原开票记录id
    
    public BillingRecord() {
    	super();
    }
    @Id 
	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getOldBillNum() {
		return oldBillNum;
	}
	public void setOldBillNum(String oldBillNum) {
		this.oldBillNum = oldBillNum;
	}
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Double getFeeMoney() {
		return feeMoney;
	}
	public void setFeeMoney(Double feeMoney) {
		this.feeMoney = feeMoney;
	}
	public Double getValoremMoney() {
		return valoremMoney;
	}
	public void setValoremMoney(Double valoremMoney) {
		this.valoremMoney = valoremMoney;
	}
	
	public Double getScottareMoney() {
		return scottareMoney;
	}
	public void setScottareMoney(Double scottareMoney) {
		this.scottareMoney = scottareMoney;
	}
	public Date getFeeTime() {
		return feeTime;
	}
	public void setFeeTime(Date feeTime) {
		this.feeTime = feeTime;
	}
	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Date getBillTime() {
		return billTime;
	}

	public void setBillTime(Date billTime) {
		this.billTime = billTime;
	}

	public String getInvoiceState() {
		return invoiceState;
	}

	public void setInvoiceState(String invoiceState) {
		this.invoiceState = invoiceState;
	}

	public String getBillPdfPath() {
		return billPdfPath;
	}

	public void setBillPdfPath(String billPdfPath) {
		this.billPdfPath = billPdfPath;
	}
	public String getWxerm() {
		return wxerm;
	}
	public void setWxerm(String wxerm) {
		this.wxerm = wxerm;
	}
	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public Integer getVersionFile() {
		return versionFile;
	}

	public void setVersionFile(Integer versionFile) {
		this.versionFile = versionFile;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getFeeId() {
		return feeId;
	}

	public void setFeeId(String feeId) {
		this.feeId = feeId;
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
	
	public Integer getOpenBillState() {
		return openBillState;
	}
	public void setOpenBillState(Integer openBillState) {
		this.openBillState = openBillState;
	}
	public Integer getReCount() {
		return reCount;
	}
	public void setReCount(Integer reCount) {
		this.reCount = reCount;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Integer getPause() {
		return pause;
	}
	public void setPause(Integer pause) {
		this.pause = pause;
	}
	public String getOldInvoiceCode() {
		return oldInvoiceCode;
	}
	public void setOldInvoiceCode(String oldInvoiceCode) {
		this.oldInvoiceCode = oldInvoiceCode;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOldBillId() {
		return oldBillId;
	}
	public void setOldBillId(String oldBillId) {
		this.oldBillId = oldBillId;
	}
	
}
