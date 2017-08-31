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
		//用纯Java驱动方式连接数据库
		Connection conn = null;
		//1、加载驱动
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//2、创建JDBC连接
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "hr", "hr123");
			System.out.println("建立连接成功！");
			//*3.statement或者preparedStatement对象,
			//*4.增删改查
			//*5.如果是查询,要处理结果集ResultSet
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//3、关闭连接,因为连接是稀缺的资源,获取连接是一个消耗很大的动作,所以使用完成之后务必关闭
			try {
				if (null != conn) {
					conn.close();
					System.out.println("关闭连接成功！");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>