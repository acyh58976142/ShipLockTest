/**
 * 报表通用方法
 * 徐骏
*/
var ReportBase = function(){
	var rowCount = 5;//最多5个元素一行
	var reportId;
	var getReportPath;
	var paramCount;
	ReportBase.prototype.createSearchForm = function(paramsPath,reportPath,resid){
		reportId = resid;
		getReportPath = reportPath;
		
		$.getJSON(paramsPath,{resid:resid},function(data){
			var html = parseParamsToHtml(data);
			$('#paramsDiv').empty();
			$('#paramsDiv').append(html);
			$('#btnQueryReport').on('click',data,queryReport);
			//除查询按钮之外不可用
			$('#btnExcelReport').attr('disabled',true);
			$('#btnExcelReport').on('click',data,excelReport);
			$('#btnPdfReport').attr('disabled',true);
			$('#btnPdfReport').on('click',data,pdfReport);
			
		//	$('#btnPrintReport').attr('disabled',true);
		//	$('#btnPrintReport').hide();
			$('#btnPrintReport').on('click',data,printReport);
		});
//		var json = '{"浮点数":{"type":"double"},"列表":{"type":"list","option":[{"":"全部"},{"4297b100518b456baefb56afb157fcf5":"一号闸"},{"d8669373bc514050aa6aacbab300da14":"二号闸"}]},"年":{"type":"dateyear"},"月":{"type":"dateyearmonth"},"天":{"type":"dateyearmonthday"},"时间":{"type":"date"}}';
//		var jsonObj = JSON.parse(json);
	};
	function printReport(data){
		if($("#reportDiv").html() !=""){
			try{
				var LODOP = getLodop();
			    if (LODOP == undefined) {
			    	// 未安装插件
			    	commonAlert("无法打印,请安装打印插件!","warning");
			        return;
			    }
			    LODOP.SET_LICENSES("广州交通信息化建设投资营运有限公司", "864607380837275858895969799998", "", "");
				
			    LODOP.SET_PRINT_PAGESIZE(2, 0, 0, "A4") ; //A4   1纵 2横向打印
			    LODOP.SET_PRINT_MODE("PRINT_PAGE_PERCENT", "Auto-Width");
			    LODOP.ADD_PRINT_HTM("6%", "5%", "90%", "90%", 
			    		"<body>"+document.getElementById("reportDiv").innerHTML+"</body>");
			    // 打印
			    //LODOP.PRINTA(); // 打印时选择打印设置(打印机)
			    LODOP.PRINT();  // 直接打印
	//		    LODOP.PREVIEW();// 打印预览
			    return ",正在打印";
			}catch(err){
				return ",未安装打印插件,无法进行打印!";
			}
		}else{
		 	commonAlert("请先检索数据","warning");
		}
	}
	
	
	//解析参数对象
	//[对象,对象]
	function parseParamsToHtml(data){
		//获得参数个数
		paramCount = data.length;
		
		var html='<div class="row common-row">';
		for(var i=0;i<data.length;i++){
			var itemObj = data[i];
			for(var property in itemObj){
				html += createHtmlByProperty(itemObj,property);
			}
		}
		
		//如果元素大于等于rowCount，查询按钮要另起一行显示，否则不好看
		if(paramCount >= rowCount){
			html += '</div><p/><div class="row common-row"><div class="col-md-12"  style="text-align: right;padding-right:50px">'
				+'<button class="btn btn-info" id="btnQueryReport"><i class="fa fa-search"></i>&nbsp;检索</button>'
				+'&nbsp;<button class="btn btn-success" id="btnExcelReport"><i class="fa fa-file-excel-o"></i>&nbsp;导出EXCEL</button>'
				+'&nbsp;<button class="btn btn-danger" id="btnPdfReport"><i class="fa fa-file-pdf-o"></i>&nbsp;导出PDF</button>'
				+'&nbsp;<button class="btn btn-primary" id="btnPrintReport"><i class="fa fa-print"></i>&nbsp;打印</button>'
				+'</div>';
		}
		else{
			html += '<div class="col-md-4">'
					+'<button class="btn btn-info" id="btnQueryReport"><i class="fa fa-search"></i>&nbsp;检索</button>'
					+'&nbsp;<button class="btn btn-success" id="btnExcelReport"><i class="fa fa-file-excel-o"></i>&nbsp;导出EXCEL</button>'
					+'&nbsp;<button class="btn btn-danger" id="btnPdfReport"><i class="fa fa-file-pdf-o"></i>&nbsp;导出PDF</button>'
					+'&nbsp;<button class="btn btn-primary" id="btnPrintReport"><i class="fa fa-print"></i>&nbsp;打印</button>'
				+'</div></div>';
		}
		//alert("参数数量:"+paramCount);
		console.info(html);
		return html;
	}
	//创建控件部分的div
	function createHtmlByProperty(data,property){
		//统一的html部分
		//获得参数个数
		var html ="";
		if (paramCount<3){
			html = '<div class="col-md-3">'
				+'<div class="form-group">'
					+'<label class="col-sm-4 common-table-searchLabel text-right">'
						+property+':'
					+'</label>'
					+ createControlByProperty(data,property)
				+'</div>'
			+'</div>';
		}
		else{
			html = '<div class="col-md-2">'
							+'<div class="form-group">'
								+'<label class="col-sm-4 common-table-searchLabel text-right">'
									+property+':'
								+'</label>'
								+ createControlByProperty(data,property)
							+'</div>'
						+'</div>';
		}
		return html;			
	}
	//根据属性创建控件
	function createControlByProperty(data,property){
		var value = data[property];
		//属性类型
		var controlHtml = '';
		var type = value.type;
		//以下为日期类型
		if(type == 'dateyear'){
			controlHtml = getDateYearHtml(property);
		}
		else if(type == 'dateyearmonth'){
			controlHtml = getDateYearMonthHtml(property);
		}
		else if(type == 'dateyearmonthday'){
			controlHtml = getDateDayHtml(property,'yyyy-MM-dd');
		}
		else if(type == 'date'){
			controlHtml = getDateDayHtml(property,'yyyy-MM-dd HH:mm:ss');
		}
		//文本类型
		else if(type == 'string'){
			controlHtml = getStringHtml(property);
		}
		//整数类型
		else if(type == 'int' || type == 'long'){
			controlHtml = getDecimalHtml(property,'/[^0-9]/g');
		}
		//浮点数
		else if(type == 'double'){
			controlHtml = getDecimalHtml(property,'/[^0-9.]/g');
		}
		//list
		else if(type == 'list'){
			var options = value.option;
			controlHtml = getListHtml(property,options);
		}
		return controlHtml;
		//console.info(controlHtml);
	}
	
	//年dateyear
	function getDateYearHtml(property){
		var html='<div class="col-sm-8 common-table-searchInput">'
					+'<select id="'+property+'" class="form-control">';
		//当前年-2000年
		 var date=new Date;
		 var year=date.getFullYear(); 
		 while(year >= 2000){
			 html += '<option>'+year+'</option>';
			 year --;
		 }
		 html += '</select>';
		 html += '</div>';
		 return html;
	}
	
	//月dateyearmonth
	function getDateYearMonthHtml(property){
		 var html='<div class="col-sm-4 common-table-searchInput">'
			 +'<select id="'+property+'_year" class="form-control">';
		//当前年-2000年
		 var date=new Date;
		 var year=date.getFullYear(); 
		 while(year >= 2000){
			 html += '<option>'+year+'</option>';
			 year --;
		 }
		 html += '</select>'
			 +'</div>'
			 +'<div class="col-sm-4 common-table-searchInput">'
			 +'<select id="'+property+'_month" class="form-control">';
		 for(var i=1;i<13;i++){
			 var month = ''+i;
			 if(i<10){
				 month = '0'+i;
			 }
			 html +='<option>'+month+'</option>';
		 }
		 html += '</select>'
			 +'</div>'
		 return html;
	}
	//日dateyearday yyyy-MM-dd HH:mm
	function getDateDayHtml(property,timeFmt){
		var html='<div class="col-sm-8 common-table-searchInput">'
					+'<input type="text"   id="'+property+'" placeholder="请选择时间" onfocus="WdatePicker({dateFmt:\''+timeFmt+'\',skin:\'twoer\',readOnly:true})" class="Wdate common-datepicker dateselect" />'
					+'<span style="float: right;margin: -27px 10px;"><i class="fa fa-calendar"></i></span>'
					+'</div>';
		 return html;
	}
	
	function getStringHtml(property){
		var html='<div class="col-sm-8 common-table-searchInput">'
			+'<input id="'+property+'" type="text" class="form-control text-left">'
			+'</div>';
		return html;
	}
	
	function getDecimalHtml(property, regular){
		var html = '<div class="col-sm-8 common-table-searchInput">'
				     +'<input id="'+property+'" type="text" class="form-control text-left">'
				  +'</div>'
				  +'<script>'
				  +'$("#'+property+'").keyup(function(){'   
				  		+'$(this).val($(this).val().replace('+regular+',\'\')); '
				  +'}).bind("paste",function(){'
				  		+'$(this).val($(this).val().replace('+regular+',\'\'));'
				  +'}).css("ime-mode", "disabled");'
				  +'</script>';		
		return html;
	}
	function getListHtml(property,options){
		 var html='<div class="col-sm-8 common-table-searchInput">'
			+'<select id="'+property+'" class="form-control">'; 
		 for(var i=0;i<options.length;i++){
			 var option = options[i];
			 for(var key in option){
				 html += '<option value=\''+key+'\'>'+option[key]+'</option>';
			 }
		 }
		 html += '</select>';
		 html += '</div>';
		 return html;
	}
	
	function getQueryParam(data)
	{
		//参数字符串
		var urlParams = '';
		for(var i=0;i<data.length;i++){
			var itemObj = data[i];
			for(var property in itemObj){
				//属性值
				var value = itemObj[property];
				//属性类型
				var type = value.type;
				//以下为日期类型
				if(type == 'dateyear'){
					var year = $('#'+property).val();
					var p = property+'='+year+'_01_01_00_00_00,date';
					urlParams +='&'+p;
				}
				else if(type == 'dateyearmonth'){
					var yearMonth = $('#'+property+'_year').val()+"_"+ $('#'+property+'_month').val();
					var p = property+'='+yearMonth+'_01_00_00_00,date';
					urlParams +='&'+p;
				}
				else if(type == 'dateyearmonthday'){
					var day = $('#'+property).val();
					//不填就为当天
					if(day == ''){
						var now=new Date();
						day = now.format('yyyy-MM-dd');
					}
					var dayArray = day.split('-');
					var p = property+'='+dayArray[0]+'_'+dayArray[1]+'_'+dayArray[2] +'_00_00_00,date';
					urlParams +='&'+p;
					
				}
				else if(type == 'date'){
					var date = $('#'+property).val();
					//不填就为当天
					if(date == ''){
						var now=new Date();
						date = now.format('yyyy-MM-dd hh:mm:ss');
					}
					var dateArray = date.split(' ');
					var dayArray = dateArray[0].split('-');
					var timeArray = dateArray[1].split(':');
					var p = property+'='+dayArray[0]+'_'+dayArray[1]+'_'+dayArray[2]+'_'+timeArray[0]+'_'+timeArray[1]+'_'+timeArray[2] +',date';
					urlParams +='&'+p;
				}
				//文本类型 //整数类型 //浮点数
				else if(type == 'string' || type == 'int' || type == 'long' || type == 'double' || type == 'list'){
					var txt = $('#'+property).val();
					var p = property+'='+txt;
					urlParams +='&'+p;
				}
				//列表
				else if(type == 'list'){
					var txt = $('#'+property).val();
					var p = property+'='+txt;
					urlParams +='&'+p;
				}
			}
		}
		return urlParams;
	}
	function queryReport(event){
		//判断开始时间和结束时间
		var obj = $(".dateselect");
		if (obj){
			if (obj.length>1){
				var startTime = obj[0].value;
				var stopTime = obj[1].value;
				var sdate = Date.parse(startTime.replace(/-/g,"/"));
				var edate = Date.parse(stopTime.replace(/-/g,"/"));
				
				if(edate < sdate){
					swal({title:"结束时间必须大于开始时间！",confirmButtonText:"确定"});
					return;
				}
			}
		}
		
		//参数字符串
		var urlParams = getQueryParam(event.data);
		var temp = 'resid='+reportId+urlParams ;
	//	var url = getReportPath+'service=htmlserver&method=html&resid='+reportId+encodeURI(urlParams) ;
		var url = getReportPath+'service=htmlserver&method=html&'+encodeURI(temp) ;
		console.info(url);
		$('#reportDiv').empty();
		$('#reportDiv').append('<div id="#loadReportDiv" class="loading"><img src="loading.gif"/><br/>正在加载...</div>');
		$('#reportDiv').load(url,function(){
			$('#reportDiv').append('<style>.r2{height:24pt;}</style>');
			$('#btnExcelReport').attr('disabled',false);
			$('#btnPdfReport').attr('disabled',false);
			$('#btnPrintReport').attr('disabled',false);
		});
	};
	function excelReport(event){
		var urlParams = getQueryParam(event.data);
		var temp = 'resid='+reportId+urlParams ;
		var url = getReportPath+'service=xlsserver&method=stream&'+encodeURI(temp) ;
		console.info(url);
		$('<form method="post" action="' + url + '"></form>').appendTo('body').submit().remove();
	}
	function pdfReport(event){
		var urlParams = getQueryParam(event.data);
		var temp = 'resid='+reportId+urlParams ;
		var url = getReportPath+'service=pdfserver&method=stream&'+encodeURI(temp) ;
		$('<form method="post" action="' + url + '"></form>').appendTo('body').submit().remove();
	}
}
