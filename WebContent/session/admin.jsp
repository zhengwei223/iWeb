<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
	<head>
		<title>管理后台页面</title>
	</head>
	<body>
		<%
			//判断用户是否以管理员身份访问本页面，如不是则跳转到登录页
			request.setCharacterEncoding("GBK");
			String name = (String)session.getAttribute("name");
			if(name == null || !name.equals("admin")){
				response.sendRedirect("login.jsp");
			}
		%>
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
