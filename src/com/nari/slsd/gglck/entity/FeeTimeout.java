package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 缴费超时提醒
 * @author zsq
 */
@Entity
@Table(name="sms_fee_timeout")
public class FeeTimeout {
	
	private String registerId;
	
	public FeeTimeout() {}
	
	@Id
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

}
