/**
 * 构造函数
 * */
function dangerous(){	
	/** 初始化时间 */
	this.initDate();
	/** 初始化表格*/
	this.initTable();
	/**查询*/
	$("#query_btn").click(bind(this,this.queryInfo));
	/**打印*/
	$("#dangerous_print_btn").click(bind(this,this.showPrintViwe));
	/**导出*/
	$("#dangerous_exportExcel").click(bind(this,this.exportExcel));
}
//查询	
dangerous.prototype.queryInfo = function() {
	dangerous.initTable();
}

/**
 * 初始化时间
 * */
dangerous.prototype.initDate = function () {
	var date=new Date();
	date.setHours(0);
	date.setMinutes(0);
	date.setSeconds(0);
	$("#queryTime").val((new Date()).format("yyyy-MM"));
//	$("#queryTime").val("2017-05");
}

/**
 * 初始化表格
 * */
dangerous.prototype.initTable = function() {
	$("#dangerous_table_tbody").html("");
	$.ajax({
		"type" : "post", // post防止中文参数乱码
		"url" : path + "/dangerous/queryTable.action",
		"data" : {
			queryTime : $("#queryTime").val()
		},
		"success" : bind(this, this.bindDate),
		"error" : function() {
			alert("查询数据错误")
		}
	});
}

dangerous.prototype.bindDate = function(data) {
	$("#dangTitle").html(data.stationName);
	var day ="";
	if(data.date != null && data.date != null && data.date != undefined){
		$("#year").html(data.date.year);
		$("#month").html(data.date.month);
		day = data.date.day;
	}
	var data=data.listDate;
	var num1=0.0;
	var tonnageTns1=0.0;
	var realfee1=0.0;
	var num2=0.0;
	var tonnageTns2=0.0;
	var realfee2=0.0;
	for(var i = 1 ; i<=day; i++){
		if(data != null && data != null && data != undefined){
			var td1 = "<td>"+i+"</td>";
			var td2 = "<td>0</td>";
			var td3 = "<td>0</td>";
			var td4 = "<td>0</td>";
			var td5 = "<td>"+i+"</td>";
			var td6 = "<td>0</td>";
			var td7 = "<td>0</td>";
			var td8 = "<td>0</td>";
			
			for(var j = 0 ; j<data.length; j++){
				var index = (data[j].lockageTime).split("-")[2];//序号
				if(index == i){
					if(data[j].location == "0"){//上行
						var td1 = "<td>"+i+"</td>";
						var td2 = "<td>"+data[j].num+"</td>";
						var td3 = "<td>"+data[j].tonnageTns+"</td>";
						var td4 = "<td>"+data[j].realfee+"</td>";
						
						num1 += parseFloat(data[j].num);
						tonnageTns1 += parseFloat(data[j].tonnageTns);
						realfee1 +=parseFloat(data[j].realfee);
					}else{//下行
						var td5 = "<td>"+i+"</td>";
						var td6 = "<td>"+data[j].num+"</td>";
						var td7 = "<td>"+data[j].tonnageTns+"</td>";
						var td8 = "<td>"+data[j].realfee+"</td>";
						
						num2 += parseFloat(data[j].num);
						tonnageTns2 += parseFloat(data[j].tonnageTns);
						realfee2 +=parseFloat(data[j].realfee);
					}
				}
				
			}
		}
		var tr = "<tr>"+ td1 + td2 + td3 + td4 + td5 + td6 + td7 + td8 +"</tr>";
		$("#dangerous_table_tbody").append(tr);
	}
	var td1 = "<td>合计</td>";
	var td2 = "<td>"+ num1.toFixed(2) +"</td>";
	var td3 = "<td>"+ tonnageTns1.toFixed(2) +"</td>";
	var td4 = "<td>"+ realfee1.toFixed(2) +"</td>";
	
	var td5 = "<td>合计</td>";
	var td6 = "<td>"+ num2.toFixed(2)+"</td>";
	var td7 = "<td>"+tonnageTns2.toFixed(2)+"</td>";
	var td8 = "<td>"+realfee2.toFixed(2)+"</td>";
	
	var tr = "<tr>"+ td1 + td2 + td3 + td4 + td5 + td6 + td7 + td8 +"</tr>";
	$("#dangerous_table_tbody").append(tr);
	
	var td1 = "<td>累计数量</td>";
	var td2 = "<td>"+ (num1+num2).toFixed(2) +"</td>";
	var td3 = "<td>累计吨数</td>";
	var td4 = "<td>"+ (tonnageTns1+tonnageTns2).toFixed(2) +"</td>";
	
	var td5 = "<td>累计金额</td>";
	var td6 = "<td>"+ (realfee1+realfee2).toFixed(2) +"</td>";
	var td7 = "<td></td>";
	var td8 = "<td></td>";
	
	var tr = "<tr>"+ td1 + td2 + td3 + td4 + td5 + td6 + td7 + td8 +"</tr>";
	$("#dangerous_table_tbody").append(tr);
}

/**
 * 打印
 */
dangerous.prototype.showPrintViwe = function() {
	$("#dangerous_tabConte").jqprint({
		debug : false,
		importCSS : true,
		printContainer : true,
		operaSupport : false
	})
};

/**
 * 导出
 */
dangerous.prototype.exportExcel = function(){
	var time =$("#queryTime").val();
	var title =$("#bigDangerTitle").text()+"（"+$("#sDangerTitle").text()+"）";
	var url = path + "/dangerous/exportExcel.action?time="+encodeURI(time)+"&title="+ encodeURI(title);
	window.location.href=url;
};
