package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 数据字典项pojo
 * @author acer
 *
 */
@Entity
@Table(name="dictionary")
public class Dictionary {
	 private String dictId;    //字典ID
	 private String itemName;	//数据项名称
	 private String itemKey;	//数据项键名
	 private String itemKeyDes;//数据项键名描述
	 private String parentId;	//父键ID
	 private String itemValue;	//数据项值
	 private Integer itemEna;	//启用数据项
	 private Integer itemSeq;	//排序
	 private String itemComt;	//备注
	 private Integer itemLevel;	//级别
	 private String  stationId; //船闸所
	 private String ext1;		//预留1
	 private String ext2;		//预留2
	 
	public Dictionary() {
		super();
	}
	
	public Dictionary(String dictId) {
		super();
		this.dictId = dictId;
	}

	public Dictionary(String dictId, String itemName, String itemKey,
			String itemKeyDes, String parentId, String itemValue,
			Integer itemEna, Integer itemSeq, String itemComt,
			Integer itemLevel,String itemStationId, String ext1, String ext2) {
		super();
		this.dictId = dictId;
		this.itemName = itemName;
		this.itemKey = itemKey;
		this.itemKeyDes = itemKeyDes;
		this.parentId = parentId;
		this.itemValue = itemValue;
		this.itemEna = itemEna;
		this.itemSeq = itemSeq;
		this.itemComt = itemComt;
		this.itemLevel = itemLevel;
		this.stationId=itemStationId;
		this.ext1 = ext1;
		this.ext2 = ext2;
	}
	@Id
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemKey() {
		return itemKey;
	}
	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}
	public String getItemKeyDes() {
		return itemKeyDes;
	}
	public void setItemKeyDes(String itemKeyDes) {
		this.itemKeyDes = itemKeyDes;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getItemValue() {
		return itemValue;
	}
	public void setItemValue(String itemValue) {
		this.itemValue = itemValue;
	}
	public Integer getItemEna() {
		return itemEna;
	}
	public void setItemEna(Integer itemEna) {
		this.itemEna = itemEna;
	}
	public Integer getItemSeq() {
		return itemSeq;
	}
	public void setItemSeq(Integer itemSeq) {
		this.itemSeq = itemSeq;
	}
	public String getItemComt() {
		return itemComt;
	}
	public void setItemComt(String itemComt) {
		this.itemComt = itemComt;
	}
	public Integer getItemLevel() {
		return itemLevel;
	}
	public void setItemLevel(Integer itemLevel) {
		this.itemLevel = itemLevel;
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
