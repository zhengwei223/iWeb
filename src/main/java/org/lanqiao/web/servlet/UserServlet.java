package org.lanqiao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lanqiao.web.model.User;
import org.lanqiao.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/User")
public class UserServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServlet.class);
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 接收数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 封装对象
        User user = new User(username, password);

        // 调用业务bean
        UserService service = new UserService();
        boolean flag;
        PrintWriter out = response.getWriter();
        flag = service.validate(user);
        
        // 转发或直接输出——输出
        if (flag) {
//                out.write("ok");
            //在session中共享用户的信息
            HttpSession session=request.getSession();
            session.setAttribute("username", username);
            //不仅可转发到jsp,还可以转发到servlet
            //如果登陆成功  转发到下一个Servlet
            request.getRequestDispatcher("/Employee").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
