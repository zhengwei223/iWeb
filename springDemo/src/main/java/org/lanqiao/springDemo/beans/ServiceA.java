package org.lanqiao.springDemo.beans;

import org.lanqiao.springDemo.applicationContext.Timing;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.TimeUnit;

public class ServiceA implements InitializingBean, DisposableBean {

  private DaoA daoA;

  public  void setDaoA(DaoA daoA) {
    this.daoA = daoA;
  }

  public DaoA getDaoA() {
    return daoA;
  }

  @Timing
  public void func1() {
    System.out.println("func1 正在发挥作用");
    try {
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      // e.printStackTrace();
    }
    daoA.daoFunc1();
  }

  public void destroy() throws Exception {
    System.out.println("要挂了………………");
  }

  // spring 给bean设置了所有属性后，将回调此方法
  public void afterPropertiesSet() throws Exception {
    System.out.println("我的所有属性都已设置完成,dao=="+daoA);
  }
}
