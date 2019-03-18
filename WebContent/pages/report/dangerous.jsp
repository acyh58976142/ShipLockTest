<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" scope="page" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>危险品统计表</title>
<link href="${path}/pages/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/pages/lib/bootstrap-3.3.5-dist/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="${path}/pages/lib/bootstrap-3.3.5-dist/css/animate.css" rel="stylesheet">
<link href="${path}/pages/common.css" rel="stylesheet">
<!-- Data Tables -->
<link href="${path}/pages/lib/dataTables/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- js文件 -->
<script src="${path}/pages/lib/shipArrange/jquery-2.1.1.js"></script>
<script src="${path}/pages/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="${path}/pages/lib/shipArrange/jquery-ui/jquery-ui.js"></script>
<script src="${path}/pages/lib/shipArrange/jquery-ui/jquery-ui.min.js"></script>
<!-- 日历控件 -->
<script src="${path}/pages/lib/My97DatePicker/WdatePicker.js"></script>
<!-- sweetAlert 提示框样式 -->
<link href="${path}/pages/lib/bootstrap-3.3.5-dist/css/sweetalert.css"  rel="stylesheet"/>
<script src="${path}/pages/lib/bootstrap-3.3.5-dist/js/sweetalert-dev.js"></script>
<!-- dataTables -->
<script src="${path}/pages/lib/dataTables/js/jquery.dataTables.js"></script>
<script src="${path}/pages/lib/dataTables/js/dataTables.bootstrap.js"></script>
<script src="${path}/pages/dictionaryKey.js"></script>
<script src="${path}/pages/lib/bootstrap-3.3.5-dist/js/jquery.slimscroll.min.js"></script>
<script type="text/javascript" src="${path}/pages/common/Print/jquery.jqprint-0.3.js"></script>
<script src="${path}/pages/commonUtil.js"></script>
<script src="${path}/pages/report/dangerous.js"></script>
	<style type="text/css">
	.dangerous-dang-title {
		margin-top: 10px !important;
		text-align: center;
		padding: 0px 20px 0px 20px;
		margin: 0px;
		height: 25px;
		line-height: 25px;
		font-size: 25px;
		color: #222;
	}
	.dangerous-tab-title {
		text-align: left;
		font-size: 14px;
		height: 30px;
		line-height: 30px;
		color: #222;
		padding-left: 20px;
		padding-right: 20px;
	}
	#dangerous_tabConte th, #dangerous_tabConte td,
		#dangerous_tabConte tr {
		text-align: center !important;
		vertical-align: middle !important;
		font-size: 12px;
		height: 32px;
		line-height: 25px;
		padding: 0px;
		border: 1px solid #000 !important;
	}
	#dangerous_tabConte th{
		background-color: #eaeaea;
	}
	#dangerous_tabConte{
		padding: 0px 200px;
	}
</style>
</head>
<body>
	<!-- 表格查询条件-->
	<div class="common-table-search">
		<!-- 查询条件第一行 -->
		<div class="row common-row">
			<div class="col-md-4 col-lg-4">
				<label for="firstname" class="col-sm-2 common-table-searchLabel text-right">日期</label>
				<div class="col-sm-5 common-table-searchInput">
					<input type="text" id="queryTime" class="form-control text-left" onfocus="WdatePicker({dateFmt:'yyyy-MM',skin:'twoer',readOnly:'true'})"
						class="Wdate common-datepicker" placeholder="日期"> 
						<span style="float: right; margin: -23px 10px;"><i class="fa fa-calendar"></i></span>
				</div>
				<button class="btn btn-info" id="query_btn">
						<i class="fa fa-search"></i>&nbsp;检索
				</button>
			</div>
			<div class="col-md-6 col-lg-6"></div>
			<div class="col-md-2 col-lg-2 text-right" style="white-space: nowrap;">
				<button class="btn btn-info" id="dangerous_print_btn">
					<i class="fa fa-print"></i>&nbsp;打印报表
				</button>
				<button class="btn btn-success" id="dangerous_exportExcel">
					<i class="fa fa-file-excel-o"></i>&nbsp;导出报表
				</button>
			</div>
		</div>
	</div>
	<div class="col-lg-12" id="dangerous_tabConte" class="dangerous_tabConte">
		<link rel="stylesheet" media="print" href="${path}/pages/report/dangerousPrint.css">
		<div class="col-md-12 dangerous-dang-title" id="bigDangerTitle"><span id="dangTitle"></span>危险品统计表</div>
		<div class="col-md-12 dangerous-tab-title">
			日期:<span id="sDangerTitle"><span id="year"></span>年<span id="month"></span>月份</span>
		</div>
		<div class="col-md-12">
			<table id="dangerous_table" class="table table-bordered">
				<thead>
					<tr>
						<th colspan="4">上行</th>
						<th colspan="4">下行</th>
					</tr>
					<tr>
						<th>日期</th>
						<th>数量</th>
						<th>吨数</th>
						<th>金额</th>
						<th>日期</th>
						<th>数量</th>
						<th>吨数</th>
						<th>金额</th>
					</tr>
				</thead>
				<tbody id="dangerous_table_tbody">
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		var path = '${path}';
		var dangerous = new dangerous();
	</script>
</body>
</html>