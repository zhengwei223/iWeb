<%@tag import="java.text.SimpleDateFormat"%>
<%@tag import="java.util.Date"%>
<%@tag import="java.text.DateFormat"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<!-- 声明当前的标签的属性及对属性的规定,在随后的代码中可直接使用属性名来作为即将传入的属性值 -->
<%@ attribute name="format" required="true"  %>
<!-- 输出当前的时间 -->
<%
//DateFormat format = DateFormat.getDateInstance(DateFormat.LONG);
SimpleDateFormat _format = new SimpleDateFormat(format);
out.println(_format.format(new Date()));
%>
