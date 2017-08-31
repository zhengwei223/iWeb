package org.lanqiao.web.crud.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.web.crud.dao.UserDAO;
import org.lanqiao.web.crud.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserSave
 */
@WebServlet("/User/Save")
public class UserSave extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * @see HttpServlet#HttpServlet()
   */
  public UserSave() {
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
    User user = new User();
    try {
      BeanUtils.populate(user, request.getParameterMap());
      boolean isMultipart = ServletFileUpload.isMultipartContent(request);
      if (isMultipart) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletContext servletContext = this.getServletConfig()
            .getServletContext();
        File repository = (File) servletContext
            .getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        ServletFileUpload upload = new ServletFileUpload(factory);
        //     这段代码自动将上传的文件存储在了临时目录，下面这句我们直接得到文件列表
        List<FileItem> items = upload.parseRequest(request);
        Iterator<FileItem> iter = items.iterator();
//        上传了多少文件，这里迭代多少次
        while (iter.hasNext()) {
            FileItem item = iter.next();
            InputStream is = item.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            user.setHead(buffer);
            break;
        }
      }
    } catch (IllegalAccessException | InvocationTargetException e) {
      logger.error("请求参数转查询对象时出错", e);
      throw new RuntimeException(e);
    } catch (FileUploadException e) {
      logger.error("文件上传错误", e);
      throw new RuntimeException(e);
    }
    if(user.getId()==null)
      UserDAO.me.save(user);
    else {
      UserDAO.me.update(user);
    }
  }

}
