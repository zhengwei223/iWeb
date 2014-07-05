<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp.*"%>
<%@page import="javax.sql.DataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
BasicDataSource ds = new BasicDataSource();
String url = "jdbc:oracle:thin:@localhost:1521:XE";
String username = "hr";
String password="hr123";
String driverClassName = "oracle.jdbc.driver.OracleDriver";
ds.setUrl(url);
ds.setUsername(username);
ds.setPassword(password);
ds.setDriverClassName(driverClassName);

ds.setInitialSize(1);

Connection conn = ds.getConnection();
out.println(conn.hashCode());
conn.close();//回收

conn = ds.getConnection();
out.println(conn.hashCode());

conn.close();

%>
</body>
</html>