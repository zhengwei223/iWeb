<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
	<head>
		<title>�����̨ҳ��</title>
	</head>
	<body>
		<%
			//�ж��û��Ƿ��Թ���Ա��ݷ��ʱ�ҳ�棬�粻������ת����¼ҳ
			request.setCharacterEncoding("GBK");
			String name = (String)session.getAttribute("name");
			if(name == null || !name.equals("admin")){
				response.sendRedirect("login.jsp");
			}
		%>
		���ã����ǹ���Ա��<%=name%>����ӭ��������̨��	
    	<ul>
        	<li><a href="#">���ͼ��</a></li>
            <li><a href="#">�޸�ͼ��</a></li>
            <li><a href="#">ͼ���ϼ�</a></li>
            <li><a href="#">ͼ���¼�</a></li>
            <li><a href="#">�˳�</a></li>
        </ul>
	</body>
</html>
