<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
	<head>
		<title>管理后台页面</title>
	</head>
	<body>
		<%@ include file="adminLogin.jsp" %>
		您好，您是管理员：<%=name%>，欢迎进入管理后台！	
    	<ul>
        	<li><a href="#">添加图书</a></li>
            <li><a href="#">修改图书</a></li>
            <li><a href="#">图书上架</a></li>
            <li><a href="#">图书下架</a></li>
            <li><a href="#">退出</a></li>
        </ul>
	</body>
</html>
