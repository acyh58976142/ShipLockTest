<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page" />
<!DOCTYPE html>
<html  lang="en">
	<head>
		<meta charset="UTF-8">
		<title>通用报表</title>
		<link rel="stylesheet" href="${path}/pages/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="${path}/pages/report/monthlyReport.css" />
		<link href="${path}/pages/common.css" rel="stylesheet">
		<script src="${path}/pages/lib/shipArrange/jquery-2.1.1.js"></script>
		<script src="${path}/pages/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
		<script src="${path}/pages/lib/My97DatePicker/WdatePicker.js"></script>
		<script src="${path}/pages/lib/shipArrange/jquery-ui/jquery-ui.js"></script>
		<script src="${path}/pages/lib/shipArrange/jquery-ui/jquery-ui.min.js"></script>
		<script src="${path}/pages/common/Print/jquery.jqprint-0.3.js"></script>
		<script src="${path}/pages/commonUtil.js"></script>
		<script src="${path}/pages/report/monthlyReport.js"></script>
	</head>
	<body>
		<div class="common-table-search">
			<div class="row common-row">
				<div class="col-lg-2">
					<label for="monthlyReport_time" class="col-sm-4 common-table-searchLabel text-right">选择日期</label>
					<div class="col-sm-8">
						<input type="text" id="monthlyReport_time" class="form-control text-left" onfocus="WdatePicker({dateFmt:'yyyy-MM',skin:'twoer',readOnly:'true'})"
							class="Wdate common-datepicker" placeholder="日期"> 
							<span style="float: right; margin: -23px 10px;"><i class="fa fa-calendar"></i></span>
					</div>
				</div>
				<div class="col-lg-2 ">
					 <button class="btn btn-info" id="monthlyReport_query">
						<i class="fa fa-search"></i>&nbsp;检索
					</button>
				</div>
				<div class="col-lg-8 text-right">
					<button class="btn btn-success" id="monthlyReport_print_btn">
						<i class="fa fa-print"></i>&nbsp;打印报表
					</button>
					<button class="btn btn-info" id="monthlyReport_export">
						<i class="fa fa-print"></i>&nbsp;导出Execl
					</button>
				</div>
			</div>
		
		</div>
		<div class="monthlyReport_content">
			<link rel="stylesheet" href="${path}/pages/report/monthlyReport.css" />
			<table class="monthlyReport_table"  id="monthlyReport_table" border="1">
				<caption><span id="monthlyReport_stationName"></span><span id="monthlyReport_year"></span>年度<span id="monthlyReport_month"></span>月份船舶过闸情况统计表</caption>
				<thead>
					<tr>
						<th colspan="1" rowspan="6" width="30px">日份</th>
						<th colspan="14">单机船</th>
						<th colspan="15">船队</th>
						<th colspan="2" rowspan="3">日计</th>
					</tr>
					<tr>
						<th colspan="5">上游</th>
						<th colspan="5">下游</th>
						<th colspan="4" rowspan="2">单机船合计</th>
						<th colspan="6">上游</th>
						<th colspan="6">下游</th>
						<th colspan="3" rowspan="2">船队合计</th>
					</tr>
					<tr>
						<th colspan="1" rowspan="4">条数</th>
						<th colspan="1" rowspan="4">吨位</th>
						<th colspan="3" rowspan="2" >闸费</th>
						<th colspan="1" rowspan="4">条数</th>
						<th colspan="1" rowspan="4">吨位</th>
						<th colspan="3" rowspan="2" >闸费</th>
						<th colspan="3" rowspan="1" >空载</th>
						<th colspan="3" rowspan="1" >重载</th>
						<th colspan="3" rowspan="1" >空载</th>
						<th colspan="3" rowspan="1" >重载</th>
					</tr>
					<tr>
						<th colspan="1" rowspan="4" >条数</th>
						<th colspan="1" rowspan="4">吨位</th>
						<th colspan="2">闸费</th>
						<th colspan="1" rowspan="4">队数</th>
						<th colspan="1" rowspan="4">吨位</th>
						<th colspan="1" rowspan="3">闸费</th>
						<th colspan="1" rowspan="3">队数</th>
						<th colspan="1" rowspan="3">吨位</th>
						<th colspan="1" rowspan="3">闸费</th>
						<th colspan="1" rowspan="3">队数</th>
						<th colspan="1" rowspan="3">吨位</th>
						<th colspan="1" rowspan="3">闸费</th>
						<th colspan="1" rowspan="3">队数</th>
						<th colspan="1" rowspan="3">吨位</th>
						<th colspan="1" rowspan="3">闸费</th>
						<th colspan="1" rowspan="3">队数</th>
						<th colspan="1" rowspan="3">吨位</th>
						<th colspan="1" rowspan="3">闸费</th>
						<th colspan="1" rowspan="3">吨位</th>
						<th colspan="1" rowspan="3">闸费</th>
					</tr>
					<tr>
						<th colspan="1" rowspan="2">实收</th>
						<th colspan="2" rowspan="1">其中</th>
						<th colspan="1" rowspan="2">实收</th>
						<th colspan="2" rowspan="1">其中</th>
						<th colspan="1" rowspan="2">实收</th>
						<th colspan="1" rowspan="2">超载费</th>
					</tr>
					<tr>
						<th colspan="1" rowspan="1">超载吨位</th>
						<th colspan="1" rowspan="1">超载费</th>
						<th colspan="1" rowspan="1">超载吨位</th>
						<th colspan="1" rowspan="1">超载费</th>
					</tr>
				</thead>
				<tbody >
				</tbody>
			</table>
		
		</div>
		<script type="text/javascript">
			var path ='${path}';
			new monthlyReport();
		</script>
	</body>
</html>