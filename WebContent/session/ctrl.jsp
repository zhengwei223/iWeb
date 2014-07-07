<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%
	request.setCharacterEncoding("GBK");
	String name = request.getParameter("name").trim();
	String pwd = request.getParameter("pwd").trim();
	//设置名称为name的session属性，值为请求参数的获取值
	session.setAttribute("name", name);
	//设置停止操作后session对象的有效时间为10分钟
	session.setMaxInactiveInterval(10*60);
	if(name.equals("admin")&& pwd.equals("admin")){
		//管理员登录成功，进入admin.jsp页面
		response.sendRedirect("admin.jsp");
	}else{
		//非管理员访问normal.jsp页面
		response.sendRedirect("normal.jsp");
	}
%>

