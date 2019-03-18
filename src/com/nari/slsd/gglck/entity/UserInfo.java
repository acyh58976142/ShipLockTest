package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")//指明User实体对应的表名称，如果是同名的,可以不写 
public class UserInfo
{
	private String userId;           	    //户Id */   
	private String groupId;             	//位Id */   
	private String telephone;           	//动电话 */   
	private String userName;            	//户名称 */   
	private String userPassword;        	//户密码 */   
	private String sex;                 	//别 */     
	private String division;            	//门 */     
	private String userJob;             	//户职务 */   
	private String email;               	//箱 */     
	private String headPortraint;       	//像 */     
	private String idiograph;           	//名 */     
	private String description;         	//述 */     
	private String userState;           	//户状态 */   
	private String stationId;               //闸所编号 */  
	private String realName;			    //实姓名 */
	
	public UserInfo(String userId, String groupId, String telephone, String userName, String userPassword, String sex,
			String division, String userJob, String email, String headPortraint, String idiograph, String description,
			String userState, String stationId, String realName) {
		super();
		this.userId = userId;
		this.groupId = groupId;
		this.telephone = telephone;
		this.userName = userName;
		this.userPassword = userPassword;
		this.sex = sex;
		this.division = division;
		this.userJob = userJob;
		this.email = email;
		this.headPortraint = headPortraint;
		this.idiograph = idiograph;
		this.description = description;
		this.userState = userState;
		this.stationId = stationId;
		this.realName = realName;
	}
	
	
	public UserInfo() {
		super();
	}

	public UserInfo(String userId) {
		super();
		this.userId = userId;
	}

	@Id
	public String getUserId() {
		return userId;
	}	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getUserJob() {
		return userJob;
	}
	public void setUserJob(String userJob) {
		this.userJob = userJob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadPortraint() {
		return headPortraint;
	}
	public void setHeadPortraint(String headPortraint) {
		this.headPortraint = headPortraint;
	}
	public String getIdiograph() {
		return idiograph;
	}
	public void setIdiograph(String idiograph) {
		this.idiograph = idiograph;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}        	   
	
}
