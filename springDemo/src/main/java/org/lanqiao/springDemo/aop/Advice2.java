package org.lanqiao.springDemo.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Advice2  {
  @Pointcut("execution(* org.lanqiao..*Biz*.*Biz(..))")
  public void bizPointcut(){}


  @Before("bizPointcut()")
  public void invoke(JoinPoint joinPoint) throws Throwable {
    System.out.printf("代理逻辑发生在调用方法%s之前\n", joinPoint.toLongString());
  }
}
