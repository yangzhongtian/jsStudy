<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'two.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles/layout.css">
	
	<script type="text/javascript" src="js/three.js"></script>
  </head>
  
  <body>
    <h1>图片列表显示</h1>
    <p>
    	<ul>
    		<li>
    			<a href="image/1.jpg" title="man" onclick="showPic(this);return false">man</a>
    		</li>
    		<li>
    			<a href="image/2.jpg" title="sky" onclick="showPic(this);return false">天空</a>
    		</li>
    		<li>
    			<a href="image/3.jpg" title="blue" onclick="showPic(this);return false">蓝</a>
    		</li>
    		<li>
    			<a href="image/4.jpg" title="starSky" onclick="showPic(this);return false">星空</a>
    		</li>
    	</ul>
    </p>
    
    <img alt="photos" src="" width="500" height="500">
    <p id="description">请选择一副图片</p>
  </body>
</html>
