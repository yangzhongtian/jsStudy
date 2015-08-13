<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>one </title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- <script type="text/javascript" src="js/one.js"></script> -->
	<script type="text/javascript" src="js/two.js"></script>
	<style type="text/css">
		body{
			color:white;
			background-color: black;
		}
		.special{
			font-style:italic
		}
		#purchases li{                           //样式重复用子节点的 color 最后显示是green
			font-weight: bold;
			color: green
		}
		#purchases{
			border:1px solid white;
			background-color: #333;
			color: red
		}
	</style>
  </head>
  
  <body>
  <h2 class="special">测试标题</h2>
    <p title="helel" class="special">what to buy</p>
    <ol id="purchases">
    	<li class='buy first' >computer</li>
    	<li class='buy'>car</li>
    	<li class='buy'>budling</li>
    </ol>
    <p>
    	hello 
    </p>
    <script type="text/javascript">
    	//alert(typeof document.getElementById('purchases'));
    	//var items  = document.getElementsByTagName('li');
    	//for(var i =0 ;i<items.length;i++){
    	//	console.log(items[i].innerHTML);
    	//}
    	
    </script>
  </body>
</html>
