<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="url" required="true"%>
<%@ attribute name="pageNum" type="java.lang.Integer" %>
<%@ attribute name="pageCount" required="true" type="java.lang.Integer"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
	<%if(pageNum==null){
	    pageNum=1;
	} %>

<!-- 分页显示逻辑 -->
	<a href="<%=url %>?pageNumber=1">首页</a>
	<%if(pageNum>1){ %>
		<a href="<%=url %>?pageNumber=<%=pageNum-1%>">
			<img src="<c:url value="/imgs/sy.jpg"></c:url>">
		</a>
	<%} %>
	<a href="javascript:void()"><%=pageNum %></a>
	<%if(pageNum<pageCount) {%>
	<a href="<%=url %>?pageNumber=<%=pageNum+1%>">下一页</a>
	<%} %>
	
	<a href="<%=url %>?pageNumber=<%=pageCount%>">尾页</a>
	
	