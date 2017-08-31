package org.lanqiao.web.crud.dao.mybatis;

import org.lanqiao.web.crud.dto.UserWithRole;
import org.apache.ibatis.session.RowBounds;
import org.lanqiao.web.crud.entity.User;

import java.util.List;

public interface UserMapper {


  public List<User> findAll(RowBounds rowBounds);

  public void save(User user);

  //
  // public int count(UserQuery userQuery) {
  //   String sql = "select count(id) from crud_user "+userQuery.toString();
  //   return op.queryForInt(sql);
  // }
  //
  // public List<User> findBy(User user,int page,int limit){
  //   String query = "select id ,  name ,  age ,email ,birthday ,salary ,is_active as active,role_id"
  //       + " from crud_user "
  //      + user.toString()
  //       + " limit ?,?";
  //   return op.queryForList(query, new org.lanqiao.web.crud.entity.UserMapper(), (page-1)*limit, limit);
  // }
  //
  // public void update(User user) {
  //   // TODO Auto-generated method stub
  //   String sql = "update crud_user set name=?,email=? where id=?";
  //   op.execute(sql, user.getName(),user.getEmail(),user.getId());
  // }

  public List<UserWithRole> findAllWithRole(RowBounds rowBounds);
}
