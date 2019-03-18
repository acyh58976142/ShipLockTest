package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 特殊业务 提放信息实体
 * @author squirrel
 */
@Entity
@Table(name="vip_info")
public class VipInfo {
	private String  vipId;            // 提放ID
	private String  registerId;       // 登记ID
	private String  vesselName;       // 船名
	private String  telephone;        // 移动电话
	private Double vipFee;        // 应收闸费
	private String ext1;              // 预留1
	private String ext2;       		  // 预留2
	private String feeId;             // 缴费ID
	private String stationId;		  // 船闸所Id
	private Date   createTime;			//创建时间
	private String vipState;			//提放状态(0无 1提放申请 2同意,待缴费  3申请驳回 4取消申请 5同意,已缴费)
	public VipInfo() {
		super();
	}
	public VipInfo(String vipId, String registerId, String vesselName,
			 String telephone, Double vipFee,
			 String ext1, String ext2,
			String feeId,String stationId,Date createTime,String vipState) {
		super();
		this.vipId = vipId;
		this.registerId = registerId;
		this.vesselName = vesselName;
		this.telephone = telephone;
		this.vipFee = vipFee;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.feeId = feeId;
		this.stationId=stationId;
		this.createTime=createTime;
		this.vipState=vipState;
	}
	 /**
	  *  提放ID
	  * @return
	  */
	@Id
	public String getVipId() {
		return vipId;
	}
	public void setVipId(String vipId) {
		this.vipId = vipId;
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
	public Double getVipFee() {
		return vipFee;
	}
	public void setVipFee(Double vipFee) {
		this.vipFee = vipFee;
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
	public String getVipState() {
		return vipState;
	}
	public void setVipState(String vipState) {
		this.vipState = vipState;
	}
	
}
