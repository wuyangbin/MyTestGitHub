<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>工资导入页</title>
<style type="text/css">
*{
margin:0;
padding:0;
}
body{
  background-color:  #66b2ff;
}
#form_div{
   text-align: center;
   margin-top:11%;
  
}
form {
  line-height:3em;
}
input{
  font-size:20px;
}
.button_normal{
  position:relative;
  right:60px;
  margin:10px;
  padding:0 10px;
}
h2{
 position:relative;
  right:60px;
}
#img_div{
background-color: white;
height:90px;
}
img{margin-left:7%;}


</style>
</head>
<body>

<div id="img_div"><img src="img/picc.PNG"></div>
    <div id="form_div">
    <h2>同步数据（Excel表格）</h2><br><br>
	<form action="excel/tongbu.html" id="form_query" method="post"	enctype="multipart/form-data">
		从<input type="file" id="fromfile" name="fromfile"  onchange="fileChange(this)" /><br> 
		到<input type="file" id="tofile" name="tofile"  onchange="fileChange(this)" /><br> 
		
		<input type="submit" id="dr"	value="同步" class="button_normal" /> 
		<input type="reset" id="qk"	value="清空" class="button_normal" />
		 
	</form><br><br>
	
   </div>
   <script src="../plugins/jquery-3.3.1.slim.js" type="text/javascript"></script>
	<script type="text/javascript">
	  
	    if("${msg}"==2){
	    	alert("同步成功");
	    }
	    if("${msg}"==1){
	    	alert("同步失败");
	    }
		function fileChange(input) {
			var fileName =input.value;
			
			if (fileName.length > 1 && fileName) {
				
				var ldot = fileName.lastIndexOf(".");
				var type = fileName.substring(ldot + 1);
				if (type == "xls" || type == "xlsx") {
					
				} else {
					alert("文件格式不准确！");
					input.outerHTML = input.outerHTML.replace(
							/(value=\").+\"/i, "$1\"")
				}
			}
		}
	</script>
</body>
</html>