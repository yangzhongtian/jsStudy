<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tenthree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="styles/tenthree.css">
	<script type="text/javascript" src='js/tenthree.js'></script>
  </head>
  
  <body>
  	<h1>Web Design</h1>
   	<p>These are things you are know</p>
   	<ul id='uls'>
   		<li>
   			<a href='image/2.jpg' id='a1'>Structure</a>
   		</li>
   		<li>
   			<a href='image/3.jpg' id='a2'>Presentation</a>
   		</li>
   		<li>
   			<a href='image/4.jpg' id='a3'>Behavour</a>
   		</li>
   	</ul>
   	
   	<div id="slidimg">
   		<img alt="预览图" src="image/1.jpg" id='preview'>
   	</div>
  </body>
</html>
