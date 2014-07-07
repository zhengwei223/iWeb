<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>可能被注入的登陆处理逻辑</title>
</head>
<body>
	<%
		Connection conn = null;
		Statement stmt = null;
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
			//3、创建Statement对象
			stmt = conn.createStatement();
			
			String sql = "select * from t_user where name='"+name+"' and password='"+pwd+"'";
			System.out.println("执行的SQL为:" + sql );
			//4、执行SQL语句，返回结果
			rs = stmt.executeQuery(sql);
			//5、操作结果集
			if (rs.next()) {//如果有结果集,说明数据库中有对应的数据,登陆成功
				//登录信息存入session
				session.setAttribute("name", name);
				session.setMaxInactiveInterval(10 * 60);
				out.print("登录成功，欢迎您！");
			} else {
				System.out.println("登录失败！");
				response.sendRedirect("login.jsp");//登录失败,被打回
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//6、关闭连接
			try {
				if (null != stmt) {
					stmt.close();
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