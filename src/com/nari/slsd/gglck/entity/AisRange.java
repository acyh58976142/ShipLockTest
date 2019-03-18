package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author z p x
 */
@Entity
@Table(name="ais_range")
public class AisRange {
	
	private String idx;				// 序号
	private String gps_longitude;	// GPS_经度
	private String gps_latitude;	// GPS_纬度
	private String baidu_longitude;	// 百度_经度
	private String baidu_latitude;	// 百度_纬度
	
	public AisRange() {}

	public AisRange(String idx, String gps_longitude, String gps_latitude, String baidu_longitude,
			String baidu_latitude) {
		this.idx = idx;
		this.gps_longitude = gps_longitude;
		this.gps_latitude = gps_latitude;
		this.baidu_longitude = baidu_longitude;
		this.baidu_latitude = baidu_latitude;
	}

	@Id
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getGps_longitude() {
		return gps_longitude;
	}

	public void setGps_longitude(String gps_longitude) {
		this.gps_longitude = gps_longitude;
	}

	public String getGps_latitude() {
		return gps_latitude;
	}

	public void setGps_latitude(String gps_latitude) {
		this.gps_latitude = gps_latitude;
	}

	public String getBaidu_longitude() {
		return baidu_longitude;
	}

	public void setBaidu_longitude(String baidu_longitude) {
		this.baidu_longitude = baidu_longitude;
	}

	public String getBaidu_latitude() {
		return baidu_latitude;
	}

	public void setBaidu_latitude(String baidu_latitude) {
		this.baidu_latitude = baidu_latitude;
	}
	
}
