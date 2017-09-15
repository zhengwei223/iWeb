package org.lanqiao.springDemo.aop;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.junit.Assert.*;

@ContextConfiguration("classpath:aop3.xml")
public class NoBizTest extends AbstractJUnit4SpringContextTests{
  @Autowired
  private NoBiz noBiz;
  @Test
  public void addBiz() throws Exception {
    noBiz.addBiz();
  }

  @Test
  public void other() throws Exception {
  }

}