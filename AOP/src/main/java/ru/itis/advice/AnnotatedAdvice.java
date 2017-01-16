package ru.itis.advice;

import org.aopalliance.intercept.Joinpoint;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnnotatedAdvice {

    @Around(value = "execution(public void randomSleep())")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("randomSleep aspect");
        return joinPoint.proceed();
    }
}
