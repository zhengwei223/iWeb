<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%
	request.setCharacterEncoding("GBK");
	String name = request.getParameter("name").trim();
	String pwd = request.getParameter("pwd").trim();
	//��������Ϊname��session���ԣ�ֵΪ��������Ļ�ȡֵ
	session.setAttribute("name", name);
	//����ֹͣ������session�������Чʱ��Ϊ10����
	session.setMaxInactiveInterval(10*60);
	if(name.equals("admin")&& pwd.equals("admin")){
		//����Ա��¼�ɹ�������admin.jspҳ��
		response.sendRedirect("admin.jsp");
	}else{
		//�ǹ���Ա����normal.jspҳ��
		response.sendRedirect("normal.jsp");
	}
%>

