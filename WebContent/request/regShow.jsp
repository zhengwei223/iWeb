<%@ page language="java" contentType="text/html; charset=GBK"%>
<%
	request.setCharacterEncoding("GBK");
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	String gen = request.getParameter("gen");
	String[] likes = request.getParameterValues("like");

	String encoding = request.getCharacterEncoding();
	int len = request.getContentLength();
	String method = request.getMethod();
	String protocol = request.getProtocol();
	String queryStr = request.getQueryString();
	String requestURI = request.getRequestURI();
	String remoteAddr = request.getRemoteAddr();
	String remoteHost = request.getRemoteHost();
	String realPath = request.getRealPath("/");
	String serverName = request.getServerName();
	int serverPort = request.getServerPort();
%>
<html>
	<head>
		<title>��Աע����Ϣ</title>
	</head>
	<body>
		<div align="center">�������ע����Ϣ
			<table border="0" align="center">
				<tr>
					<td width="100" height="20">�û�����</td>
					<td><%=name%></td>
				</tr>
				<tr>
					<td>���룺</td>
					<td><%=pwd%></td>
				</tr>
				<tr>
					<td>�������䣺</td>
					<td><%=email%></td>
				</tr>
				<tr>
					<td>�Ա�</td>
					<td><%=gen%></td>
				</tr>
				<tr>
					<td>���ã�</td>
					<td >
					<%
						if (likes != null) {
							for (int i = 0; i < likes.length; i++) {
								out.print(likes[i]+"&nbsp;");
							}
						}
					%>
					</td>
				</tr>
			</table>
		</div>
		request.getCharacterEncoding():<%=encoding%><br>
		request.getContentLength():<%=len%><br>
		request.getMethod():<%=method%><br>
		request.getProtocol():<%=protocol%><br>
		request.getQueryString():<%=queryStr%><br>
		request.getRequestURI():<%=requestURI%><br>
		request.getRemoteAddr():<%=remoteAddr%><br>
		request.getRemoteHost():<%=remoteHost%><br>
		request.getServerName():<%=serverName%><br>
		request.getRealPath("/"):<%=realPath%><br>
		request.getServerPort():<%=serverPort%><br>
	</body>
</html>
