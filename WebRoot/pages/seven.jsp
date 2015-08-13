<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'seven.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		li{
			color:green;
		}
	</style>
	<script type="text/javascript" src="js/seven.js"></script>
	<script type="text/javascript">
		/*
		 * 
		document.write("<p id='y'>这篇文章</p>")
		document.write("<p>ldlsdlfjl</p>")
		console.info(document.getElementById('y')) */
		window.onload=function(){
			var testDiv = document.getElementById("testDiv");
			//alert(testDiv.innerHTML);
			var testDiv2  = document.getElementById("testDiv2");
			testDiv2.innerHTML="<p><ul><li>电脑</li><li>汽车</li><li>公司</li></ul></p>"
			//testDiv.innerHTML="<p><ul><li>电脑</li><li>汽车</li><li>公司</li></ul></p>"
			
			var p = document.createElement("p")
			alert("nodeName="+p.nodeName+";nodeType="+p.nodeType);
			document.getElementById('testDiv3').appendChild(p);
			var text = document.createTextNode("helloWorld");
			p.appendChild(text)
			
			var p = document.createElement("p");
			var text1 = document.createTextNode("hello")
			var em =document.createElement("em")
			var text3 = document.createTextNode("em");
			var text2 = document.createTextNode("World");
			em.appendChild(text3)
			p.appendChild(text1);
			p.appendChild(em);
			p.appendChild(text2);
			document.getElementById("testDiv3").appendChild(p);
		}
	</script>
  </head>
  
  <body>
    <div id="testDiv" style="border:solid green 5px;width:300;height: 50">
    	<p>hello<em>em</em>test</p>
    </div>
    <script type="text/javascript">
    	document.write('写在中间')
    </script>
    <div id ="testDiv2">
    </div>
    <div id ="testDiv3" style="border: solid blue 5px ; width: 500;height: 150;">
    </div>
    
  </body>
</html>
