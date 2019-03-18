package com.nari.slsd.gglck.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 发票库存信息
 *
 */
@Entity
@Table(name="local_invoice_inventory_collar")
public class LocalInvoiceInventoryCollar {

	private String id;  			    //id            
	private String min_num;             //发票开始段号
	private String max_num;             //发票结束段号                  
	private String use_person;          //领用人             
	private Date receive_time;        //领取时间                   
	private String invoice_code;        //发票代码           
	private Integer invoice_sum_count;   //发票总数量             
	private Integer invoice_unuse_count; //发票剩余数量                   
	private String use_num; 		    //已用段号,
	private String creator_id;          //经办人Id,                    
	private String use_state;           //已领用使用状态，0：未使用，1：使用，2：用完,  
	private String stock_type;           //标识，0：库存，1：领用，2：退回，3核销, 
	private String stationId;			//站点iD
	private String parentId;   			//原库存Id
	
	
	
	
	public LocalInvoiceInventoryCollar() {
		super();
	}
	
	public LocalInvoiceInventoryCollar(String id, String min_num, String max_num, String use_person,
			Date receive_time, String invoice_code, Integer invoice_sum_count, Integer invoice_unuse_count,
			String use_num, String creator_id, String use_state, String stock_type, String stationId, String parentId) {
		super();
		this.id = id;
		this.min_num = min_num;
		this.max_num = max_num;
		this.use_person = use_person;
		this.receive_time = receive_time;
		this.invoice_code = invoice_code;
		this.invoice_sum_count = invoice_sum_count;
		this.invoice_unuse_count = invoice_unuse_count;
		this.use_num = use_num;
		this.creator_id = creator_id;
		this.use_state = use_state;
		this.stock_type = stock_type;
		this.stationId = stationId;
		this.parentId = parentId;
	}
	
	@Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMin_num() {
		return min_num;
	}
	public void setMin_num(String min_num) {
		this.min_num = min_num;
	}
	public String getMax_num() {
		return max_num;
	}
	public void setMax_num(String max_num) {
		this.max_num = max_num;
	}
	public String getUse_person() {
		return use_person;
	}
	public void setUse_person(String use_person) {
		this.use_person = use_person;
	}
	public Date getReceive_time() {
		return receive_time;
	}
	public void setReceive_time(Date receive_time) {
		this.receive_time = receive_time;
	}
	public String getInvoice_code() {
		return invoice_code;
	}
	public void setInvoice_code(String invoice_code) {
		this.invoice_code = invoice_code;
	}
	public Integer getInvoice_sum_count() {
		return invoice_sum_count;
	}
	public void setInvoice_sum_count(Integer invoice_sum_count) {
		this.invoice_sum_count = invoice_sum_count;
	}
	public Integer getInvoice_unuse_count() {
		return invoice_unuse_count;
	}
	public void setInvoice_unuse_count(Integer invoice_unuse_count) {
		this.invoice_unuse_count = invoice_unuse_count;
	}
	public String getUse_num() {
		return use_num;
	}
	public void setUse_num(String use_num) {
		this.use_num = use_num;
	}
	public String getCreator_id() {
		return creator_id;
	}
	public void setCreator_id(String creator_id) {
		this.creator_id = creator_id;
	}
	public String getUse_state() {
		return use_state;
	}
	public void setUse_state(String use_state) {
		this.use_state = use_state;
	}
	public String getStock_type() {
		return stock_type;
	}
	public void setStock_type(String stock_type) {
		this.stock_type = stock_type;
	}
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	

	
}
