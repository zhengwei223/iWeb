package org.lanqiao.springDemo.applicationContext;

import org.lanqiao.springDemo.beans.ServiceA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextDemo {
  public static void main(String[] args) {
    /*ApplicationContext是BeanFactory的替代品，拥有更多更高级的特性*/
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    ServiceA serviceA = (ServiceA) applicationContext.getBean("serviceA");
    serviceA.func1();
  }
}
