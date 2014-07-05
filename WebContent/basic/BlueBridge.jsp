<%@ page language="java" import="java.util.*,java.text.*" contentType= "text/html; charset=GB2312" %>
<html>
	<head>
		<title>运用后端技术处理业务逻辑</title>
	</head>
	<body>
		<!--HTML输出-->
		今天是学习JSP的第一天！ <br>
		<%--用输出标签直接输出--%>
		<%="明天是学习JSP的第二天！"%><br>
		<%
			//定义字符串变量，用out对象输出
		%>
		<%
			String str = "后天是学习JSP的第三天！";
			out.println(str);
		%>
	</body>
</html>
