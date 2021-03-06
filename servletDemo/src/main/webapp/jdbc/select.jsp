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
		ResultSet rs = null;
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
			//4、执行SQL语句，返回结果
			rs = stmt.executeQuery("SELECT * FROM jobs");
	%>
	<table border="1">
		<caption>人力资源系统职位信息</caption>
		<tr>
			<th>职位ID</th>
			<th>职位名称</th>
			<th>最低工资</th>
			<th>最高工资</th>
		</tr>
		<%
			//5、操作结果集:ResultSet每next一次,指针指向一个新的行,可通过getXXX方法来获得当前行的分量.
				while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("job_id")%></td><!-- 传入列名来获得分量 -->
			<td><%=rs.getString(2)%></td><!-- 传入序号来获得分量,这个序号是以1开始的 -->
			<td><%=rs.getInt("min_salary")%></td>
			<td><%=rs.getInt(4)%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
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