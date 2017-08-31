package org.lanqiao.web.crud.dao.mybatis;

import org.lanqiao.web.crud.dto.RoleWithUsers;

import java.util.List;

public interface RoleMapper {

  List<RoleWithUsers> findAllWithUsers();
}
