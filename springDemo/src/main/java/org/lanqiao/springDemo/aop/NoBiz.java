package org.lanqiao.springDemo.aop;

import org.springframework.stereotype.Service;

@Service
public class NoBiz implements SomeBiz {
  public void addBiz() {
    System.out.println("NoBiz------新增数据的业务逻辑");

  }

  public void other() {
    System.out.println("NoBiz---------其他方法");

  }
}
