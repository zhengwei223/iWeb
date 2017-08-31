<%@ page language="java" contentType="text/html; charset=GBK"%>
<html>
	<head>
		<title>显示结果页面</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("GBK");
			String name = request.getParameter("name");
		%>
		您好，您是管理员：<%=name%>，欢迎进入本页面！
	</body>
</html>
