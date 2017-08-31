package org.lanqiao.web.crud.dto;

import org.lanqiao.web.crud.entity.User;

import java.util.List;

public class RoleWithUsers extends org.lanqiao.web.crud.entity.Role{
  private List<User> users;

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }


}
