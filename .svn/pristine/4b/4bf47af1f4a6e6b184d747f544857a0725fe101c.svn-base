<%@page import="org.lanqiao.web.model.EmployeeMapper"%>
<%@page import="org.lanqiao.web.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="javacommon.ijdbc.impl.JdbcUtils"%>
<%@page import="javacommon.ijdbc.IJdbcOperation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setAttribute("username", "zhangsan");
session.setAttribute("username", "lisi");
application.setAttribute("username", "wangwu");
pageContext.setAttribute("username", "zhaoliu");

request.setCharacterEncoding("utf-8");

IJdbcOperation operation=JdbcUtils.getInstance();
List<Employee> emps = operation.queryForList("SELECT * FROM employees where rownum < 10",new EmployeeMapper());

pageContext.setAttribute("emps", emps);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el表达式示例</title>
</head>
<body>
<h1>访问四大作用范围内变量:request、session、application、pageContext </h1>
${requestScope.username }===<%=request.getAttribute("username") %><br>
${sessionScope.username}===<%=session.getAttribute("username") %>  <br>
${applicationScope.username }===<%=application.getAttribute("username")   %><br>
${pageScope.username}===<%=pageContext.getAttribute("username") %>  <br>

${username }<!-- 从小范围开始搜索名为username的变量 -->

<h1>获得请求参数,类似request.getParameter(...)</h1>
<%=request.getParameter("kw") %>  =======  ${param.kw }

<h1>访问对象的属性</h1>
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
				    pageContext.setAttribute("emp", emp);
		%>
		<tr>
			<td><%-- <%=emp.getId()%> --%> ${emp.id } </td><!-- 传入列名来获得分量 -->
			<td><%-- <%=emp.getFirstName()%> --%> ${emp.firstName }</td><!-- 传入序号来获得分量,这个序号是以1开始的 -->
			<td><%-- <%=emp.getLastName()%> --%> ${emp.lastName }</td>
			<td><%-- <%=emp.getSalary()%> --%> ${emp.salary }</td>
		</tr>
		<%
			}
		%>
	</table>
	
	<h1>访问List</h1>
	${emps[0] }  ===<%=((List)pageContext.getAttribute("emps")).get(0) %>  <br>
	${emps[1].lastName }=== <%=((List<Employee>)pageContext.getAttribute("emps")).get(0).getLastName() %>
	
	<!-- a.getB().getC().getD()  a.b.c.d -->
</body>
</html>