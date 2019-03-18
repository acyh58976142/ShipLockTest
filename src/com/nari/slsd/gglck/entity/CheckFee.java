package com.nari.slsd.gglck.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 查补信息
 * @author acer
 *
 */
@Entity
@Table(name="check_Fee")
public class CheckFee {
	  private String  checkId;			 // 查补ID             
	  private String  registerId;        // 登记ID         
	  private String  vesselName;        // 船名    
	  private String  telephone;         // 移动电话
	  private Double checkTns;       // 查补吨位      
	  private Double  checkFee;      // 应收闸费        
	  private String  ext1;              // 预留1   
	  private String  ext2;              // 预留2     
	  private String  feeId;             // 缴费Id   
	  private String  stationId;		 // 船闸所Id
	  private Integer checkState;		//查补状态
	  private Date createTime;			//创建时间
	public CheckFee() {
		super();
	}

	public CheckFee(String checkId) {
		super();
		this.checkId = checkId;
	}

	public CheckFee(String checkId, String registerId, String vesselName,
			String telephone, Double checkTns,String  stationId,
			Double checkFee, String ext1, String ext2, String feeId,Integer checkState,Date createTime) {

		super();
		this.checkId = checkId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.telephone = telephone;
		this.checkTns = checkTns;
		this.checkFee = checkFee;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.feeId = feeId;
		this.stationId=stationId;
		this.checkState=checkState;
		this.createTime=createTime;
	}
	@Id
	public String getCheckId() {
		return checkId;
	}

	public void setCheckId(String checkId) {
		this.checkId = checkId;
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

	public Double getCheckTns() {
		return checkTns;
	}

	public void setCheckTns(Double checkTns) {
		this.checkTns = checkTns;
	}

	public Double getCheckFee() {
		return checkFee;
	}

	public void setCheckFee(Double checkFee) {
		this.checkFee = checkFee;
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

	public Integer getCheckState() {
		return checkState;
	}

	public void setCheckState(Integer checkState) {
		this.checkState = checkState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}                                                                                         