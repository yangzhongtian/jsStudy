<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'templete.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="styles/syn/color.css">
  </head>
  
  <body>
  <header>
  	<img alt="javascript demo image" src="image/syn/logo.gif">
    <nav>
    	<ul>
    		<li>
    			<a href="pages/syn/index.jsp">Home</a>
    		</li>
    		<li>
    			<a href="pages/syn/about.jsp">About</a>
    		</li>
    		<li>
    			<a href="pages/syn/photos.jsp">Photos</a>
    		</li>
    		<li>
    			<a href="pages/syn/live.jsp">Live</a>
    		<li>
    			<a href="pages/syn/contact.jsp">Concact</a>
    		</li>
    	</ul>
    </nav>
  </header>
  <article>
		<h1>春江花月夜</h1>
		<p>
	
			作者：张若虚<br/>
			
			春江潮水连海平，海上明月共潮生。 <br/>
			滟滟随波千万里，何处春江无月明! <br/>
			江流宛转绕芳甸，月照花林皆似霰; <br/>
			空里流霜不觉飞，汀上白沙看不见。 <br/>
			江天一色无纤尘，皎皎空中孤月轮。 <br/>
			江畔何人初见月？江月何年初照人？ <br/>
			人生代代无穷已，江月年年望相似。 <br/>
			不知江月待何人，但见长江送流水。 <br/>
			白云一片去悠悠，青枫浦上不胜愁。 <br/>
			谁家今夜扁舟子？何处相思明月楼？ <br/>
			可怜楼上月徘徊，应照离人妆镜台。 <br/>
			玉户帘中卷不去，捣衣砧上拂还来。 <br/>
			此时相望不相闻，愿逐月华流照君。 <br/>
			鸿雁长飞光不度，鱼龙潜跃水成文。 <br/>
			昨夜闲潭梦落花，可怜春半不还家。 <br/>
			江水流春去欲尽，江潭落月复西斜。 <br/>
			斜月沉沉藏海雾，碣石潇湘无限路。 <br/>
			不知乘月几人归，落月摇情满江树。 <br/>
		</p>
  </article>
  </body>
</html>
