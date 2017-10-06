package org.lanqiao.springDemo.applicationContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

/*bean实例化之前，可修改元数据*/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    String[] beanNames = beanFactory.getBeanDefinitionNames();
    for (String beanName:beanNames ) {
      AbstractBeanDefinition beanDef = (AbstractBeanDefinition) beanFactory.getBeanDefinition(beanName);
      Class<?> configClass = null;
      final Timing timing = configClass.getAnnotation(Timing.class);
      Class<?> enhancedClass = null;
      beanDef.setBeanClass(enhancedClass);
    }
  }
}


