package com.nari.slsd.gglck.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 树节点
 */
public class Node implements Serializable {

	public Node() {

	}

	public Node(String id, String name, String pId, String url,
			List<Node> children) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 节点id
	 */
	private String id;

	/**
	 * 是否展开
	 */
	private boolean open;
	
	/*
	 * 是否选中
	 */
	private boolean checked;

	/**
	 * 是否展开
	 */
	private String name;
	
	/**
	 * 父id
	 */
	private String pId;
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * 菜单ID
	 */
	private String menuId;
	
	/*
	 * 控件Id
	 */
	private String controlId;
	
	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getControlId() {
		return controlId;
	}

	public void setControlId(String controlId) {
		this.controlId = controlId;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
