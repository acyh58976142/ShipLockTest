package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 混放管理信息
 * @author ls
 */
@Entity
@Table(name="mix_rule")
public class mixRule {
	
	private String  mixId; //主键id
	private String  name;  //混放（队列）名称
	private String  rule;  //混放规则
	private String  stationId;//船闸所编号
	
	@Id
	public String getMixId() {
		return mixId;
	}
	public void setMixId(String mixId) {
		this.mixId = mixId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
}
