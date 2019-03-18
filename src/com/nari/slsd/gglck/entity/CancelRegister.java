package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 特殊业务 销号信息实体
 * @author yangwei
 */
@Entity 
@Table(name="cancel_register")
public class CancelRegister {
	private  String  cancelId;         //销号ID
	private  String  registerId;       //登记ID
	private  String  vesselName;       //船名
	private  String  telephone;        //移动电话
	private  Integer cancelType;       //销号类型0注销 1销号
	private  String  ext1;             // 预留1
	private  String  ext2;       	   // 预留2
	private  String  feeId;            //缴费ID  
	private  String  stationId;        //船闸所ID
	private  Date  createTime;         //申请时间
	private  String  unRegistState;    //销号状态
	
	public CancelRegister() {
		super();
	}
    
	public CancelRegister(String cancelId, String registerId, String vesselName, String telephone, Integer cancelType,
			String ext1, String ext2, String feeId, String stationId, Date createTime, String unRegistState) {
		super();
		this.cancelId = cancelId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.telephone = telephone;
		this.cancelType = cancelType;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.feeId = feeId;
		this.stationId = stationId;
		this.createTime = createTime;
		this.unRegistState = unRegistState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date date) {
		this.createTime = date;
	}


	public String getUnRegistState() {
		return unRegistState;
	}


	public void setUnRegistState(String unRegistState) {
		this.unRegistState = unRegistState;
	}


	@Id
	public String getCancelId() {
		return cancelId;
	}

	public void setCancelId(String cancelId) {
		this.cancelId = cancelId;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getCancelType() {
		return cancelType;
	}

	public void setCancelType(Integer cancelType) {
		this.cancelType = cancelType;
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
	
	
	
}
