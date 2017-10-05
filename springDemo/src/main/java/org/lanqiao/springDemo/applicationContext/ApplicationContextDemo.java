package org.lanqiao.springDemo.applicationContext;

import org.lanqiao.springDemo.beans.ServiceA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class ApplicationContextDemo {
  public static void main(String[] args) throws IOException {
    /*ApplicationContext是BeanFactory的替代品，拥有更多更高级的特性*/
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

    // final String hi = applicationContext.getMessage("hi", null, Locale.CHINA);
    // System.out.println(hi);


    Resource rsc = applicationContext.getResource("classpath:beans.xml");
    BufferedReader reader = new BufferedReader(new InputStreamReader(rsc.getInputStream()));
    while (true){
      String s = reader.readLine();
      if (s==null)
        break;
      else
        System.out.println(s);
    }
    System.out.println("============");
    ServiceA serviceA = (ServiceA) applicationContext.getBean("serviceA");
    serviceA.func1();

   //  DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
   //  System.out.println(dataSource);
   //
   // String hi_zh =  applicationContext.getMessage("hi",null,new Locale("zh","CN"));
   //  System.out.println(hi_zh);
  }
}
