package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 发票信息实体
 */
@Entity
@Table(name="local_invoice")
public class LocalInvoice {

	private String id;  //id            
	private String feeId;       //缴费id,   
	private String invoiceNum;   //发票编号,                    
	private String invoiceMoney; //发票金额,             
	private Date useTime;      //经办时间,                    
	private String usePerson;    //经办人,             
	private String payer;        //付款方(船名船号),                    
	private String invoiceState; //发票状态，0：正常，1：废票, 2.报失                 
	private String invalidPerson;//修改人
	private Date invalidTime;//作废时间
	private String isExport; //是否导出  0未导出，1导出 默认0
	private String invalidReason;//作废原因
	private String curscd; //上下游  0上游 1下游  读数据字典
	private String shiftnum; //所在工班
	private String stationId; //站点Id
	private Integer feeType;  //缴费类型(1过闸费 2.查补费 3.提放费 4.违章费用)
	
	
	
	public LocalInvoice() {
		super();
	}
	





	public LocalInvoice(String id, String feeId, String invoiceNum, String invoiceMoney, Date useTime, String usePerson,
			String payer, String invoiceState, String invalidPerson, Date invalidTime, String isExport,
			String invalidReason, String curscd,String stationId,Integer feeType ,String shiftnum) {
		super();
		this.id = id;
		this.feeId = feeId;
		this.invoiceNum = invoiceNum;
		this.invoiceMoney = invoiceMoney;
		this.useTime = useTime;
		this.usePerson = usePerson;
		this.payer = payer;
		this.invoiceState = invoiceState;
		this.invalidPerson = invalidPerson;
		this.invalidTime = invalidTime;
		this.isExport = isExport;
		this.invalidReason = invalidReason;
		this.curscd = curscd;
		this.stationId = stationId;
		this.feeType = feeType;
		this.shiftnum = shiftnum;
	}






	@Id 
	@Column(name = "ID")
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "FEE_ID")
	public String getFeeId() {
		return feeId;
	}


	public void setFeeId(String fee_id) {
		this.feeId = fee_id;
	}

	@Column(name = "INVOICE_NUM")
	public String getInvoiceNum() {
		return invoiceNum;
	}


	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}

	@Column(name = "INVOICE_MONEY")
	public String getInvoiceMoney() {
		return invoiceMoney;
	}


	public void setInvoiceMoney(String invoiceMoney) {
		this.invoiceMoney = invoiceMoney;
	}

	@Column(name = "USE_TIME")
	public Date getUseTime() {
		return useTime;
	}


	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	@Column(name = "USE_PERSON")
	public String getUsePerson() {
		return usePerson;
	}


	public void setUsePerson(String usePerson) {
		this.usePerson = usePerson;
	}

	@Column(name = "PAYER")
	public String getPayer() {
		return payer;
	}


	public void setPayer(String payer) {
		this.payer = payer;
	}

	@Column(name = "INVOICE_STATE")
	public String getInvoiceState() {
		return invoiceState;
	}


	public void setInvoiceState(String invoiceState) {
		this.invoiceState = invoiceState;
	}

	@Column(name = "INVALID_PERSON")
	public String getInvalidPerson() {
		return invalidPerson;
	}


	public void setInvalidPerson(String invalidPerson) {
		this.invalidPerson = invalidPerson;
	}

	@Column(name = "INVALID_TIME")
	public Date getInvalidTime() {
		return invalidTime;
	}


	public void setInvalidTime(Date invalidTime) {
		this.invalidTime = invalidTime;
	}

	@Column(name="IS_EXPORT")
	public String getIsExport() {
		return isExport;
	}


	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}

	@Column(name="INVALID_REASON")
	public String getInvalidReason() {
		return this.invalidReason;
	}


	public void setInvalidReason(String invalidReason) {
		this.invalidReason = invalidReason;
	}


	@Column(name="curscd")
	public String getCurscd() {
		return this.curscd;
	}



	public void setCurscd(String curscd) {
		this.curscd = curscd;
	}


	@Column(name="stationId")
	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	@Column(name="feeType")
	public Integer getFeeType() {
		return feeType;
	}


	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}





	@Column(name="shiftnum")
	public String getShiftnum() {
		return shiftnum;
	}






	public void setShiftnum(String shiftnum) {
		this.shiftnum = shiftnum;
	}
	
}
