package org.lanqiao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javacommon.ijdbc.IJdbcOperation;
import javacommon.ijdbc.impl.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/CompleteUsername")
public class CompleteUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    //查询类似的username
	    String sql = "select last_name from employees where last_name like '"+username+"%'";
	    IJdbcOperation operation = JdbcUtils.getInstance();
	    try {
            ResultSet rs = operation.queryForResultSet(sql);
            StringBuilder sb = new StringBuilder("{\"list\":[");
            while (rs.next()) {
                String _un = rs.getString(1);
                sb.append("\"").append(_un).append("\",");
            }
            int index = sb.length()-1;
            if (sb.charAt(index)==',') {
                sb.deleteCharAt(index);
            }
            sb.append("]}");
            PrintWriter writer = response.getWriter();
            writer.write(sb.toString());
            writer.flush();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
