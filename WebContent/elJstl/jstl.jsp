<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${param.age }

<%--考虑空指针异常
int age = Integer.parseInt(request.getParameter("age"));
if(age>40)
	out.print("中年");
else
	out.print("青年");
--%>

<h3>JSTL配合EL表达式将大大简化代码</h3>
<c:if test="${param.age>50 }">
	中年
</c:if>
<c:if test="${param.age<50 }">
	青年
</c:if>

<h3>通用标签</h3>
<c:set var="example" value="${100+1}" scope="session"  />	

<c:out value="${example}" default="1000" />==${example}

<c:set var="example" value="《》&&&<>"  scope="session"  />	
<c:out value="------------《》&&&<>" escapeXml="false" />

<c:remove var="example" scope="session"/>

<h3>迭代标签</h3>
<%
String[] strArr = new String[]{"a","b","c","d"} ;
request.setAttribute("list", strArr);
%>
<table border="1">
	<tr style="">
		<td>内容1</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${list }" var="item" varStatus="status">
	<tr <c:if test="${status.index%2==0 }">style="background-color: red;"</c:if> >
		<td>${item } </td>
		<td>删除 </td>
	</tr>
	</c:forEach>
</table>
</body>
</html>