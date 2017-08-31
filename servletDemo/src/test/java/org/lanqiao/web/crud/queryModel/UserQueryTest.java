package org.lanqiao.web.crud.queryModel;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class UserQueryTest {

  @Test
  public void testToString() {
    UserQuery query = new UserQuery();
    query.setAgeScope(2);
    query.setSalaryScope(3);
    
    Assertions.assertThat(query.toString().trim()).isEqualTo("where  age between 20 and 40 and  salary between 5000 and 8000".trim());
  }
  
  @Test
  public void testToString1() {
    UserQuery query = new UserQuery();
//    query.setAgeScope(2);
    query.setSalaryScope(3);
    
    Assertions.assertThat(query.toString().trim().replaceAll("\\s+", " ")).isEqualTo("where salary between 5000 and 8000");
  }

}
