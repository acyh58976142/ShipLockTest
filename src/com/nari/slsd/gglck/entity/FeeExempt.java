package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;


/**
 * 特殊业 务免征信息
 * @author squirrel
 */
@Entity
@Table(name="fee_exempt")//指明User实体对应的表名称，如果是同名的,可以不写 
public class FeeExempt{
	  private String  freeId;//免征ID
	  private String  registerId;//登记ID
	  private String  vesselName;//船名
	  private String  telephone;//移动电话
	  private String  ext1;//预留1
	  private String  ext2;//预留2
	  private String  feeId;//缴费ID
	  private String  stationId;//船闸所Id
	  private Date createTime;//创建时间
	  private Integer freeState;//0无 1申请免征 2同意免征 3驳回免征
	  
	public FeeExempt() {
		super();
	}

	public FeeExempt(String freeId, String registerId, String vesselName,Integer freeState,
			 String telephone,String ext1, String ext2, String feeId,String stationId,Date createTime) {
		super();
		this.freeId = freeId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.telephone = telephone;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.feeId = feeId;
		this.stationId=stationId;
		this.createTime=createTime;
		this.freeState=freeState;
	}
	@Id
	public String getFreeId() {
		return freeId;
	}
	
	public void setFreeId(String freeId) {
		this.freeId = freeId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getFreeState() {
		return freeState;
	}

	public void setFreeState(Integer freeState) {
		this.freeState = freeState;
	}
	
}
