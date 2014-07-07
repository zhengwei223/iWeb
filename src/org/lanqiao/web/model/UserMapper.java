package org.lanqiao.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javacommon.ijdbc.RowMapper;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs) throws SQLException {
        return new User(rs.getString("id"),rs.getString("name"), rs.getString("password"));
    }

}
