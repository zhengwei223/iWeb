<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String username = request.getParameter("username");
    String pwd = request.getParameter("password");
    
    //构造cookie
    if(request.getParameter("remember")!=null){
        Cookie cookie = new Cookie("un_cookie",username);
        response.addCookie(cookie);//浏览器接收到信息后,会将内容保存在本地文件中
    }
    
    //根据用户不同,转发到不同的组件
    if(username.equals("admin")&&pwd.equals("123456")){
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }else{
        request.getRequestDispatcher("normal.jsp").forward(request, response);
    }
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>