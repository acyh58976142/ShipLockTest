package com.nari.slsd.gglck.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日报表查询控制层
 */
import com.nari.slsd.gglck.dao.PassoverDayReportDao;
import com.nari.slsd.gglck.entity.CellValue;
import com.nari.slsd.gglck.util.CommonTool;
import com.nari.slsd.gglck.util.ExportUtil;
import com.nari.slsd.gglck.util.ExportUtil.ExcelType;
@RequestMapping(value = "passoverDayReport")
@Controller
public class PassoverDayReportController {
	private static final Logger LOG = Logger.getLogger(PassoverDayReportController.class);
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	 
	@Autowired
	private PassoverDayReportDao passoverDayReportDao;
	
	/**
	 * 导出月报表信息
	 * @return
	 */
	@RequestMapping(value = "/exportExcel.action", method = RequestMethod.GET)
	public void exportMonthlyReportInfo(String time,String title,HttpServletRequest request,HttpServletResponse response) {
	
		List<List<CellValue>>  values =new ArrayList<List<CellValue>>();
		List<Object[]> list = getMonthlyInfo(time);
		for (Object[] rowData : list) {
			List<CellValue> list1 = new ArrayList<CellValue>();
			for (int i = 0; i < rowData.length; i++) {
				list1.add(new CellValue((rowData[i] != null ? rowData[i].toString() : "0"), ExcelType.text));
			}
			values.add(list1);
		}
		
		String sheetName = time.split("-",3)[2] + "日";
		ExportUtil.exportExcelType(request,response,sheetName,new CellValue(title,true,0,0,0,17), getHeadList(),values, title);
	}
	/**
	 * 创建船舶过闸情况月报表 头
	 * @return
	 */
	private List<List<CellValue>> getHeadList(){
		List<List<CellValue>>  headList =new ArrayList<List<CellValue>>();
		 
		List<CellValue> row1= new ArrayList<CellValue>();
			 row1.add(new CellValue("上行", true, 1, 1, 0, 8)); 
			 row1.add(new CellValue("下行", true, 1, 1, 9, 17)); 
			 headList.add(row1);
		List<CellValue> row2= new ArrayList<CellValue>();
			 row2.add(new CellValue("序号", 0 )); 
			 row2.add(new CellValue("船名", 1 )); 
			 row2.add(new CellValue("登记时间", 2 )); 
			 row2.add(new CellValue("货物种类", 3 ));
			 row2.add(new CellValue("吨位", 4 )); 
			 row2.add(new CellValue("载货比例", 5 )); 
			 row2.add(new CellValue("闸费", 6 )); 
			 row2.add(new CellValue("目的地", 7 ));  
			 row2.add(new CellValue("工班", 8 )); 
			 
			 row2.add(new CellValue("序号", 9 )); 
			 row2.add(new CellValue("船名", 10 )); 
			 row2.add(new CellValue("登记时间", 11 )); 
			 row2.add(new CellValue("货物种类", 12 ));
			 row2.add(new CellValue("吨位", 13 )); 
			 row2.add(new CellValue("载货比例", 14 )); 
			 row2.add(new CellValue("闸费", 15 )); 
			 row2.add(new CellValue("目的地", 16 ));  
			 row2.add(new CellValue("工班", 17 )); 
			 headList.add(row2);
			 
		return headList;
	}

