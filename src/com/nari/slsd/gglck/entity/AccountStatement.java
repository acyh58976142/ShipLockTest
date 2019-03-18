package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 对账结果管理
 * @author 欧康辉
 *
 */


@Entity

@Table(name="account_statement")//指明User实体对应的表名称，如果是同名的,可以不写 
public class AccountStatement {
	
	
	private String id;
	private String statisticsDate; //统计日期
	private String statisticsType; // 类型（1：网银 2：POS 3：现金）
	private double bankAccount;   // 银行入账金额
	private double companyAccount;  //公司入账金额
	private String differenceRemark; // 差异备注
	private int results; // 结果（0：未处理 1：已处理）
	private String staffId; // 处理人
	private Date handleTime ;//处理时间
	private Date createTime ;//创建时间
	private String resDescript;//处理说明
	
	
	public String getResDescript() {
		return resDescript;
	}
	public void setResDescript(String resDescript) {
		this.resDescript = resDescript;
	}
	@Id 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatisticsDate() {
		return statisticsDate;
	}
	public void setStatisticsDate(String statisticsDate) {
		this.statisticsDate = statisticsDate;
	}
	public String getStatisticsType() {
		return statisticsType;
	}
	public void setStatisticsType(String statisticsType) {
		this.statisticsType = statisticsType;
	}
	public double getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(double bankAccount) {
		this.bankAccount = bankAccount;
	}
	public double getCompanyAccount() {
		return companyAccount;
	}
	public void setCompanyAccount(double companyAccount) {
		this.companyAccount = companyAccount;
	}
	public String getDifferenceRemark() {
		return differenceRemark;
	}
	public void setDifferenceRemark(String differenceRemark) {
		this.differenceRemark = differenceRemark;
	}
	public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public Date getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(Date handleTime) {
		this.handleTime = handleTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public AccountStatement() {
		super();
	}
	public AccountStatement(String id, String statisticsDate, String statisticsType, double bankAccount,
			double companyAccount, String differenceRemark, int results, String staffId, Date handleTime,
			Date createTime, String resDescript) {
		super();
		this.id = id;
		this.statisticsDate = statisticsDate;
		this.statisticsType = statisticsType;
		this.bankAccount = bankAccount;
		this.companyAccount = companyAccount;
		this.differenceRemark = differenceRemark;
		this.results = results;
		this.staffId = staffId;
		this.handleTime = handleTime;
		this.createTime = createTime;
		this.resDescript = resDescript;
	}
	@Override
	public String toString() {
		return "AccountStatement [id=" + id + ", statisticsDate=" + statisticsDate + ", statisticsType="
				+ statisticsType + ", bankAccount=" + bankAccount + ", companyAccount=" + companyAccount
				+ ", differenceRemark=" + differenceRemark + ", results=" + results + ", staffId=" + staffId
				+ ", handleTime=" + handleTime + ", createTime=" + createTime + ", resDescript=" + resDescript + "]";
	}
	
	
}
