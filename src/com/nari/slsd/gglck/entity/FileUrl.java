package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 特殊业 务免征信息
 * @author squirrel
 */
@Entity
@Table(name="file_url")//文件上传pojo 
public class FileUrl {
	private String fileId;   //文件Id
	private String fileName; //文件名称
	private String fileUrl;  //文件路径
	private String remark; 	 //备注
	private String thumbUrl; //缩略图路径
	private String relateId; //关联Id
	private String ext1; 	 //预留1
	private String ext2; 	 //预留2
	private String fileType; //文件类型
	private String bizType;  //业务类型
	private Date fileTime;	 //文件传入时间
	
	public FileUrl() {
		super();
	}
	/**
	 * 
	 * @param fileId 文件Id
	 * @param fileName 文件名称
	 * @param fileUrl 文件路径
	 * @param thumbUrl 缩略图路径
	 * @param relateId 关联Id
	 * @param fileTime 文件传入时间
	 */
	public FileUrl(String fileId, String fileName, String fileUrl,
			String thumbUrl, String relateId, Date fileTime) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.thumbUrl = thumbUrl;
		this.relateId = relateId;
		this.fileTime = fileTime;
	}

	public FileUrl(String fileId, String fileName, String fileUrl,
			String remark, String thumbUrl, String relateId, String ext1,
			String ext2, String fileType, String bizType, Date fileTime) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		this.remark = remark;
		this.thumbUrl = thumbUrl;
		this.relateId = relateId;
		this.ext1 = ext1;
		this.ext2 = ext2;
		this.fileType = fileType;
		this.bizType = bizType;
		this.fileTime = fileTime;
	}
	@Id
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getRelateId() {
		return relateId;
	}
	public void setRelateId(String relateId) {
		this.relateId = relateId;
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
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public Date getFileTime() {
		return fileTime;
	}
	public void setFileTime(Date fileTime) {
		this.fileTime = fileTime;
	} 
	
}
