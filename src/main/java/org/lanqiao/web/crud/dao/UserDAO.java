package org.lanqiao.web.crud.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.lanqiao.sql.ijdbc.JdbcOperationFacade;
import org.lanqiao.sql.ijdbc.RowMapper;
import org.lanqiao.sql.ijdbc.impl.DataSourceType;
import org.lanqiao.web.crud.entity.User;
import org.lanqiao.web.crud.entity.UserMapper;
import org.lanqiao.web.crud.queryModel.UserQuery;

import com.sun.org.apache.bcel.internal.generic.Select;

public enum UserDAO {
  me;

  JdbcOperationFacade op = JdbcOperationFacade.of(DataSourceType.SIMPLE);

  @SuppressWarnings("deprecation")
  public List<User> findAll(int page, int limit) {
    String query = "select id ,  name ,  age ,email ,birthday ,salary ,is_active as active,role_id"
        + " from crud_user limit ?,?";
    return op.queryForList(query, new UserMapper(), (page-1)*limit, limit);
  }

  public void save(User user) {
    String sql = "INSERT INTO crud_user"
        + "(name, age, email, head, head_url, birthday, salary, gmt_create, gmt_modified, is_active, role_id) "
        + "VALUES(?,?,?,? ,? ,?,?,now(),now(),?,?)";

    op.execute(sql, user.getName(), user.getAge(), user.getEmail(),
        user.getHead(), user.getHeadUrl(), user.getBirthday(),
        user.getSalary(), user.isActive(), user.getRoleId());
  }

  public int count(UserQuery userQuery) {
    String sql = "select count(id) from crud_user "+userQuery.toString();
    return op.queryForInt(sql);
  }
  
  public List<User> findBy(User user,int page,int limit){
    String query = "select id ,  name ,  age ,email ,birthday ,salary ,is_active as active,role_id"
        + " from crud_user "
       + user.toString()
        + " limit ?,?";
    return op.queryForList(query, new UserMapper(), (page-1)*limit, limit);
  }

  public void update(User user) {
    // TODO Auto-generated method stub
    String sql = "update crud_user set name=?,email=? where id=?";
    op.execute(sql, user.getName(),user.getEmail(),user.getId());
  }
  
  
}
