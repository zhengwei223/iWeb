<%@ page language="java" contentType="text/html; charset=GBK"%>
<html>
	<head>
		<title>ตวยผดฆภําณรๆ</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("GBK");
			String name = request.getParameter("name");
			String pwd = request.getParameter("pwd");
			if(name.equals("admin")&& pwd.equals("admin")){
				response.sendRedirect("admin.jsp");
				//response.sendRedirect("admin.jsp?name=" + name);
			}else{
				response.sendRedirect("normal.jsp");
				//response.sendRedirect("normal.jsp?name=" + name);
			}
		%>
	</body>
</html>
