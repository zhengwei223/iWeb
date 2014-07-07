package org.lanqiao.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/Hello")
// http://server:port/webAppName(contextPath)/servlet/Hello
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // 没有/的时候,怎么构造路径?  contextPath+currentPath+specPath
        // 有/的时候,怎么构造路径?    serverPath+specPath
        //request.getContextPath()==/iWeb
        String path = request.getContextPath()+"/ijdbc/selectEmployees_paging.jsp";
        response.sendRedirect(path);
     // 没有/,怎么构造路径?       contextPath+currentPath+specPath
        // 有/的时候,怎么构造路径?    contextPath+specPath
//        String path = "/ijdbc/selectEmployees_paging.jsp";
//        request.getRequestDispatcher(path).forward(request, response);
        // doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println("<html>" + "<head>" + "<title>运用后端技术处理业务逻辑</title>"
                + "</head>" + "<body>" +

                "今天是学习JSP的第一天！ <br>" +

                "明天是" + new Date() + "<br>" +

                "后天是学习JSP的第三天！" + "</body>" + "</html>");

        pw.close();
    }

}
