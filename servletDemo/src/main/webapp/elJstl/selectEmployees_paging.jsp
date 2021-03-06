<%@page import="org.lanqiao.sql.ijdbc.impl.JdbcOperationFacadeImpl"%>
<%@page import="org.lanqiao.sql.ijdbc.impl.DataSourceType"%>
<%@page import="org.lanqiao.sql.ijdbc.JdbcOperationFacade"%>
<%@page import="org.lanqiao.web.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>带分页功能的员工数据查询</title>
</head>
<body>
	<%
	JdbcOperationFacade operation=JdbcOperationFacadeImpl.of(DataSourceType.SIMPLE);
	int pageSize = 5;//每页最多行数
	int pageNumber=1;//页码
	if(request.getParameter("pageNumber")!=null){
	    pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
	}
	String innerSql = "select * from t_employee t1 order by id desc";
	// oracle
	/* String sql = "select * from "+
	        "(select t.*,rownum rn from "+
	                "("+innerSql+") t "+
	         "where rownum <=?)  "+
	 "where rn>?"; 
  List<Employee> emps = operation.queryForList(sql,Employee.class,pageNumber*pageSize,(pageNumber-1)*pageSize);
	 */
	 int rowCount = operation.queryForInt("select count(*) from ("+innerSql+") t2");//总行数
	int pageCount = rowCount%pageSize==0?(rowCount/pageSize):(rowCount/pageSize+1);//页数	
	 
	 // mysql 
	 String sql = "select * from ("+innerSql+") t2 limit ?,?";
	 List<Employee> emps = operation.queryForList(sql,Employee.class,pageNumber,pageSize);
	pageContext.setAttribute("emps", emps);
	pageContext.setAttribute("pageCount", pageCount);
	pageContext.setAttribute("pageNumber", pageNumber);
	%>
	
	<c:if test="${emps.size() gt 0 }">
	<table border="1">
		<caption>员工信息</caption>
		<tr>
			<th>职位ID</th>
			<th>firstName</th>
			<th>lastName</th>
			<th>工资</th>
		</tr>
		<c:forEach items="${emps }" var="emp" varStatus="status">
		<tr <c:if test="${status.index%2==0 }">style="background-color: blue;"</c:if>>
			<td> ${emp.id } </td>
			<td>${emp.firstName }</td>
			<td>${emp.lastName }</td>
			<td>${emp.salary }</td>
		</tr>
		</c:forEach>
		
	</table>
	</c:if>
	<c:if test="${emps.size() le 0 }">
	没有找到相关的数据!
	</c:if>
	
	<!-- 分页显示逻辑 -->
	<a href="selectt_employee.jsp?pageNumber=1">首页</a>
	<c:if test="${pageNumber>1 }">
		<a href="selectt_employee.jsp?pageNumber=${pageNumber-1 }">上一页</a>
	</c:if>
	<a href="javascript:void()">${pageNumber }</a>
	<c:if test="${pageNumber<pageCount }">
	<a href="selectt_employee.jsp?pageNumber=${pageNumber+1 }">下一页</a>
	</c:if>
	<a href="selectt_employee.jsp?pageNumber=${pageCount }">尾页</a>
</body>
</html>