<%
	//判断用户是否以管理员身份访问本页面，如不是则跳转到登录页
	request.setCharacterEncoding("GBK");
	String name = (String)session.getAttribute("name");
	if(name == null){
		response.sendRedirect("login.jsp");
	}
%>
