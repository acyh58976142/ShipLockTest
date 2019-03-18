<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="page" />
<c:set var="resid" value="${param.resid}" scope="page" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>通用报表</title>
	<!-- css样式 -->
	<link rel="stylesheet" href="${path}/pages/lib/bootstrap-3.3.5-dist/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="${path}/pages/lib/bootstrap-3.3.5-dist/font-awesome/css/font-awesome.css"/>
	<!-- sweetAlert 提示框样式 -->
	<link rel="stylesheet" href="${path}/pages/lib/bootstrap-3.3.5-dist/css/sweetalert.css" />
	<!--通用样式-->
	<link rel="stylesheet" href="${path}/pages/common.css" />
	<!-- js文件 -->
	<script src="${path}/pages/lib/bootstrap-3.3.5-dist/js/jquery-1.11.3.min.js"></script>
	<script src="${path}/pages/lib/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
	<script src="${path}/pages/commonUtil.js"></script>
	<script src="${path}/pages/report/reportBase.js"></script>
	<!-- 日历控件 -->
	<script src="${path}/pages/lib/My97DatePicker/WdatePicker.js"></script>
	<!-- sweetAlert JS文件 -->
	<script src="${path}/pages/lib/bootstrap-3.3.5-dist/js/sweetalert-dev.js"></script>
	<!-- 打印插件 -->
	<script src="${path}/pages/lib/lodop/LodopFuncs.js"></script>
	<style>
		.loading{
		    width: 100px;
		    height: 100px;
		  /*  border: 1px solid red;*/
		    position: absolute;
		
		    text-align: center;
		
		    left:50%;
		    top: 50%;
		    margin: -50px 0 0 -50px;
		    /*50%为自身尺寸的一半*/
		}
	</style>
</head>
<body>

<script type="text/javascript">
	//      http://localhost:8080/ShipLock/pages/report/reportBase.jsp?resid=/resources/free.wrpt
		$(document).ready(function() {
			var getParamsPath = '${path}/ParameterQuery?r='+Math.random()+'&';
			var getReportPath = '${path}/ReportQuery?r='+Math.random()+'&';;
			var resid = '${resid}';
			var report = new ReportBase();
			report.createSearchForm(getParamsPath,getReportPath,resid);
			/*
			var h = $(document.body).height();
			alert(h);
			var h2 = $(document).height() - h;
			$('#rd').height(h2-40);
			*/
		});
	</script>
	<!-- 表格查询条件-->
	<div id="paramsDiv" class=" common-table-search">
	</div>
    <!-- 表格查询条件-->
	<div id="rd"  style="width:100%;height:100%;text-align:center;margin:0px auto;">
		<center id="reportDiv">
		
		</center>
	</div>
	<br/>
</body>
</html>