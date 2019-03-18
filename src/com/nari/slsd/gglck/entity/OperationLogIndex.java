package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 操作日志表表名存贮表
 * @author acer
 *
 */
@Entity
@Table(name="Operation_Log_Index")
public class OperationLogIndex {
	private String registerId;//登记ID
	private Integer tableIndex;//表序号
	
	public OperationLogIndex() {
		super();
	}
	/**
	 * 
	 * @param registerId 登记ID
	 * @param tableIndex 表序号
	 */
	public OperationLogIndex(String registerId, Integer tableIndex) {
		super();
		this.registerId = registerId;
		this.tableIndex = tableIndex;
	}
	@Id
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}
	public Integer getTableIndex() {
		return tableIndex;
	}
	public void setTableIndex(Integer tableIndex) {
		this.tableIndex = tableIndex;
	}
	
}
