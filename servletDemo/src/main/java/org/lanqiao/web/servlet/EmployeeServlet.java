package org.lanqiao.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lanqiao.sql.ijdbc.JdbcOperationFacade;
import org.lanqiao.sql.ijdbc.impl.DataSourceType;
import org.lanqiao.web.model.Employee;

@WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //1.接收参数
    //2.封装对象
    //3.调用业务bean
    //4.共享数据-->转发

    JdbcOperationFacade operation = JdbcOperationFacade.of(DataSourceType.C3P0);
    int pageSize = 10;// 每页最多行数
    int pageNumber = 1;// 页码
    if (request.getParameter("pageNumber") != null) {
      pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
    }
    String innerSql = "select * from t_employee  order by id desc";
    String sql = "select * from " + "(select t.*,rownum rn from " + "("
        + innerSql + ") t " + "where rownum <=?)  " + "where rn>?";
    int rowCount;
    response.setContentType("text/html; charset=UTF-8");
    // 总行数
    rowCount = operation.queryForInt("select count(*) from (" + innerSql
        + ")");
    int pageCount = rowCount % pageSize == 0 ? (rowCount / pageSize)
        : (rowCount / pageSize + 1);// 页数
    //得到集合
    List<Employee> emps = operation.queryForList(sql, Employee.class,
        pageNumber * pageSize, (pageNumber - 1) * pageSize);
    //共享给下一个组件,在下一个组件中可以getAttribute("emps"),或者用el表达式 ${requestScope.emps}
    request.setAttribute("emps", emps);
    request.setAttribute("pageNumber", pageNumber);
    request.setAttribute("pageCount", pageCount);
    request.getRequestDispatcher("/pages/Employee/list.jsp").forward(request,
        response);

  }

}
