package com.nari.slsd.gglck.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/*
 * 
 * 登录日志表实体类
 * @author swj
 * 
 * */
//绑定数据库表格
@Entity
@Table(name="login_log")
public class LoginLog {	
	private String logId;   // 日志Id nvarchar(32) not null
	private String userId;  //用户ID nvarchar(32)  null
	private String loginIp;  //登陆IP narchar(32) null
	private Date loginTime;//登陆时间  datetime null
	private String remark;// 备注 nvarchar(256) null
	private String ext1;//预留1 nvarchar(256) null
	private String ext2;//预留2 nvarchar(256) null
	private String stationId;//站点Id
	
	
	
	public LoginLog() {
		super();
	}

	//构造函数
	public LoginLog(String logId, String userId, String loginIp, Date loginTime, String remark, String ext1,
			String ext2,String stationId) {
		super();
		this.logId = logId;
		this.userId = userId;
		this.loginIp = loginIp;
		this.loginTime = loginTime;
		this.remark = remark;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.stationId = stationId;
	}
	
	//主键与数据库绑定
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="logId")
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) { 
		this.userId = userId;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	
	
}
