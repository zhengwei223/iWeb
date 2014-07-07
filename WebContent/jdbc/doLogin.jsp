<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn = null;
	//预处理命令,1.参数化sql,不用拼接 2.有效防止sql注入 3.提高解析效率
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//从登录表单获取用户名和密码
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name").trim();
		String pwd = request.getParameter("pwd").trim();
		//1、加载驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//2、创建JDBC连接
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr123");
			//3、创建PreparedStatement对象,sql是参数化的
			String sql = "SELECT * FROM t_user WHERE name=? and password=?";
			pstmt = conn.prepareStatement(sql);
			//4、为preparedStatement的sql提供参数,执行SQL语句，返回结果
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			//5、操作结果集
			if (rs.next()) {
				//登录信息存入session
				session.setAttribute("name", name);
				session.setMaxInactiveInterval(10 * 60);
				out.print("登录成功，欢迎您！");
			} else {
				System.out.println("登录失败！");
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6、关闭连接
			try {
				if (null != pstmt) {
					pstmt.close();
				}
				if (null != conn) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>