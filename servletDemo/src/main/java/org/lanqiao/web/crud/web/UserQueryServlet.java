package org.lanqiao.web.crud.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.lanqiao.web.crud.dao.UserDAO;
import org.lanqiao.web.crud.entity.User;
import org.lanqiao.web.crud.queryModel.UserQuery;
import org.lanqiao.web.dao.UserDao;
import org.lanqiao.web.util.Requests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class UserQueryServlet
 */
@WebServlet("/UserQuery")
public class UserQueryServlet extends HttpServlet {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UserQueryServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    UserQuery userQuery = new UserQuery();
    try {
      BeanUtils.populate(userQuery, request.getParameterMap());
    } catch (IllegalAccessException | InvocationTargetException e) {
      logger.error("请求参数转查询对象时出错", e);
      throw new RuntimeException(e);
    }
    
    int page = Requests.getInt(request, "page", 1);
    int limit = Requests.getInt(request, "limit", 10);
    
    List<User> userList = UserDAO.me.findBy(userQuery, page, limit);

    // userList转json
    //  写到客户端
    response.setContentType("application/json;charset=utf-8");
    Map<String, Object> jsonMap = new HashMap<>();
    jsonMap.put("code", 0);
    jsonMap.put("msg", "");
    jsonMap.put("count", UserDAO.me.count(userQuery));
    jsonMap.put("data", userList);
    // JSON.toJSONString:将对象序列化为JSON字符串
    // JSON.parse(String):将JSON字符串反序列化为Java对象
    String json = JSON.toJSONString(jsonMap);
    response.getWriter().write(json);
    response.flushBuffer();

  }

}
