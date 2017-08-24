package org.lanqiao.web.dao;

import java.sql.SQLException;

import javacommon.ijdbc.IJdbcOperation;
import javacommon.ijdbc.impl.JdbcUtils;

import org.lanqiao.web.model.User;
import org.lanqiao.web.model.UserMapper;

public class UserDao {

    IJdbcOperation operation = JdbcUtils.getInstance();
    public User findByUser(User _user) throws SQLException {
        
        String sql="select * from t_user where name=? and password=?";
        return operation.queryForUniqueBean(sql, new UserMapper(), _user.getUsername(),_user.getPassword());
    }

}
