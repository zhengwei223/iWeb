<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
	<head>
		<title>显示结果页面</title>
	</head>
	<body>
		<%@ include file="normalLogin.jsp" %>
		您好，这是普通用户内容页，您是：<%=name%>，欢迎进入本页面！	
    	<ul>
        	<li><a href="#">图书信息</a></li>
            <li><a href="#">购物车</a></li>
            <li><a href="#">订单管理</a></li>
            <li><a href="#">退出</a></li>
        </ul>
	</body>
</html>

