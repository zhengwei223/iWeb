<%@ page language="java" contentType="text/html; charset=GBK"%>
<html>
	<head>
		<title>��ʾ���ҳ��</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("GBK");
			String name = request.getParameter("name");
		%>
		���ã�������ͨ�û���<%=name%>����ӭ���뱾ҳ�棡
	</body>
</html>
