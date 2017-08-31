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
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request,response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("normal.jsp");
				rd.forward(request,response);
			}
		%>
	</body>
</html>
