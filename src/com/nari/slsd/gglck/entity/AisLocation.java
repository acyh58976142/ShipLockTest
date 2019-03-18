package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ais 船舶位置
 * @author zsq
 */
public class AisLocation {
	private String mmsi;   //mmsi
	private String vesselName; //船名
	private String longitude;  //经度
	private String latitude; 	 //纬度
	private String aistime; //报文里的时间
	private String inRange; //是不是在有效区域内(0-不在,1-在,2-不能区分)
	
	public AisLocation() {
		super();
	}
	
	public String getMmsi() {
		return mmsi;
	}

	public void setMmsi(String mmsi) {
		this.mmsi = mmsi;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAistime() {
		return aistime;
	}

	public void setAistime(String aistime) {
		this.aistime = aistime;
	}

	public String getInRange() {
		return inRange;
	}

	public void setInRange(String inRange) {
		this.inRange = inRange;
	}
	
}
