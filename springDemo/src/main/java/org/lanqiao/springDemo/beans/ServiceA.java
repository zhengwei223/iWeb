package org.lanqiao.springDemo.beans;

public class ServiceA {

  private DaoA daoA ;

  public void setDaoA(DaoA daoA) {
    this.daoA = daoA;
  }


  public void func1(){
    System.out.println("func1 正在发挥作用");
    daoA.daoFunc1();
  }
}
