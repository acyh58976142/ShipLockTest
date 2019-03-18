package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**	
 * 船舶调度-开闸记录实体类
 * @author ls
 */
@Entity
@Table(name="open_lock")
public class OpenLock {
	
	private String openLockId;           //开闸记录ID      nvarchar(32) NOT NULL ,
	private String lockNo;               //闸号                                     nvarchar(32) NULL ,
	private Integer openLockSeq;         //闸次(开闸人每天开的第几次闸) int NULL ,
    private String  staffId;             //开闸人ID       nvarchar(32) NULL ,
    private Date lockTime;               //开闸时间                           datetime NULL ,
    private Integer isNullBrake;             //是否空闸           1空闸 0非空闸                tinyint NULL  ,
    private Integer vesselCount;         //船舶数量                            int NULL ,
	private Integer location;            //上下游                                 tinyint NULL  ,
    private Date recordTime;             //记录时间                            datetime NULL ,
    private String workGroupName;        //工班名称                             nvarchar(32) NULL ,
    private String workGroupBatch;       //班次信息                             nvarchar(32) NULL ,
    private String stationId;            //船闸所ID        nvarchar(32) NULL ,
    private String dispatchBatId;		//调度批次id
    private Double 	theUtilizationRate;		// 闸室利用率
    
    public OpenLock(){}
	
    public OpenLock(String openLockId, String lockNo, Integer openLockSeq, String staffId, Date lockTime,
			Integer isBrake, Integer vesselCount, Integer location, Date recordTime, String workGroupName,
			String workGroupBatch, String stationId) {
		super();
		this.openLockId = openLockId;
		this.lockNo = lockNo;
		this.openLockSeq = openLockSeq;
		this.staffId = staffId;
		this.lockTime = lockTime;
		this.isNullBrake = isBrake;
		this.vesselCount = vesselCount;
		this.location = location;
		this.recordTime = recordTime;
		this.workGroupName = workGroupName;
		this.workGroupBatch = workGroupBatch;
		this.stationId = stationId;
	}
   
    /**开闸记录ID  主键 */
    @Id
    @Column(name = "openLockId")
    public String getOpenLockId() {
		return openLockId;
	}

	public void setOpenLockId(String openLockId) {
		this.openLockId = openLockId;
	}
	/**闸号  */
    @Column(name = "lockNo")
	public String getLockNo() {
		return lockNo;
	}
  
	public void setLockNo(String lockNo) {
		this.lockNo = lockNo;
	}
	
	/**闸次  */
    @Column(name = "openLockSeq")
	public Integer getOpenLockSeq() {
		return openLockSeq;
	}

	public void setOpenLockSeq(Integer openLockSeq) {
		this.openLockSeq = openLockSeq;
	}
	
    /**开闸人ID */
	@Column(name = "staffId")
	public String getStaffId() {
		return staffId;
	}
    
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
    /**开闸时间  */
	@Column(name = "lockTime")
	public Date getLockTime() {
		return lockTime;
	}
   
	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}
    
	/**是否空闸   */
	@Column(name = "isNullBrake")
	public Integer getIsNullBrake() {
		return isNullBrake;
	}

	public void setIsNullBrake(Integer isNullBrake) {
		this.isNullBrake = isNullBrake;
	}
    
	/**船舶数量  */
	@Column(name = "vesselCount")
	public Integer getVesselCount() {
		return vesselCount;
	}

	public void setVesselCount(Integer vesselCount) {
		this.vesselCount = vesselCount;
	}
    
	/**上下游   */
	@Column(name = "location")
	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}
    
	/**记录时间  */
	@Column(name ="recordTime")
	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
    
	/**工班名称   */
	@Column(name ="workGroupName")
	public String getWorkGroupName() {
		return workGroupName;
	}

	public void setWorkGroupName(String workGroupName) {
		this.workGroupName = workGroupName;
	}
    
	/**班次信息   */
	@Column(name ="workGroupBatch")
	public String getWorkGroupBatch() {
		return workGroupBatch;
	}

	public void setWorkGroupBatch(String workGroupBatch) {
		this.workGroupBatch = workGroupBatch;
	}
    
	/**船闸所ID */
	@Column(name ="stationId")
	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getDispatchBatId() {
		return dispatchBatId;
	}

	public void setDispatchBatId(String dispatchBatId) {
		this.dispatchBatId = dispatchBatId;
	}

	public Double getTheUtilizationRate() {
		return theUtilizationRate;
	}

	public void setTheUtilizationRate(Double theUtilizationRate) {
		this.theUtilizationRate = theUtilizationRate;
	}
	
}
