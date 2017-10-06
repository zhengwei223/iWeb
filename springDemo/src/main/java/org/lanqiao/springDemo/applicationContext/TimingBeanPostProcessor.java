package org.lanqiao.springDemo.applicationContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;
/**
 * BeanPostProcessor案例
 * */
public class TimingBeanPostProcessor implements BeanPostProcessor {

  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Class beanClass = bean.getClass();
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(beanClass);
    enhancer.setInterceptDuringConstruction(false);
    enhancer.setCallbackFilter(new CallbackFilter() {
      public int accept(Method method) {
        final Timing timing = method.getAnnotation(Timing.class);
        System.out.println("timing=====" + timing);
        if (timing == null)
          return 0;
        else
          return 1;
      }
    });
    enhancer.setCallbacks(new Callback[]{NoOp.INSTANCE, new MethodInterceptor() {

      public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long now = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println(method.toGenericString() + "消耗了" + (System.currentTimeMillis() - now) / 1000 + "秒");
        return result;
      }
    }});

    final Object proxy = enhancer.create();
    /*=========WARNING===========*/
    /*特别注意此处，因为cglib是子类代理，此时被代理bean已经产生，而cglib是新开一个增强的子类并实例化
    * 已经初始化过的bean的那些被注入的属性是不会再注入一遍到代理bean上的
    * 因此我们要执行属性拷贝，属性=getter&&setter*/
    /*=========WARNING===========*/

    BeanCopier.create(beanClass,beanClass,false).copy(bean,proxy,null);
    return proxy;
  }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }

}
