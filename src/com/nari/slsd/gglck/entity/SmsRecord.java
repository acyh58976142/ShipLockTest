package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 短信发送记录
 * @author zsq
 */
@Entity
@Table(name="sms_record")
public class SmsRecord {
	
	private String sendId;     // 发送id
	private Integer userType;   //用户类型
	private String sendContent;//发送内容
	private String receivePhone; //接收手机号
	private Date sendTime;  	//发送时间
	private Integer sendState;  //发送状态
	private String sendStaffId; //发送用户id
	private String sendSeqId;   //短信平台回应id
	
	
	public SmsRecord() {}
	 @Id
	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getSendContent() {
		return sendContent;
	}

	public void setSendContent(String sendContent) {
		this.sendContent = sendContent;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getSendState() {
		return sendState;
	}

	public void setSendState(Integer sendState) {
		this.sendState = sendState;
	}

	public String getSendStaffId() {
		return sendStaffId;
	}

	public void setSendStaffId(String sendStaffId) {
		this.sendStaffId = sendStaffId;
	}

	public String getSendSeqId() {
		return sendSeqId;
	}

	public void setSendSeqId(String sendSeqId) {
		this.sendSeqId = sendSeqId;
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}
	
}
