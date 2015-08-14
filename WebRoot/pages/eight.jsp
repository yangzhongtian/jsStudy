<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'eight.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			font-family: 'Helvetica','Arial',sans-serif;
			font-size: 15px;
		}
		abbr {
			text-decoration: underline;
			border: 1;
			font-style: italic;
		}
	</style>
	<script type="text/javascript" src="js/eight.js"></script>
  </head>
  
  <body>
   <h1> what is the Document Object Model?</h1>
   
   <p id='one'>
   		The <abbr title="world wide web" id='tes'><em>w3c</em></abbr> define <abbr title="Document Object Model">Dom</abbr> as
   </p>
   <blockquote cite="http://www.3c.org/Dom">
   	<p> 
   		a plateform - and languge-netural interface that will  allow programs or scripts to dynamiclly  access and update the content style and structure of document
   	</p>
   	</blockquote>
   	It's <abbr title="Application progra interface">API</abbr> that can be used <abbr title="Htyxy Text MarkUp langue">HTML</abbr> and <a title="XHMl markup langue">XML</a>
  </body>
</html>
