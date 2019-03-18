package com.nari.slsd.gglck.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import com.nari.slsd.gglck.entity.CellValue;

/**
 * excel 导出工具类
 *
 */
public class ExportUtil {
	private static Logger LOG = Logger.getLogger(ExportUtil.class);
	
	/**
	 *  导出excel 
	 */
	public static void exportExcel(HttpServletRequest request, HttpServletResponse response,String sheetName,
			CellValue title,List<List<CellValue>> head, List<Object[]> values ,String excelName){
		BufferedOutputStream bos=null;
		/** 解决中文文件名乱码 */
		try {
			excelName = URLDecoder.decode(excelName, "UTF-8");
			excelName = excelName.replace(" ", "_");
			excelName = URLEncoder.encode(excelName, "UTF-8");
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + excelName + ".xls");
			HSSFWorkbook wb = new HSSFWorkbook();
			getHSSFWorkbook(sheetName, title, head, values, wb);
			bos = new  BufferedOutputStream(response.getOutputStream());
			wb.write(bos);
			bos.flush();
		} catch ( Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}finally {
			if(bos != null ){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	/**
	 * 创建sheet页
	 * @param sheetName  sheet页名称
	 * @param title   表格标题  可以为空
	 * @param head  表格列头
	 * @param values  表格内存
	 * @param wb  excel 工作簿
	 * @return
	 */
	private static HSSFWorkbook getHSSFWorkbook(String sheetName,CellValue title,List<List<CellValue>> head,
			List<Object[]> values, HSSFWorkbook wb){

        if(wb == null){
            wb = new HSSFWorkbook();
        }
        HSSFSheet sheet = wb.createSheet(CommonTool.isNullOrEmpty(sheetName)  ? "sheet1":  sheetName); //添加sheet 页
//        设置不显示excel网格线 
//        sheet.setDisplayGridlines(false);
        int  rowNum = 0 ;  //定义行
        if(title != null && !CommonTool.isNullOrEmpty(title.getValue())){ //标题
        	HSSFRow row = sheet.createRow(rowNum++);
        	HSSFCellStyle st = createTilteStyle(wb);
        	sheet.addMergedRegion(new CellRangeAddress(title.getStartRow(), title.getEndRow(),
        			title.getStartColumn(), title.getEndColumn() ));
        	HSSFCell cell = row.createCell(0);
        	cell.setCellStyle(st);
        	cell.setCellValue(title.getValue());
        }
        HSSFCellStyle intStyle = createNormalStyle(wb,"int");
        HSSFCellStyle doubleStyle = createNormalStyle(wb,"double");
        //创建表格头
        if(head != null ){
        	for(int i=0;i<head.size();i++){
        		List<CellValue> list = head.get(i);
        		if(list != null){
        			HSSFRow row = sheet.createRow(rowNum++);
        			row.setHeight((short) 406);
        			for (int j = 0; j < list.size(); j++) {
        				CellValue cellData =list.get(j);
        				if(cellData.isMergeCell()){
        					sheet.addMergedRegion(new CellRangeAddress(cellData.getStartRow(), cellData.getEndRow(),
        							cellData.getStartColumn(), cellData.getEndColumn() ));
        				}
        				HSSFCell cell = row.createCell(cellData.getStartColumn());
        				cell.setCellStyle(intStyle);
        				cell.setCellValue(cellData.getValue());
        			}
        		}
        	}
        }
        if(values != null){
        	for(int i=0;i<values.size();i++){
        		Object[] list =values.get(i);
        		if(list != null){
        			HSSFRow row = sheet.createRow(rowNum++);
        			row.setHeight((short) 386);
        			for (int j = 0; j < list.length; j++) {
        				Object val =list[j];
        				HSSFCell cell = row.createCell(j);
        				cell.setCellStyle(intStyle); 
        				cell.setCellValue((Double)val);
        			}
        		}
        	}
        	
        }
        return wb;
    }
	
	
	
	/**
	 * 标题样式
	 * @return
	 */
	private static HSSFCellStyle createTilteStyle(HSSFWorkbook wb ){
		HSSFCellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
	    font.setColor(IndexedColors.BLACK.getIndex());//黑色
	    font.setBold(true); // 
		font.setFontHeightInPoints((short)16);
	    style.setFont(font);  
	    style.setAlignment(HorizontalAlignment.CENTER);//居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
		return style;
	}
	
	/**
	 * 正常单元格样式
	 * @param wb
	 * @param type
	 * @return
	 */
	@SuppressWarnings("static-access")
	private static HSSFCellStyle createNormalStyle(HSSFWorkbook wb, String  type){
		HSSFDataFormat df = wb.createDataFormat();
		HSSFCellStyle style = wb.createCellStyle();
		Font font = wb.createFont();
	    font.setColor(IndexedColors.BLACK.getIndex());//黑色
		font.setFontHeightInPoints((short)11);
	    style.setFont(font);  
//	    style.setBorderBottom(BorderStyle.MEDIUM);;//下边框        
//	    style.setBorderLeft(BorderStyle.MEDIUM);//左边框        
//	    style.setBorderRight(BorderStyle.MEDIUM);//右边框        
//	    style.setBorderTop(BorderStyle.MEDIUM);//上边框   
	    style.setAlignment(HorizontalAlignment.CENTER);//居中
		style.setVerticalAlignment(VerticalAlignment.CENTER);// 上下居中
//		style.setDataFormat(df.getBuiltinFormat("#,#0"));
		style.setDataFormat(df.getBuiltinFormat("###0.0#"));  //保留两位小数
		return style; 
	}
	 
	
	
	/**
	 *  导出excel 
	 */
	public static void exportExcelType(HttpServletRequest request, HttpServletResponse response,String sheetName,
			CellValue title,List<List<CellValue>> head, List<List<CellValue>> values ,String excelName){
		BufferedOutputStream bos=null;
		/** 解决中文文件名乱码 */
		try {
			excelName = URLDecoder.decode(excelName, "UTF-8");
			excelName = excelName.replace(" ", "_");
			excelName = URLEncoder.encode(excelName, "UTF-8");
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + excelName + ".xls");
			HSSFWorkbook wb = new HSSFWorkbook();
			getHSSFWorkbookType(sheetName, title, head, values, wb);
			bos = new  BufferedOutputStream(response.getOutputStream());
			wb.write(bos);
			bos.flush();
		} catch ( Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}finally {
			if(bos != null ){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 创建sheet页
	 * @param sheetName  sheet页名称
	 * @param title   表格标题  可以为空
	 * @param head  表格列头
	 * @param values  表格内存
	 * @param wb  excel 工作簿
	 * @return
	 */
	private static HSSFWorkbook getHSSFWorkbookType(String sheetName,CellValue title,List<List<CellValue>> head,
			List<List<CellValue>> values, HSSFWorkbook wb){

        if(wb == null){
            wb = new HSSFWorkbook();
        }
        HSSFSheet sheet = wb.createSheet(CommonTool.isNullOrEmpty(sheetName)  ? "sheet1":  sheetName); //添加sheet 页
//        设置不显示excel网格线 
//        sheet.setDisplayGridlines(false);
        int  rowNum = 0 ;  //定义行
        if(title != null && !CommonTool.isNullOrEmpty(title.getValue())){ //标题
        	HSSFRow row = sheet.createRow(rowNum++);
        	HSSFCellStyle st = createTilteStyle(wb);
        	sheet.addMergedRegion(new CellRangeAddress(title.getStartRow(), title.getEndRow(),
        			title.getStartColumn(), title.getEndColumn() ));
        	HSSFCell cell = row.createCell(0);
        	cell.setCellStyle(st);
        	cell.setCellValue(title.getValue());
        }
        HSSFCellStyle intStyle = createNormalStyle(wb,"int");
        HSSFCellStyle textStyle = createNormalStyle(wb,"text");
        //创建表格头
        if(head != null ){
        	for(int i=0;i<head.size();i++){
        		List<CellValue> list = head.get(i);
        		if(list != null){
        			HSSFRow row = sheet.createRow(rowNum++);
        			row.setHeight((short) 406);
        			for (int j = 0; j < list.size(); j++) {
        				CellValue cellData =list.get(j);
        				if(cellData.isMergeCell()){
        					sheet.addMergedRegion(new CellRangeAddress(cellData.getStartRow(), cellData.getEndRow(),
        							cellData.getStartColumn(), cellData.getEndColumn() ));
        				}
        				HSSFCell cell = row.createCell(cellData.getStartColumn());
        				cell.setCellStyle(textStyle);
        				cell.setCellValue(cellData.getValue());
        			}
        		}
        	}
        }
        if(values != null){
        	for(int i=0;i<values.size();i++){
        		List<CellValue> list =values.get(i);
        		if(list != null){
        			HSSFRow row = sheet.createRow(rowNum++);
        			row.setHeight((short) 386);
        			for (int j = 0; j < list.size(); j++) {
        				CellValue val =list.get(j);
        				HSSFCell cell = row.createCell(j);
        				if( ExcelType.num.equals(val.getType())){
        					cell.setCellStyle(intStyle); 
        					cell.setCellValue(Double.valueOf(val.getValue()));
        				}else{
        					cell.setCellStyle(textStyle);
        					cell.setCellValue(val.getValue());
        				}
        			}
        		}
        	}
        	
        }
        return wb;
    }
	/**
	 * excel 单元格数据类型
	 * @author 
	 *
	 */
	public enum ExcelType{
		 num,  //数子
		 text // 文本
	}
	
}
