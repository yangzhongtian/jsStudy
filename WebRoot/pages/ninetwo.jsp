<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ninetwo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/ninetwo.js"></script>
  </head>
  
  <body>
   	<h1>第一标题</h1>
   	<p>第一段第一段第一段第一段</p>
   	<p>第二段第二段第二段第二段</p>
   	<p>第三段第三段第三段第三段</p>
   	<h1>第二标题</h1>
   	<p>第一段第一段第一段第一段</p>
   	<p>第二段第二段第二段第二段</p>
   	<p>第三段第三段第三段第三段</p>
  </body>
</html>
