<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Cookie[] cookies = request.getCookies();
    String username="";//cookie中的username
    //如果本地保存了cookie
    if(cookies!=null){
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("un_cookie")){
                username = cookie.getValue();
            }
            
        }
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ctrl.jsp">
		username:<input type="text" name="username" value="<%=username %>"><br>
		password:<input type="password" name="password"><br>
		remember me:<input type="checkbox" name="remember"><br>
		<input type="submit" value="登录">
	</form>
</body>
</html>