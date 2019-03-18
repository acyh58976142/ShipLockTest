function passoverDayReport(){
	//检索按钮
	$("#passoverDayReport_query").click(bind(this,this.queryPassoverDayReport));
	//打印按钮
	$("#passoverDayReport_print").click(bind(this,this.showPrintViwe));
	
	//导出excel按钮
	$("#passoverDayReport_export").click(bind(this,this.isExportExcel));
}

/*
 * 根据过闸时间查询
 */
passoverDayReport.prototype.queryPassoverDayReport = function(){
	$("#passoverDayReport_table_tbody").html("");
	var passoverDayReport_time =$("#passoverDayReport_time").val();
	var url=path + "/passoverDayReport/queryPassoverDayReportByLockageTime.action";
	$.ajax({
		type : "post",
		url : url,
		
		data : {
			passoverDayReport_time : passoverDayReport_time
		},
		success : bind(this, this.bindDate),
		error : function() {
			alert("查询数据错误！");
		}
	});
	
}

/*
 * 成功返回方法
 */
passoverDayReport.prototype.bindDate = function(data){
	
	var passoverDayReport_time =$("#passoverDayReport_time").val();
	var startAndEndLockageTime = passoverDayReport_time + " 00:00"+"至" +passoverDayReport_time +" 23:59"
	$("#startLockageTimeandendLockageTime").html(startAndEndLockageTime);
	$("#passoverDayReport_nowTime").val((new Date()).format("yyyy-MM-dd HH:mm:ss"));
	if(data!= null && data!= undefined){
		for(var i=0;i<data.length; i++){
			/*上游*/
			if(data[i].vesselName!=null&&data[i].vesselName!=''&&data[i].vesselName!=undefined){
				var td1 = "<td>"+data[i].seq+"</td>";
				var td2 = "<td>"+data[i].vesselName+"</td>";
				var td3 = "<td>"+data[i].registerTime+"</td>";
				var td4 = "<td>"+data[i].cargoName+"</td>";
				var td5 = "<td>"+data[i].tonnageTns+"</td>";
				var td6 = "<td>"+data[i].itemName+"</td>";
				var td7 = "<td>"+data[i].realFee+"</td>";
				var td8 = "<td>"+data[i].arriving+"</td>";
				var td9 = "<td>"+data[i].workGroupName+"</td>";
			}else{
				var td1 = "<td>"+"</td>";
				var td2 = "<td>"+"</td>";
				var td3 = "<td>"+"</td>";
				var td4 = "<td>"+"</td>";
				var td5 = "<td>"+"</td>";
				var td6 = "<td>"+"</td>";
				var td7 = "<td>"+"</td>";
				var td8 = "<td>"+"</td>";
				var td9 = "<td>"+"</td>";
			}
			
			/*下游*/
			if(data[i].vesselNameD!=null&&data[i].vesselNameD!=''&&data[i].vesselNameD!=undefined){
				var td10 = "<td>"+data[i].seq+"</td>";
				var td11 = "<td>"+data[i].vesselNameD+"</td>";
				var td12 = "<td>"+data[i].registerTimeD+"</td>";
				var td13 = "<td>"+data[i].cargoNameD+"</td>";
				var td14 = "<td>"+data[i].tonnageTnsD+"</td>";
				var td15 = "<td>"+data[i].itemNameD+"</td>";
				var td16 = "<td>"+data[i].realFeeD+"</td>";
				var td17 = "<td>"+data[i].arrivingD+"</td>";
				var td18 = "<td>"+data[i].workGroupNameD+"</td>";
			}else{
				var td10 = "<td>"+"</td>";
				var td11 = "<td>"+"</td>";
				var td12 = "<td>"+"</td>";
				var td13 = "<td>"+"</td>";
				var td14 = "<td>"+"</td>";
				var td15 = "<td>"+"</td>";
				var td16 = "<td>"+"</td>";
				var td17 = "<td>"+"</td>";
				var td18 = "<td>"+"</td>";
			}
			
			
			var tr = "<tr>"+ td1 + td2 + td3 + td4 + td5 + td6 + td7 + td8 + td9
	        +td10 +td11 + td12 + td13 + td14 + td15 + td16 + td17 + td18 
	        +"</tr>";
			$("#passoverDayReport_table").append(tr);
		}
		
		
	}
	
}

/*
 * 打印方法
 */
passoverDayReport.prototype.showPrintViwe = function() {
	$("#dangerous_tabConte").jqprint({
		debug : false,
		importCSS : true,
		printContainer : true,
		operaSupport : false
	})
};

/*
 * 确认导出excel
*/ 
passoverDayReport.prototype.isExportExcel = function(){
	var time =$("#passoverDayReport_time").val();
	var title =$("#bigDangerTitle").text()+"（"+$("#passoverDayReport_time").val()+"）";
	var url = path + "/passoverDayReport/exportExcel.action?time="+encodeURI(time)+"&title="+ encodeURI(title);
	window.location.href=url;
};
