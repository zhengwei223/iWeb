<%@ page contentType="text/html; charset=utf-8" %>
<html>
	<head>
		<title>JSP脚本——小脚本</title>
	</head>
	<body>
	<%
		int age = 21;
		if(age < 18) { 
			out.println("你是未成年人，不可以购买香烟！"); 
		}else{ 
			out.println("你已经成年了，可以购买香烟"); 
		} 
	%>
	</body>
</html>
