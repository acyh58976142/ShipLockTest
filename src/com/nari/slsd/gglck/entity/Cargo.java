package com.nari.slsd.gglck.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 货物pojo
 * @author zsq
 *
 */
@Entity
@Table(name="cargo")
public class Cargo {
	 private String cargoId;    //货物ID
	 private String cargoName;	//货物名称
	 private String cargoKey;	//货物键名
	 private String cargoKeyDes;//货物键名描述
	 private String parentId;	//父键ID
	 private String cargoValue;	//货物值
	 private Integer cargoEna;	//启用
	 private Integer cargoSeq;	//排序
	 private Integer isDanger;	//是否危险品
	 private Integer cargoLevel;//货物级别
	 private String  stationId; //船闸所
	 private String ext1;		//预留1
	 private String ext2;		//预留2

	public Cargo() {
		super();
	}
	
	public Cargo(String cargoId) {
		super();
		this.cargoId = cargoId;
	}

	public Cargo(String cargoId, String cargoName, String cargoKey,
			String cargoKeyDes, String parentId, String cargoValue,
			Integer cargoEna, Integer cargoSeq,Integer  isDanger,
			Integer cargoLevel,String cargoStationId, String ext1, String ext2) {
		super();
		this.cargoId = cargoId;
		this.cargoName = cargoName;
		this.cargoKey = cargoKey;
		this.cargoKeyDes = cargoKeyDes;
		this.parentId = parentId;
		this.cargoValue = cargoValue;
		this.cargoEna = cargoEna;
		this.cargoSeq = cargoSeq;
		this.isDanger = isDanger;
		this.cargoLevel = cargoLevel;
		this.stationId=cargoStationId;
		this.ext1 = ext1;
		this.ext2 = ext2;
	}
	@Id
	public String getCargoId() {
		return cargoId;
	}

	public void setCargoId(String cargoId) {
		this.cargoId = cargoId;
	}

	public String getCargoName() {
		return cargoName;
	}

	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	public String getCargoKey() {
		return cargoKey;
	}

	public void setCargoKey(String cargoKey) {
		this.cargoKey = cargoKey;
	}

	public String getCargoKeyDes() {
		return cargoKeyDes;
	}

	public void setCargoKeyDes(String cargoKeyDes) {
		this.cargoKeyDes = cargoKeyDes;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCargoValue() {
		return cargoValue;
	}

	public void setCargoValue(String cargoValue) {
		this.cargoValue = cargoValue;
	}

	public Integer getCargoEna() {
		return cargoEna;
	}

	public void setCargoEna(Integer cargoEna) {
		this.cargoEna = cargoEna;
	}

	public Integer getCargoSeq() {
		return cargoSeq;
	}

	public void setCargoSeq(Integer cargoSeq) {
		this.cargoSeq = cargoSeq;
	}

	public Integer getIsDanger() {
		return isDanger;
	}

	public void setIsDanger(Integer isDanger) {
		this.isDanger = isDanger;
	}

	public Integer getCargoLevel() {
		return cargoLevel;
	}

	public void setCargoLevel(Integer cargoLevel) {
		this.cargoLevel = cargoLevel;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
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
}
