package org.lanqiao.web.dao;

import org.lanqiao.sql.ijdbc.JdbcOperationFacade;
import org.lanqiao.sql.ijdbc.impl.DataSourceType;
import org.lanqiao.web.model.User;

public class UserDao {

  JdbcOperationFacade operation = JdbcOperationFacade.of(DataSourceType.SIMPLE);

  public User findByUser(User _user)  {

    String sql = "select * from t_user where username=? and password=?";
    return operation.queryForUniqueBean(sql, User.class, _user.getUsername(),
        _user.getPassword());
  }

}
