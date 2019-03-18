package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *岗位日志 
 *
 */
@Entity
@Table(name="groupInfo_log")
public class GroupInfoLog {
	private String operId;
	private String operator;//操作人
	private Date operatTime ;//操作时间
	private String operationContent ;//操作内容
	private String groupName;//岗位名称
	private String updType;//修改类型
	private String stationId;//站点
	
	public GroupInfoLog() {
		super();
	}
	
	@Id
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
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
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getUpdType() {
		return updType;
	}

	public void setUpdType(String updType) {
		this.updType = updType;
	}
	
	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	@Override
	public String toString() {
		return "GroupInfoLog [operId=" + operId + ", operator=" + operator + ", operatTime=" + operatTime
				+ ", operationContent=" + operationContent + ", groupName=" + groupName + "]";
	}
}
