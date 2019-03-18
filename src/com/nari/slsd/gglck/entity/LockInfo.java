package com.nari.slsd.gglck.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 闸室
 * @author zsq
 */
@Entity
@Table(name="lockinfo")
public class LockInfo implements Serializable
{
	private String lockNo;//闸室id
	private String lockName;//闸室名称
	private Double lockLngth;//闸室长度
	private Double lockWdth;//闸室宽度
	private Double lockHght;//闸室高
	private String lockEna;//是否启用(0:不启用,1:启用)
	private String lockIsDraft;//允许吃水
	private String remark;//备注
	private String stationId;//船闸所Id
	private String ext1;//预留1
	private String ext2;//预留2
	private Integer lockNumNo;//闸室数字编号
	
	private Double redundantLngth;//闸室冗余长度
	private Double redundantWdth;//闸室冗余宽度
    
    public LockInfo() {
    	super();
    }
    @Id
	public String getLockNo() {
		return lockNo;
	}

	public void setLockNo(String lockNo) {
		this.lockNo = lockNo;
	}

	public String getLockName() {
		return lockName;
	}

	public void setLockName(String lockName) {
		this.lockName = lockName;
	}

	public Double getLockLngth() {
		return lockLngth;
	}
	public void setLockLngth(Double lockLngth) {
		this.lockLngth = lockLngth;
	}
	public Double getLockWdth() {
		return lockWdth;
	}
	public void setLockWdth(Double lockWdth) {
		this.lockWdth = lockWdth;
	}
	public Double getRedundantLngth() {
		return redundantLngth;
	}
	public void setRedundantLngth(Double redundantLngth) {
		this.redundantLngth = redundantLngth;
	}
	public Double getRedundantWdth() {
		return redundantWdth;
	}
	public void setRedundantWdth(Double redundantWdth) {
		this.redundantWdth = redundantWdth;
	}
	
	public Double getLockHght() {
		return lockHght;
	}
	public void setLockHght(Double lockHght) {
		this.lockHght = lockHght;
	}
	public String getLockEna() {
		return lockEna;
	}

	public void setLockEna(String lockEna) {
		this.lockEna = lockEna;
	}

	public String getLockIsDraft() {
		return lockIsDraft;
	}

	public void setLockIsDraft(String lockIsDraft) {
		this.lockIsDraft = lockIsDraft;
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
	public Integer getLockNumNo() {
		return lockNumNo;
	}
	public void setLockNumNo(Integer lockNumNo) {
		this.lockNumNo = lockNumNo;
	}
    
}
