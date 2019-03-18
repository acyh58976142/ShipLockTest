package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 船舶库信息修改操作日志
 * @author acer
 *
 */
@Entity
@Table(name="vessel_operation_log")
public class VesselOperationLog {
	private String operId;	//船舶库操作ID
	private String vesselId;	//船舶ID
	private String operatorId;	//修改人ID
	private Date operatTime ;	//修改时间ID
	private String operationContent ;	//操作内容
	private String isbarge;	//是否驳船(0否 1是)
	private String vesselName; //船名
	private String stationId;//船闸所Id
	
	public VesselOperationLog() {
		super();
	}
	public VesselOperationLog(String operId, String vesselId,
			String operatorId, Date operatTime, String operationContent,
			String isbarge,String vesselName) {
		super();
		this.operId = operId;
		this.vesselId = vesselId;
		this.operatorId = operatorId;
		this.operatTime = operatTime;
		this.operationContent = operationContent;
		this.isbarge = isbarge;
		this.vesselName=vesselName;
	}
	@Id
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getVesselId() {
		return vesselId;
	}
	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public Date getOperatTime() {
		return operatTime;
	}
	public void setOperatTime(Date operatTime) {
		this.operatTime = operatTime;
	}
	public String getOperationContent() {
		return operationContent;
	}
	public void setOperationContent(String operationContent) {
		this.operationContent = operationContent;
	}
	public String getIsbarge() {
		return isbarge;
	}
	public void setIsbarge(String isbarge) {
		this.isbarge = isbarge;
	}
	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	
	
}
