<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ninethree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/nineThree.js"></script>
	<link rel="stylesheet" type="text/css" href="styles/ninethree.css">
  </head>
  
  <body>
  
    <table>
    	<caption>caption 标签-- 表格标题</caption>
    	<thead>
    		<tr>
    			<th>WHEN</th>
    			<th>WHERE</th>
    			<th>dsd加表格宽度</th>
    		</tr>
    	</thead>
    	<tbody>
    		<tr>
    			<td>7月1</td>
    			<td>天安门</td>
    			<td>表格宽度</td>
    		</tr>
    		<tr>
    			<td>7月8</td>
    			<td>故宫</td>
    			<td>表格宽度</td>
    		</tr>
    		<tr>
    			<td>7月15</td>
    			<td>长城</td>
    			<td>表格宽度</td>
    		</tr>
    		<tr>
    			<td>7月22</td>
    			<td>鸟巢</td>
    			<td>表格宽度</td>
    		</tr>
    	</tbody>
    	<tfoot>
    		
    	</tfoot>
    </table>
  </body>
</html>
