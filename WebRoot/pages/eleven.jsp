<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'eleven.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<canvas id='draw' width='400px' height='300px'>
   		<p>
   			power by Html5 canvas
   		</p>
   	</canvas>
   	<script type="text/javascript">
   		var canvas = document.getElementById('draw');
   		if(canvas.getContext){
   			alert('hello')
   			var ctx = canvas.getContext('2d');
   			ctx.beginPath();
   			ctx.moveTo(120.0,32.0);
   			ctx.fill();
   			
   		}
   	</script>
  </body>
</html>
