package org.lanqiao.springDemo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:aop2.xml")
public class SomeBizImplTest2 extends AbstractJUnit4SpringContextTests {

  @Autowired
  private SomeBiz someBiz;

  @org.junit.Test
  public void addBizUsingBean() throws Exception {
    someBiz.addBiz();
  }

  @org.junit.Test
  public void other() throws Exception {
    someBiz.other();
  }

}