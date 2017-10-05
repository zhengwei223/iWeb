package org.lanqiao.springDemo.applicationContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/*bean实例化之前，可修改元数据*/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    BeanDefinition bd = beanFactory.getBeanDefinition("");
  }
}


