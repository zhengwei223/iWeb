package org.lanqiao.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javacommon.ijdbc.IJdbcOperation;
import javacommon.ijdbc.impl.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.web.model.Employee;
import org.lanqiao.web.model.EmployeeMapper;

@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        //1.接收参数
        //2.封装对象
        //3.调用业务bean
        //4.共享数据-->转发
        
        
        IJdbcOperation operation = JdbcUtils.getInstance();
        int pageSize = 10;// 每页最多行数
        int pageNumber = 1;// 页码
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }
        String innerSql = "select * from employees  order by employee_id desc";
        String sql = "select * from " + "(select t.*,rownum rn from " + "("
                + innerSql + ") t " + "where rownum <=?)  " + "where rn>?";
        int rowCount;
        response.setContentType("text/html; charset=UTF-8");
        try {
            // 总行数
            rowCount = operation.queryForInt("select count(*) from ("
                    + innerSql + ")");
            int pageCount = rowCount % pageSize == 0 ? (rowCount / pageSize)
                    : (rowCount / pageSize + 1);// 页数
            //得到集合
            List<Employee> emps = operation.queryForList(sql,
                    new EmployeeMapper(), pageNumber * pageSize,
                    (pageNumber - 1) * pageSize);
            //共享给下一个组件,在下一个组件中可以getAttribute("emps"),或者用el表达式 ${requestScope.emps}
            request.setAttribute("emps", emps);
            request.getRequestDispatcher("/pages/Employee/list.jsp").forward(request, response);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
