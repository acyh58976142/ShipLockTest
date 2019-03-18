package com.nari.slsd.gglck.util;

/**
 * 返回消息和结果信息的实体类
 * @author zpx
 * @date 2017.02.25
 */
public class MessageInfo {
	private boolean isSuccess;	// 是否成功
	private String message;		// 提示信息
	private Object retData;  	// 返回的数据
	private String type;		// 提示类型,配合swal使用(warning, error, success 和 info)
	
	public MessageInfo() {}

	public MessageInfo(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	public MessageInfo(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}
	
	public MessageInfo(boolean isSuccess, Object retData) {
		this.isSuccess = isSuccess;
		this.retData = retData;
	}

	public MessageInfo(boolean isSuccess, String message, String type) {
		this.isSuccess = isSuccess;
		this.message = message;
		this.type = type;
	}

	public MessageInfo(boolean isSuccess, String message, Object retData, String type) {
		this.isSuccess = isSuccess;
		this.message = message;
		this.retData = retData;
		this.type = type;
	}

	public boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getRetData() {
		return retData;
	}

	public void setRetData(Object retData) {
		this.retData = retData;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
