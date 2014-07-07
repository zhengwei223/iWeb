<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/iweb" prefix="iweb"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>带分页功能的员工数据查询</title>
</head>
<body>
	
	<c:if test="${requestScope.emps.size() gt 0 }">
		<table border="1">
			<caption>员工信息</caption>
			<tr>
				<th>职位ID</th>
				<th>firstName</th>
				<th>lastName</th>
				<th>工资</th>
			</tr>
			<c:forEach items="${requestScope.emps }" var="emp" varStatus="status">
			<tr <c:if test="${status.index%2==0 }">style="background-color: blue;"</c:if>>
				<td>${emp.id } </td>
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

<iweb:page pageCount="${pageCount }" url="selectEmployees_paging.jsp" pageNum="${pageNumber}"></iweb:page>	
</body>
</html>