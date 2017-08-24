package org.lanqiao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/CheckUsername")
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		//System.out.println(username);
		PrintWriter out = response.getWriter();
		String json;
		if (username.equals("admin")) {
		    json = "{\"result\":false}";
        }else {
            json = "{\"result\":true}";
        }
		
		//["zhangsan","lisi","wangwu","zhaoliu"]
        out.write(json);
		out.flush();
	}

}
