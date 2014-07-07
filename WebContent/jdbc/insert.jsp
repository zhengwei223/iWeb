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
		Statement stmt = null;
		int dID = 300;//部门编号
		String dName = "Development";//部门名称
		int mID = 103;//部门经理编号
		int lID = 1700;//部门所在地编号
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
			//4、拼接并执行SQL语句
			StringBuffer sql = new StringBuffer(
					"INSERT INTO departments VALUES (");
			sql.append( "DEPARTMENTS_SEQ.nextval,'");
			sql.append(dName + "',");
			sql.append(mID + ",");
			sql.append(lID + ")");
			System.out.println("执行的SQL为:" + sql);
			int b = stmt.executeUpdate(sql.toString());
			out.print("stmt.execute(sql)返回值：" + b + "<br>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//5、关闭Statement和数据库连接
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