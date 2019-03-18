package com.nari.slsd.gglck.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 系统参数
 * @author zsq
 */
@Entity
@Table(name="system_params")
public class Sysparams implements Serializable
{
	private String sysId;//系统参数ID
	private String sysKey;//参数键
	private String sysValue;//参数值
	private String sysType;//参数类型
	private String remark;//备注
	private String stationId;//船闸所Id
	private String isNum;//值是否数字（0：否，1：是）
	private String ext1;//预留1(是否显示修改)
	private String ext2;//预留2
    private Integer sort;//排序
    public Sysparams() {
    	super();
    }
    
    public Sysparams(String sysId) {
		super();
		this.sysId = sysId;
	}
    
    public Sysparams(String sysId, String sysKey, String sysValue, String sysType, String remark, String stationId,
			String isNum, String ext1, String ext2) {
		super();
		this.sysId = sysId;
		this.sysKey = sysKey;
		this.sysValue = sysValue;
		this.sysType = sysType;
		this.remark = remark;
		this.stationId = stationId;
		this.isNum = isNum;
		this.ext1 = ext1;
		this.ext2 = ext2;
	}

	public String getIsNum() {
		return isNum;
	}

	public void setIsNum(String isNum) {
		this.isNum = isNum;
	}

	@Id
	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getSysKey() {
		return sysKey;
	}

	public void setSysKey(String sysKey) {
		this.sysKey = sysKey;
	}

	public String getSysValue() {
		return sysValue;
	}

	public void setSysValue(String sysValue) {
		this.sysValue = sysValue;
	}

	public String getSysType() {
		return sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
    
    
	
}
