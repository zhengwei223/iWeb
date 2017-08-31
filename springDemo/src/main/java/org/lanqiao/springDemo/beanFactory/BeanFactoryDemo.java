package org.lanqiao.springDemo.beanFactory;

import org.lanqiao.springDemo.beans.ServiceA;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryDemo {

  public static void main(String[] args) {
    //1.实例化容器，我们要向容器提供一份清单
    //构造器需要一个Resource，最常用的Resource是ClassPathResource，基于classpath路径的资源
    BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));

  //  2.因为有清单存在，清单中所列的所有对象，都可以从容器中获得

    ServiceA serviceA = (ServiceA) beanFactory.getBean("serviceA");

    serviceA.func1();

    System.out.println(serviceA);

    ServiceA serviceB = (ServiceA) beanFactory.getBean("serviceA");
    System.out.println(serviceB);

  }
}
