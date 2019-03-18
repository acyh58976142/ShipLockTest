

/**
 * Ajax发送POST请求，自动将js定义的变量对象转为json参数。可用在模糊查询上
 */
var fuzzyQuery = function(url,paramObj,success){
	commAjax({
        type:"post",
        url:url,
	 	dataType:"json",      
	 	contentType:"application/json",   
	 	data:JSON.stringify(paramObj),
        success:success
   });
};

var commonAjax = function(url,paramObj,beforeSend,success,complete){
	commAjax({
        type:"post",
        url:url,
	 	dataType:"json",
	 	beforeSend:beforeSend,      
	 	contentType:"application/json",   
	 	data:JSON.stringify(paramObj),
        success:success,
        complete:complete
   });
};


/**
 * 先引入sweetAlert的样式和js
 * title:弹出框标题
 * type:"warning", "error", "success" and "info"(弹出框类型)
 * callback:回调函数
 * param:参数
 * */
var commonAlertAjax=function(title,type,callback,param){
	swal({
		title : title,
		type : type,//窗口的类型 有4种类型的图标动画：”warning”, “error”, “success” 和 “info”
		showCancelButton : true,//如果设置为“true”，“cancel”按钮将显示，点击可以关闭警告框。
		confirmButtonColor : "#DD6B55",//该参数用来改变确认按钮的背景颜色（必须是一个HEX值）。
		confirmButtonText : "确认",//确认
		cancelButtonText : "取消",//取消
		closeOnConfirm : false,//如果希望以后点击了确认按钮后模态窗口仍然保留就设置为”false”。该参数在其他SweetAlert触发确认按钮事件时十分有用。
		closeOnCancel : true,//该属性设置为true后 启用取消按钮
		allowOutsideClick:true//如果设置为true，用户可以通过点击警告框以外的区域关闭警告框。
	},
	function(){
		callback(param);
	});	 
};
/**
 * 先引入sweetAlert的样式和js
 * title:弹出框标题
 * type:"warning", "error", "success" and "info"(弹出框类型)
 * callback:回调函数
 * param:参数
 * */
var commonAlertAjax=function(title,type,callback,param){
	swal({
		title : title,
		type : type,//窗口的类型 有4种类型的图标动画：”warning”, “error”, “success” 和 “info”
		showCancelButton : true,//如果设置为“true”，“cancel”按钮将显示，点击可以关闭警告框。
		confirmButtonColor : "#DD6B55",//该参数用来改变确认按钮的背景颜色（必须是一个HEX值）。
		confirmButtonText : "确认",//确认
		cancelButtonText : "取消",//取消
		closeOnConfirm : false,//如果希望以后点击了确认按钮后模态窗口仍然保留就设置为”false”。该参数在其他SweetAlert触发确认按钮事件时十分有用。
		closeOnCancel : true,//该属性设置为true后 启用取消按钮
		allowOutsideClick:true//如果设置为true，用户可以通过点击警告框以外的区域关闭警告框。
	},
	function(){
		callback(param);
	});	 
};


/**
 * 先引入sweetAlert的样式和js
 * title:弹出框标题
 * type:"warning", "error", "success" and "info"(弹出框类型)
 * */
var commonAlert=function(title,type){
	swal({
		title : title,
		type : type,//窗口的类型 有4种类型的图标动画：”warning”, “error”, “success” 和 “info”
		confirmButtonColor : "#58c0de",//该参数用来改变确认按钮的背景颜色（必须是一个HEX值）。
		confirmButtonText : "确认"//确认
		//timer:2000 //2秒后自动消失
	});	 
};


/**
 * 对Date的扩展，将 Date 转化为指定格式的String 
 * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
 * (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
 * */
Date.prototype.format = function(fmt) { //author: meizz 
 		var o = { 
	    "M+" : this.getMonth()+1,                 //月份 
	    "d+" : this.getDate(),                    //日 
	    "h+" : this.getHours(),                   //小时 
	    "m+" : this.getMinutes(),                 //分 
	    "s+" : this.getSeconds(),                 //秒 
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	    "S"  : this.getMilliseconds()             //毫秒 
  	}; 
  	if(/(y+)/.test(fmt)) 
    	fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  	for(var k in o) 
    	if(new RegExp("("+ k +")").test(fmt)) 
  			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
  	return fmt; 
};

/**
 * String清除所有的空格
 * */
String.prototype.trim=function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
/**
 * String只清除文本左边空格
 * */
String.prototype.ltrim=function(){
    return this.replace(/(^\s*)/g,"");
};
/**
 * String只清除文本右边空格
 * */
String.prototype.rtrim=function(){
    return this.replace(/(\s*$)/g,"");
};


/**
 * 绑定this
 */
var bind = function(scope, funct) {
	return function() {
		return funct.apply(scope, arguments);
	};
}

/**
 * 获取session
 */
var commonGetSession = function(path,callback){
	var success = function(session){
		//执行的方法
		callback(session);
	};
	commAjax({
		type : "post",
		async: false,
		url : path + "/Login/getSession.action",
		data : {},
		success : bind(this,success)
	});
};

/**
 * 生成指定类型字典项的option(不包括货物种类及货物品种)
 * @path 项目路径
 * @selectId select选择框Id
 * @itemKey 数据项key
 * @isAll 是否要显示一个value为空text为<全部> 的选项
 * @undesired 不需要显示的option value值
 */
var dictOption = function(path,selectId,itemKey,isAll,undesired){
	commAjax({			
		"type": "post",	//post防止中文参数乱码
		"url": path +"/dictionry/getCacheDictionry.action",
		"async": false,
		"data":{
			"itemKey":itemKey,
		},
		"success": function(data){
			$("#"+selectId).empty();
			if(data){
				if(isAll){
					$("#"+selectId).append("<option value=''>全部</option>");
				}
				for(var val in data){
					if(val!=undesired){
					$("#"+selectId).append("<option value='"+val+"'>"+data[val]+"</option>");
					}
				}
			}
		}
	});
};
/**
 * DateTables控件汉化
 * */
var dataTableLang={
					"sProcessing": "加载中...",
					"sLengthMenu": "显示_MENU_条 ",
					"sZeroRecords": "暂无内容",
					"sInfo": "第_START_ 到 _END_ 条 &nbsp;&nbsp;共  _TOTAL_ 条",
					"sInfoEmpty": "第 0 到 0 条   共 0 条",
					"sInfoFiltered": "(全部记录数 _MAX_ 条)",
					"sInfoPostFix": "",
					"sSearch": "搜索",
					"sUrl": "",
					"oPaginate": {
						"sFirst":  "首页",
						"sPrevious": "上一页 ",
						"sNext":   "下一页 ",
						"sLast":   "尾页 "
					} 
};

/*
 * 获取dataTable每页显示多少条记录
 */
var pageLength=function(path){
	var url=path +"/sysparams/pageLength.action";
	var param=new Object();
	param.key="DATATABLE_PAGENUMBER";
	var resulat=10;
	commAjax({
        type:"post",
        url:url,
	 	dataType:"json",      
	 	contentType:"application/json",   
	 	data:JSON.stringify(param),
	 	async: false,
        success:bind(this,function(data){
        	resulat=data;
        })
   });
	return resulat;
};

/**
 * 公共调用Ajax
 */
var commAjax = function(settings){
	settings.error = function(XMLHttpRequest, msg, e){
        // 统一错误处理
		var url = settings.url;
    	var path = url.substring(0,url.indexOf("/",2));
    	top.location.href ="/ShipLock/pages/login/login.jsp";
    };
    $.ajax(settings);
};
