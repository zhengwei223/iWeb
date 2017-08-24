package org.lanqiao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.sql.ijdbc.JdbcOperationFacade;
import org.lanqiao.sql.ijdbc.impl.DataSourceType;

@WebServlet("/servlet/CompleteUsername")
public class CompleteUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    //查询类似的username
	    String sql = "select last_name from t_employee where last_name like '"+username+"%'";
	    JdbcOperationFacade operation = JdbcOperationFacade.of(DataSourceType.C3P0);
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
