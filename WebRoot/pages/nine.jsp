<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'nine.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/nine.js"></script>
	<style type="text/css">
		p:FIRST-LETTER{
			color:blue;
			font:50px 'Arial' ,sens -serif
		}
	</style>
  </head>
  
  <body>
  	<p>
  		测试css 代码段
  	</p>
   	<p style="color: #999999;font-family: 黑体,宋体,楷体;font-size: 55px" id="pp">
   		这是测试style代码段
   	</p>
   	<script type="text/javascript">
   		var para =document.getElementById('pp');
   		//alert(typeof para.nodeName);
   		//alert(typeof para.style)
   		//console.info(para.style)
   		//para.style.color='green';
   		//alert(para.style.fontSize)
   		//alert(para.style.fontFamily)
   	</script>
   	<p id='p2' >
   		测试代码段2 style 测试代码段2
   	</p>
   	<script type="text/javascript">
   		var para2 = document.getElementById('p2')
   		//alert(para2.style.color)
   		//para2.style.font="20px '楷体'"
   	</script>
  </body>
</html>
