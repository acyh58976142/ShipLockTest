package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 船队放行计划信息
 * @author zsq
 */
@Entity
@Table(name="fleet_release_plan")
public class FleetPlan{
	
	private String id;			//ID
	private String vesselName;			//船名
	private Integer vesselType;		//船类型（1 拖头 2 驳船）
	private String cargoValue;			//载货品种
	private Integer location;			//上下游(0上游 1下游)
	private Date planTime;			//放行日期
	private Double vesselLgth;			//长	
	private Double vesselWidth;			//宽
	private Double MD;					//型深
	private String lockNo;			//闸室
	private String registerId;			//登记id
	private String regNum;			//登记号
	private String queueNum;        //排队号
	
	public String getQueueNum() {
		return queueNum;
	}

	public void setQueueNum(String queueNum) {
		this.queueNum = queueNum;
	}

	public FleetPlan() {}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public Integer getVesselType() {
		return vesselType;
	}

	public void setVesselType(Integer vesselType) {
		this.vesselType = vesselType;
	}

	public String getCargoValue() {
		return cargoValue;
	}

	public void setCargoValue(String cargoValue) {
		this.cargoValue = cargoValue;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	public Double getVesselLgth() {
		return vesselLgth;
	}

	public void setVesselLgth(Double vesselLgth) {
		this.vesselLgth = vesselLgth;
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

	public String getLockNo() {
		return lockNo;
	}

	public void setLockNo(String lockNo) {
		this.lockNo = lockNo;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}
}
