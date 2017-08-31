package org.lanqiao.web.crud.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.lanqiao.sql.ijdbc.RowMapper;

public class UserMapper implements RowMapper<User>{

  @Override
  public User mapRow(ResultSet rs) throws SQLException {
    User user = new User();
    String active = rs.getString("is_active");
    if (active==null||active.equals("0")) {
      user.setActive(false);
    }else{
      user.setActive(true);
    }
    user.setId(rs.getInt("id"));
    user.setName(rs.getString("name"));
    user.setAge(rs.getInt("age"));
    user.setBirthday(rs.getDate("birthday"));
    user.setEmail(rs.getString("email"));
    user.setSalary(rs.getDouble("salary"));
    return user;
  }

}
