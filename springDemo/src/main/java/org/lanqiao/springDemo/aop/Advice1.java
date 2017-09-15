package org.lanqiao.springDemo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Advice1 implements MethodInterceptor {
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    System.out.printf("代理逻辑发生在调用方法%s之前\n", methodInvocation.getMethod().toGenericString());
    return methodInvocation.proceed();
  }
}
