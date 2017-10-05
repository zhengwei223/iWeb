package org.lanqiao.springDemo.beans;

import org.lanqiao.springDemo.applicationContext.Timing;

public class DaoAImpl2 implements DaoA {
  @Timing
  public void daoFunc1() {
    System.out.println("DaoAImpl2的daoFunc1 正在发挥作用");
  }
}
