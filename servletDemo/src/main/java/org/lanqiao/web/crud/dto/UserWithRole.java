package org.lanqiao.web.crud.dto;

public class UserWithRole extends org.lanqiao.web.crud.entity.User{
  private org.lanqiao.web.crud.entity.Role role;

  public org.lanqiao.web.crud.entity.Role getRole() {
    return role;
  }

  public void setRole(org.lanqiao.web.crud.entity.Role role) {
    this.role = role;
  }
}
