<%
	//�ж��û��Ƿ��Թ���Ա��ݷ��ʱ�ҳ�棬�粻������ת����¼ҳ
	request.setCharacterEncoding("GBK");
	String name = (String)session.getAttribute("name");
	if(name == null){
		response.sendRedirect("login.jsp");
	}
%>
