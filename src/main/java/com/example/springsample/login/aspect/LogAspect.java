package com.example.springsample.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogAspect {

  @Around("execution(* *..*.*Controller.*(..))")
  public Object startLog(ProceedingJoinPoint jp) throws Throwable {
    System.out.println("メソッド開始：" + jp.getSignature());

    try {
      // メソッド実行
      Object result = jp.proceed();
      System.out.println("メソッド終了：" + jp.getSignature());
      return result;
    } catch (Throwable throwable) {
      System.out.println("メソッド異常終了：" + jp.getSignature());
      throwable.printStackTrace();
      throw throwable;
    }
  }

//  @After("execution(* *..*.*Controller.*(..))")
//  public void endLog(JoinPoint jp) {
//    System.out.println("メソッド終了：" + jp.getSignature());
//  }

}
