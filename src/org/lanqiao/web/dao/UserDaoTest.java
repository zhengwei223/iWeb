package org.lanqiao.web.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;
import org.lanqiao.web.model.User;

public class UserDaoTest {
    private UserDao dao = new UserDao();

    @Test
    public void testFindByUser() throws SQLException {
        // fail("Not yet implemented");
        // String s = null;
        // assertNotNull(s);
        User _user = new User("admin", "admin123");
        User user = dao.findByUser(_user);
        assertNotNull(user.getId());
    }

}
