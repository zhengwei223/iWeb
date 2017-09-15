package org.lanqiao.springDemo.aop;

public class SomeBizImpl implements SomeBiz{
  public void addBiz(){
    System.out.println("新增数据的业务逻辑");
  }
  public void other(){
    System.out.println("其他方法");
  }
}
