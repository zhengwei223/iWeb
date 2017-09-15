package org.lanqiao.springDemo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:aop.xml")
public class SomeBizImplTest extends AbstractJUnit4SpringContextTests {
  @Autowired
  private SomeBiz someBizProxy;

  @org.junit.Test
  public void addBizUsingInterfaceProxy() throws Exception {
    someBizProxy.addBiz();
  }

  @Autowired
  private SomeBiz someBiz;

  @org.junit.Test
  public void addBizUsingBean() throws Exception {
    someBiz.addBiz();
  }

  @org.junit.Test
  public void other() throws Exception {
  }

}