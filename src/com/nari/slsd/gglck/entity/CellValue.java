package com.nari.slsd.gglck.entity;

import com.nari.slsd.gglck.util.ExportUtil.ExcelType;

/**
 * 单元格数据
 *
 */
public class CellValue {
	/**
	 * 单元格文本
	 */
	private String value;
	
	/**
	 * 是否合并单元格
	 */
	private boolean isMergeCell=false; 
	/**
	 * 起始行
	 */
	private Integer startRow;
	/**
	 * 结束行
	 */
	private Integer endRow;
	
	/**
	 * 开始列 
	 */
	private Integer startColumn;
	/**
	 * 结束列
	 */
	private Integer endColumn;
	
	
	//excel 内容类型
	private ExcelType type = ExcelType.text;
	
	
	
	/**
	 * @param rowData 单元格值
	 */
	public CellValue(String rowData,Integer startColumn) {
		super();
		this.value = rowData;
		this.startColumn=startColumn;
	}
	
	
	
	
	
	/**
	 * 
	 * @param value 单元格值  
	 * @param type 单元格数据类型
	 */
	public CellValue(String value, ExcelType type) {
		super();
		this.value = value;
		this.type = type;
	}






	/**
	 * 合并单元格信息
	 * @param value  单元格文本
	 * @param isMergeCell  是否合并单元 格  默认false 
	 * @param startRow   合并单元格开始行
	 * @param endRow   合并单元格结束
	 * @param startColumn   合并单元格开始列
	 * @param endColumn 合并单元格结束列
	 */
	public CellValue(String value, boolean isMergeCell, Integer startRow, Integer endRow, Integer startColumn, Integer endColumn) {
		super();
		this.value = value;
		this.isMergeCell = isMergeCell;
		this.startRow = startRow;
		this.endRow = endRow;
		this.startColumn = startColumn;
		this.endColumn = endColumn;
	}



	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isMergeCell() {
		return isMergeCell;
	}
	public void setMergeCell(boolean isMergeCell) {
		this.isMergeCell = isMergeCell;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	public Integer getStartColumn() {
		return startColumn;
	}
	public void setStartColumn(Integer startColumn) {
		this.startColumn = startColumn;
	}
	public Integer getEndColumn() {
		return endColumn;
	}
	public void setEndColumn(Integer endColumn) {
		this.endColumn = endColumn;
	}

	public ExcelType getType() {
		return type;
	}

	public void setType(ExcelType type) {
		this.type = type;
	}


 

	
	
}