package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 短信模板
 * @author zsq
 */
@Entity
@Table(name="sms_template")
public class SmsTemplate {
	private String templateId; // 模板id
	private Integer userType;   //用户类型
	private String title;	   //模板标题
	private String content;  	//模板内容
	private Integer messageType;  //信息类型
	private String staffId;  	//操作人
	private Date operTime;  //操作时间
	
	public SmsTemplate(String templateId) {
		this.templateId = templateId;
	}
	
	public SmsTemplate() {}
	@Id
	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getMessageType() {
		return messageType;
	}

	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

}
