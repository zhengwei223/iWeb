<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
	<head>
		<title>显示结果页面</title>
	</head>
	<body>
		<%
			//判断用户是否以普通用户或管理员身份访问本页面，如不是则跳转到登录页
			request.setCharacterEncoding("GBK");
			String name = (String)session.getAttribute("name");
			if(name == null){
				response.sendRedirect("login.jsp");
			}
		%>
		您好，这是普通用户内容页，您是：<%=name%>，欢迎进入本页面！		
    	<ul>
        	<li><a href="#">图书信息</a></li>
            <li><a href="#">购物车</a></li>
            <li><a href="#">订单管理</a></li>
            <li><a href="#">退出</a></li>
        </ul>
	</body>
</html>

