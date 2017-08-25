package org.lanqiao.web.crud.dao;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.lanqiao.web.crud.entity.User;

import static org.assertj.core.api.Assertions.*;

public class UserDAOTest {

  @Test
  public void testFindAll() {
    UserDAO userDAO = UserDAO.me;
    List<User> users = userDAO.findAll(2,20);
    assertThat(users).hasSize(20);

  }

  @SuppressWarnings("deprecation")
  @Test
  public void testSave() {
    for (int i = 0; i < 100; i++) {

      User user = new User();
      user.setName(RandomStringUtils.randomAlphabetic(5));
      user.setActive(false);
      user.setAge(new Random().nextInt(50));
      user.setEmail(RandomStringUtils.randomAlphabetic(5) + "@163.com");

      user.setBirthday(new Date(new java.util.Date().getTime()));
      user.setRoleId(2);
      user.setSalary(Math.random() * 5000);

      UserDAO.me.save(user);
    }
  }

}
