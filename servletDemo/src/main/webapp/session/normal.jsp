<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<html>
	<head>
		<title>��ʾ���ҳ��</title>
	</head>
	<body>
		<%
			//�ж��û��Ƿ�����ͨ�û������Ա��ݷ��ʱ�ҳ�棬�粻������ת����¼ҳ
			request.setCharacterEncoding("GBK");
			String name = (String)session.getAttribute("name");
			if(name == null){
				response.sendRedirect("login.jsp");
			}
		%>
		���ã�������ͨ�û�����ҳ�����ǣ�<%=name%>����ӭ���뱾ҳ�棡		
    	<ul>
        	<li><a href="#">ͼ����Ϣ</a></li>
            <li><a href="#">���ﳵ</a></li>
            <li><a href="#">��������</a></li>
            <li><a href="#">�˳�</a></li>
        </ul>
	</body>
</html>

