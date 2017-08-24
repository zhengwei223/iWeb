package org.lanqiao.web.dao;

import static org.assertj.core.api.Assertions.*;


import org.junit.Test;
import org.lanqiao.web.model.User;

public class UserDaoTest {
    private UserDao dao = new UserDao();

    @Test
    public void testFindByUser()  {
        User _user = new User("zhangsan", "123456");
        User user = dao.findByUser(_user);
//        System.out.println(user.getId());
        assertThat(user.getId()).isNotNull();
    }

}
