<%@page import="org.lanqiao.web.model.EmployeeMapper"%>
<%@page import="org.lanqiao.web.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="javacommon.ijdbc.impl.JdbcUtils"%>
<%@page import="javacommon.ijdbc.IJdbcOperation"%>
<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		IJdbcOperation operation=JdbcUtils.getInstance();
		List<Employee> emps = operation.queryForList("SELECT * FROM employees",new EmployeeMapper());
	%>
	<table border="1">
		<caption>人力资源系统职位信息</caption>
		<tr>
			<th>职位ID</th>
			<th>firstName</th>
			<th>lastName</th>
			<th>工资</th>
		</tr>
		<%
			//5、操作结果集:ResultSet每next一次,指针指向一个新的行,可通过getXXX方法来获得当前行的分量.
				for(Employee emp:emps){
		%>
		<tr>
			<td><%=emp.getId()%></td><!-- 传入列名来获得分量 -->
			<td><%=emp.getFirstName()%></td><!-- 传入序号来获得分量,这个序号是以1开始的 -->
			<td><%=emp.getLastName()%></td>
			<td><%=emp.getSalary()%></td>
		</tr>
		<%
			}
		%>
	</table>
	
</body>
</html>