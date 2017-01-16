package ru.itis.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Date;

// Advice, который вызывается вместо целевого метода, а сам
// метод передается как параметр
// таким образом мы вообще можем проигнорировать вызов
public class DisplayTimeInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long preTime = System.currentTimeMillis();
        System.out.println("Time before method launch: " + preTime);
        // перейти к следующему интерцептору
        Object value = methodInvocation.proceed();
        System.out.println("Time after method launch: " + (System.currentTimeMillis() - preTime));
        return value;
    }
}
