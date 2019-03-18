/**
 * 过闸情况月报表
 * @returns
 */
function monthlyReport(){
	//初始化时间
	this.initDate();
	//查询数据
	$("#monthlyReport_query").click(bind(this,this.queryData));
	//导出月报表
	$("#monthlyReport_export").click(bind(this,this.exprotExcel));
	/**打印*/
	$("#monthlyReport_print_btn").click(bind(this,this.showPrintViwe));
}

/**
 * 打印
 */
monthlyReport.prototype.showPrintViwe = function() {
	$("#monthlyReport_table").jqprint({
		debug : false,
		importCSS : true,
		printContainer : true,
		operaSupport : false
	});
};

/**
 * 查询数据
 */
monthlyReport.prototype.queryData=function(){
	this.fillContent();
	$("#monthlyReport_table tbody").empty();
	$.ajax({
		"type" : "post", // post防止中文参数乱码
		"url" : path + "/MonthlyReportController/queryMonthlyReportInfo.action",
		"data" : {
			time : $("#monthlyReport_time").val()
		},
		"success" : bind(this, this.initTable),
		"error" : function() {
			swal("查询数据错误");
		}
	});
};
/**
 * 填充月份船闸所
 */
monthlyReport.prototype.fillContent=function(){
	 var  time = $("#monthlyReport_time").val();
	 if(time != undefined  &&  time != "" ){
		var arr =  time.split("-",2);
		$("#monthlyReport_year").html(arr[0]);
		$("#monthlyReport_month").html(arr[1]);
	 }
		$.ajax({
			"type" : "post", // post防止中文参数乱码
			"url" : path + "/MonthlyReportController/getShipLockName.action",
			"data" : { },
			"success" :function(data){
				$("#monthlyReport_stationName").html(data);
			},
			"error" : function() {
				swal("查询数据错误");
			}
		});
};

/**
 * 初始化查询时间
 */
monthlyReport.prototype.initDate=function(){
	$("#monthlyReport_time").val(new Date().format("yyyy-MM"));
	this.queryData();
};

/**
 * 初始化表格数据
 */
monthlyReport.prototype.initTable=function(data){
	if(data != undefined  && data.length > 0){
		for(var  i = 0 ; i < data.length ;i++){
			var tr = $("<tr>");
			var rowData = data[i];
			for(var j=0 ; j < rowData.length ; j++ ){
				if(i==data.length-1 && j==0)
				{
					tr.append($("<td>").text("合计"));
				}
				else
				{
					tr.append($("<td>").text(this.formatValue(rowData[j])));
				}
			}
			$("#monthlyReport_table tbody").append(tr);
		}
	}
};
/**
 * 
 */
monthlyReport.prototype.formatValue=function(val){
	if( typeof val === 'number' ){
		if(val%1 === 0){
			return val;
		}
		return val.toFixed(2);
	}
	return "";
};
/**
 * 导出数据
 */
monthlyReport.prototype.exprotExcel=function(){
	var time =$("#monthlyReport_time").val();
	var title =$("#monthlyReport_table caption").text();
	var url = path + "/MonthlyReportController/exportMonthlyReportInfo.action?time="+encodeURI(time)+"&title="+ encodeURI(title);
	window.location.href=url;
}