	private List<Object[]> getMonthlyInfo(String time) {
		List<Object[]> list = new ArrayList<Object[]>();
		List<Map<String, Object>> listMap = passoverDayReportDao.queryPassoverDayReportListMap(time);
		if (listMap != null) {
			int leftIndex = 1; // 上游序号
			int rightIndex = 1; // 下游序号
			Map<Integer, Map<String, Object>> upMap = new HashMap<Integer, Map<String, Object>>();// 上游集合
			Map<Integer, Map<String, Object>> downMap = new HashMap<Integer, Map<String, Object>>();// 下游集合
			for (Map<String, Object> map : listMap) {
				if (0 == (Integer) map.get("location")) {
					upMap.put(leftIndex, map);
					leftIndex++;
				}else if ("1".equals(map.get("location") + "")) {
					downMap.put(rightIndex, map);
					rightIndex++;
				}
			}
			int size = upMap.size() > downMap.size() ? upMap.size() : downMap.size();
			for (int i = 1; i <= size; i++) {
				String[] row = new  String[18];
				row[0] = String.valueOf(i); row[1] = "";row[2] = "";row[3] = "";row[4] = ""; row[5] = "";//默认为空
				row[6] = "";  row[7] = "";row[8] = "";
				
				row[9] = String.valueOf(i);row[10] = ""; row[11] = "";
				row[12] = ""; row[13] = "";row[14] = "";row[15] = "";row[16] = ""; row[17] = "";
				if (upMap.containsKey(i)) {
					Map<String, Object> leftMap = upMap.get(i);
					row[1] = getString(leftMap,"vesselName");
					row[2] = getString(leftMap,"registerTime");
					row[3] = getString(leftMap,"cargoName");
					row[4] = getString(leftMap,"tonnageTns");
					row[5] = getString(leftMap,"itemName");
					row[6] = getString(leftMap,"realFee");
					row[7] = getString(leftMap,"arriving");
					row[8] = getString(leftMap,"workGroupName");
				}
				if (downMap.containsKey(i)) {
					Map<String, Object> rightMap = downMap.get(i);
					row[10] = getString(rightMap,"vesselName");
					row[11] = getString(rightMap,"registerTime");
					row[12] = getString(rightMap,"cargoName");
					row[13] = getString(rightMap,"tonnageTns");
					row[14] = getString(rightMap,"itemName");
					row[15] = getString(rightMap,"realFee");
					row[16] = getString(rightMap,"arriving");
					row[17] = getString(rightMap,"workGroupName");
				}
				list.add(row);
			}
		}
		return list;
	}
	/**
	 * 返回字符串
	 * @param map
	 * @param key
	 * @return
	 */
	private String getString(Map<String,Object> map,String key){
		Object val = map.get(key);
		if(!CommonTool.isObjNullOrEmpty(val)){
			return String.valueOf(val);
		}
		return null;
	}
	
	
	/*
	 * 点击检索按钮，根据过闸日期查询报表信息
	 * @param HttpServletRequest request,HttpServletResponse response
	 * @throws  ServletException, IOException
	 */
	@RequestMapping(value = "/queryPassoverDayReportByLockageTime.action")
	@ResponseBody
	public List<Object> queryPassoverDayReportByLockageTime(HttpServletRequest request){
		String time = request.getParameter("passoverDayReport_time")!=null?request.getParameter("passoverDayReport_time"):sdf.format(new Date());
		String lockageTime = null;
		if (time!=null) {
			try {
				//转换日期格式为yyyy-MM-dd后，再转为string类型
				lockageTime = sdf2.format(sdf2.parse(time));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		List<Map<String, Object>> listMap = passoverDayReportDao.queryPassoverDayReportListMap(lockageTime);
		List<Object> reslist = new ArrayList<>();
		Map<String, Object> resMap = null;
		if (listMap!=null) {
			int leftIndex = 1; //上游序号
			int rightIndex = 1; //下游序号
			Map<Integer,Map<String, Object>> upMap = new HashMap<Integer,Map<String, Object>>();//上游集合
			Map<Integer,Map<String, Object>> downMap = new HashMap<Integer,Map<String, Object>>();//下游集合
			for (Map<String, Object> map : listMap) {
				if (0 ==(Integer)map.get("location")) {
					upMap.put(leftIndex,map);
					leftIndex++;
				}
				
				else if ("1".equals(map.get("location")+"")) {
                	downMap.put(rightIndex,map);
                	rightIndex++;
				}
				
			}
			int size = upMap.size() > downMap.size() ? upMap.size() : downMap.size();
			for(int i=1;i<=size;i++)
			{
				resMap = new HashMap<String, Object>();
				resMap.put("seq", i);
				
				if(upMap.containsKey(i))
				{
					Map<String, Object> leftMap = upMap.get(i);
					resMap.put("vesselName", leftMap.get("vesselName"));    //船名
					resMap.put("registerTime", sdf.format(leftMap.get("registerTime")) ); //登记时间
					resMap.put("cargoName", leftMap.get("cargoName"));  //货物种类
					resMap.put("tonnageTns", leftMap.get("tonnageTns"));        //吨位
					resMap.put("itemName", leftMap.get("itemName")!=null?leftMap.get("itemName"):"");  //超载比例
					resMap.put("realFee", leftMap.get("realFee")!=null?leftMap.get("realFee"):"");  //闸费
					resMap.put("arriving", leftMap.get("arriving")!=null?leftMap.get("arriving"):"");  //目的地
					resMap.put("workGroupName", leftMap.get("workGroupName")!=null?leftMap.get("workGroupName"):"");  //工班
				}
				else
				{
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
				}
				
				if(downMap.containsKey(i))
				{
					Map<String, Object> rightMap = downMap.get(i);
					resMap.put("vesselNameD", rightMap.get("vesselName"));
					resMap.put("registerTimeD", sdf.format(rightMap.get("registerTime")));
					resMap.put("cargoNameD", rightMap.get("cargoName"));
					resMap.put("tonnageTnsD", rightMap.get("tonnageTns"));
					resMap.put("itemNameD", rightMap.get("itemName"));
					resMap.put("realFeeD", rightMap.get("realFee")!=null?rightMap.get("realFee"):"");
					resMap.put("arrivingD", rightMap.get("arriving")!=null?rightMap.get("arriving"):"");
					resMap.put("workGroupNameD", rightMap.get("workGroupName")!=null?rightMap.get("workGroupName"):"");
				}
				else
				{
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
				}
				
				reslist.add(resMap);
				
			}
			
		}
		
		System.out.println(reslist);
		return reslist;
	}
	
	/*
	 * 初始化报表且根据站点和过闸日期查询报表信息
	 * @param HttpServletRequest request,HttpServletResponse response
	 * @throws  ServletException, IOException
	 */
	@RequestMapping(value = "/queryPassoverDayReportListMap.action")
	@ResponseBody
	public void queryPassoverDayReportListMap(HttpServletRequest request,HttpServletResponse response)
	throws ServletException, IOException{
		String time = request.getParameter("passoverDayReport_time")!=null?request.getParameter("passoverDayReport_time"):sdf.format(new Date());
		String lockageTime = null;
		if (time!=null) {
			try {
				//转换日期格式为yyyy-MM-dd后，再转为string类型
				lockageTime = sdf2.format(sdf2.parse(time));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		List<Map<String, Object>> listMap = passoverDayReportDao.queryPassoverDayReportListMap(lockageTime);
		List<Object> reslist = new ArrayList<>();
		Map<String, Object> resMap = null;
		if (listMap!=null) {
			int leftIndex = 1; //上游序号
			int rightIndex = 1; //下游序号
			Map<Integer,Map<String, Object>> upMap = new HashMap<Integer,Map<String, Object>>();//上游集合
			Map<Integer,Map<String, Object>> downMap = new HashMap<Integer,Map<String, Object>>();//下游集合
			for (Map<String, Object> map : listMap) {
				if (0 ==(Integer)map.get("location")) {
					upMap.put(leftIndex,map);
					leftIndex++;
				}
				
				else if ("1".equals(map.get("location")+"")) {
                	downMap.put(rightIndex,map);
                	rightIndex++;
				}
				
			}
			int size = upMap.size() > downMap.size() ? upMap.size() : downMap.size();
			for(int i=1;i<=size;i++)
			{
				resMap = new HashMap<String, Object>();
				resMap.put("seq", i);
				
				if(upMap.containsKey(i))
				{
					Map<String, Object> leftMap = upMap.get(i);
					resMap.put("vesselName", leftMap.get("vesselName"));    //船名
					resMap.put("registerTime", sdf.format(leftMap.get("registerTime")) ); //登记时间
					resMap.put("cargoName", leftMap.get("cargoName"));  //货物种类
					resMap.put("tonnageTns", leftMap.get("tonnageTns"));        //吨位
					resMap.put("itemName", leftMap.get("itemName"));  //超载比例
					resMap.put("realFee", leftMap.get("realFee"));  //闸费
					resMap.put("arriving", leftMap.get("arriving"));  //目的地
					resMap.put("workGroupName", leftMap.get("workGroupName"));  //工班
				}
				else
				{
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
				}
				
				if(downMap.containsKey(i))
				{
					Map<String, Object> rightMap = downMap.get(i);
					resMap.put("vesselNameD", rightMap.get("vesselName"));
					resMap.put("registerTimeD", sdf.format(rightMap.get("registerTime")));
					resMap.put("cargoNameD", rightMap.get("cargoName"));
					resMap.put("tonnageTnsD", rightMap.get("tonnageTns"));
					resMap.put("itemNameD", rightMap.get("itemName"));
					resMap.put("realFeeD", rightMap.get("realFee"));
					resMap.put("arrivingD", rightMap.get("arriving"));
					resMap.put("workGroupNameD", rightMap.get("workGroupName"));
				}
				else
				{
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
					resMap.put("", "");
				}
				
				reslist.add(resMap);
				
			}
			
		}
		
		//日期
		if (lockageTime!=null && lockageTime!="") {
			Map<String, Object> timemap = new HashMap<>();
			String startLockageTime =lockageTime+" 00:00至";
			String endLockageTime =lockageTime+" 23:59";
			timemap.put("startLockageTime", startLockageTime);
			timemap.put("endLockageTime", endLockageTime);
			timemap.put("lockageTime", lockageTime);
			request.setAttribute("timemap", timemap);
			
		}
		//获取系统当前时间
		request.setAttribute("date", df.format(new Date()));
		request.setAttribute("reslist", reslist);
		
		
		//转发
		request.getRequestDispatcher("/pages/report/passoverDayReport.jsp").forward(request, response);
		
		
	}
	   
}
