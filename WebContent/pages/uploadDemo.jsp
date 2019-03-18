<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="lib/bootstrap-3.3.5-dist/js/jquery-1.11.3.min.js"></script>
<script src="lib/jquery.form.js"></script>
</head>
<body>
	<script>
		$(document).ready(function() {
			//上传
 			$('#btnUpload').bind("click",function(){
 				
 				var file = $('#upload').val();
 				if(file == '')
 				{
 					alert('请选择需要上传的图片');
 					return;
 				}
 				var options =
 				{   
 	                url:"<%=request.getContextPath()%>/upload?processor=vesselPicture",   
 	                type:'post',                    
 	                data:null,
 	                dataType:"json",
 	                success:function(data)
 	                {
 	                	if(data.succ)
 	                	{
 	                		//展示缩略图片
 	                		$('#vesselPic').attr("src",data.thumbnailUrl);
 	                	}
 	                	else
 	                	{
 	                		alert('上传图片失败,服务器端发生异常!');
 	                	}
 	                	
 	                }   
 	            };
 	            $('#imageForm').ajaxSubmit(options);
 			});
		});
	</script>
	<div>
	  <label>船舶图片预览</label>
	  <image id="vesselPic" style="width:120;height:120"/>
	</div>
	
	<form id="imageForm"   enctype="multipart/form-data" >
		<input name="upload" id="upload" type="file" accept=".png,.jpg,.jpeg,.gif">
		<button id="btnUpload" type="button" class="btn btn-primary btn-xs">上传</button>
	</form>
</body>
</html>