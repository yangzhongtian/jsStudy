<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'three.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="styles/layout.css">
	
	<script type="text/javascript" src="js/four.js"></script>
  </head>
  
  <body>
  <!--    <a href="javascript:void(0)" onclick="popWin('http://www.baidu.com')">弹出窗口</a>
    <a href="http://www.baidu.com" onclick="popWin(this.href);return false">弹出窗口</a>-->
    
  	<a href="javascript:void(0)" class="popWin" >弹出窗口</a>
    <a href="http://www.baidu.com" class="popWin">弹出窗口</a>
    <h1>图片列表显示</h1>
    <p>
    	<ul>
    		<li>
    			<a href="image/1.jpg" title="man" >
					<img alt="1" src="image/1.jpg">
				</a>
    		</li>
    		<li>
    			<a href="image/2.jpg" title="sky" ">
					<img alt="2" src="image/2.jpg">
				</a>
    		</li>
    		<li>
    			<a href="image/3.jpg" title="blue" ><img alt="1" src="image/3.jpg"></a>
    		</li>
    		<li>
    			<a href="image/4.jpg" title="starSky"  ><img alt="4" src="image/4.jpg"></a>
    		</li>
    	</ul>
    </p>
    
    <img alt="photos" src="" width="500" height="500">
    <p id="description">请选择一副图片</p>
    <input type="text" onkeypress="alert('hllo')" />
  </body>
</html>
