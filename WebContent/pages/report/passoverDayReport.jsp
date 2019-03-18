<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>船舶过闸日报表</title>
<link  href="${path}/pages/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<link  href="${path}/pages/lib/bootstrap-3.3.5-dist/font-awesome/css/font-awesome.css" rel="stylesheet">
<link  href="${path}/pages/lib/bootstrap-3.3.5-dist/css/animate.css" rel="stylesheet">
<!--通用样式 -->
<link  href="${path}/pages/common.css" rel="stylesheet">
<!-- Data Tables -->
<link href="${path}/pages/lib/dataTables/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- js文件 -->
<script media="print" src="${path}/pages/lib/shipArrange/jquery-2.1.1.js"></script>
<script media="print" src="${path}/pages/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script media="print" src="${path}/pages/lib/shipArrange/jquery-ui/jquery-ui.js"></script>
<script media="print" src="${path}/pages/lib/shipArrange/jquery-ui/jquery-ui.min.js"></script>
<!--打印控件  -->
<script type="text/javascript" src="${path}/pages/common/Print/jquery.jqprint-0.3.js"></script>
<!-- 日历控件 -->
<script src="${path}/pages/lib/My97DatePicker/WdatePicker.js"></script>
<!-- sweetAlert 提示框样式 -->
<link href="${path}/pages/lib/bootstrap-3.3.5-dist/css/sweetalert.css"  rel="stylesheet"/>
<script src="${path}/pages/lib/bootstrap-3.3.5-dist/js/sweetalert-dev.js"></script>
<!--打印样式  -->
 <link rel="stylesheet" media="all"  href="${path}/pages/report/passoverDayReport.css">   
<!-- dataTables -->
<script src="${path}/pages/lib/dataTables/js/jquery.dataTables.js"></script>
<script src="${path}/pages/lib/dataTables/js/dataTables.bootstrap.js"></script>
<script src="${path}/pages/dictionaryKey.js"></script>
<script src="${path}/pages/commonUtil.js"></script>
<script src="${path}/pages/report/passoverDayReport.js"></script>
<style  type="text/css">
#passoverDayReport_table th{
		background-color: #eaeaea;
		white-space: nowrap !important;
	}
</style>
</head>
<body>

	<!-- 表格查询条件-->
	<div class="common-table-search">
		<!-- 查询条件第一行 -->
		<div class="row common-row">
		   
			<div class="col-md-5">
				<label for="firstname" class="col-sm-2 common-table-searchLabel text-right">过闸时间</label>
				<div class="col-sm-4 common-table-searchInput">
					<input type="text" id="passoverDayReport_time" name="passoverDayReport_time" class="form-control text-left"
					    value="${timemap.lockageTime }"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',skin:'twoer',readOnly:'true'})"
						class="Wdate common-datepicker" placeholder="" /> <span
						style="float: right; margin: -23px 10px;"><i
						class="fa fa-calendar"></i></span>
				</div>
				 <!-- <div class="col-sm-4 common-table-searchInput">
					  <select class="form-control" id="passoverDayReport_select" name="passoverDayReport_select">
					      <option value="">全部</option>
					      <option value="0">上游</option>
					      <option value="1">下游</option>
					 </select> 
				</div>  -->
				<div class="col-md-6 text-left common-table-btngroup">
					<button class="btn btn-info" id="passoverDayReport_query">
						<i class="fa fa-search"></i>&nbsp;检索
					</button>
				</div>
			</div>
			
			<div class="col-md-5 "></div>
			<div class="col-md-1 text-right common-table-btngroup">
				<button class="btn btn-info" id="passoverDayReport_print">
					<i class="fa fa-search"></i>&nbsp;打印报表
				</button>
				
			</div>
			<div class="col-md-1 text-right common-table-btngroup">
				<button class="btn btn-success" id="passoverDayReport_export">
					<i class="fa fa-search"></i>&nbsp;导出excel
				</button>
			</div>
		</div>
	</div>



	<!-- 表格显示 -->
	<div class="col-lg-12 dangerous_tabConte" id="dangerous_tabConte">
		<div class="col-md-12 dangerous-dang-title" id="bigDangerTitle">船舶过闸日报表</div>
		<div class="col-md-12 dangerous-tab-title ">
		    <div class="col-md-6 text-left ">
			日期:<span id="startLockageTimeandendLockageTime" class="dangerous_Time ">${timemap.startLockageTime}${timemap.endLockageTime}</span>
			</div>
			<div class="col-md-6 text-right ">
			<span class="passoverDayReport_nowTime " id="passoverDayReport_nowTime">报进时间:${date }</span>
			</div>
		</div>
		<div class="col-md-12 dangerous-tab-div">
			<table id="passoverDayReport_table"
				class="dangerous_table_month table table-bordered" >
				<thead>
					<tr>
						<th colspan="9">上游</th>
						<th colspan="9">下游</th>
					</tr>
					<tr>
					    <th>序号</th>
						<th>船名</th>
						<th>登记时间</th>
						<th>货物种类</th>
						<th>吨位</th>
						<th>超载比例</th>
						<th>闸费</th>
						<th>目的地</th>
                        <th>工班</th>
                        
						<th>序号</th>
						<th>船名</th>
						<th>登记时间</th>
						<th>货物种类</th>
						<th>吨位</th>
						<th>超载比例</th>
						<th>闸费</th>
						<th>目的地</th>
                        <th>工班</th>
					</tr>
				</thead>
				<tbody class="passoverDayReport_table_tbody" id="passoverDayReport_table_tbody">
				<tr>
                        <c:forEach items="${reslist }" var="res">
                        <td>${res.seq }</td>
						<td>${res.vesselName }</td>
						<td>${res.registerTime }</td>
						<td>${res.cargoName }</td>
						<td>${res.tonnageTns }</td>
						<td>${res.itemName }</td>
						<td>${res.realFee }</td>
						<td>${res.arriving }</td>
                        <td>${res.workGroupName }</td>
                        
                        <c:choose>
						<c:when test="${res.vesselNameD!=null}">
						<td>${res.seq }</td>
						</c:when>
						<c:otherwise>
						<td></td>
						</c:otherwise>
						</c:choose>
						<td>${res.vesselNameD }</td>
						<td>${res.registerTimeD }</td>
						<td>${res.cargoNameD }</td>
						<td>${res.tonnageTnsD }</td>
						<td>${res.itemNameD }</td>
						<td>${res.realFeeD }</td>
						<td>${res.arrivingD }</td>
                        <td>${res.workGroupNameD }</td>
                  </tr>
                        </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
	    var path = '${path}';
		var passoverDayReport = new passoverDayReport();
	</script>
</body>
</html>