package com.nari.slsd.gglck.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 通讯录
 * @author z p x
 */
@Entity
@Table(name="wx_contact")
public class Contact implements Serializable{
	
	private static final long serialVersionUID = -5511568719582879328L;
	
	private String contactId;	// ID
	private String content;		// 内容
	private Integer type;		// 类型(1:岗位信息,2:船闸所介绍)  		
	private Date createDate;	// 创建时间
	private String operatorId;	// 操作人Id
	private String telephone;	// 联系方式(可以为手机号码或者座机号)
	
	public Contact() {}
	
	public Contact(String contactId) {
		this.contactId = contactId;
	}

	public Contact(String contactId, String content, Integer type, Date createDate, String operatorId,
			String telephone) {
		this.contactId = contactId;
		this.content = content;
		this.type = type;
		this.createDate = createDate;
		this.operatorId = operatorId;
		this.telephone = telephone;
	}

	@Id
	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}
