package ru.itis;

import com.google.common.collect.Lists;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import ru.itis.advice.DisplayTimeInterceptor;
import ru.itis.advice.ThrowsAdviceImpl;
import ru.itis.pointcut.DynamicPointcut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        /**
        // здесь я создаю целевой объект
        ContainingLongRunningMethodClass target =
                new ContainingLongRunningMethodClass();

        // создаем фабрику прокси
        ProxyFactory proxyFactory = new ProxyFactory();
        // говорим фабрике, какой объект является целевым
        proxyFactory.setTarget(target);
        // добавляю адвайс
        proxyFactory.addAdvice(new DisplayTimeInterceptor());
        proxyFactory.addAdvice(new ThrowsAdviceImpl());

        // поучаю прокси
        ContainingLongRunningMethodClass proxy =
                (ContainingLongRunningMethodClass)proxyFactory.getProxy();

        proxy.longLoop();
        proxy.forErrors();
        //proxy.veryLongLoop();

        Integer array[] = {4, 10, 45, 1, 3, 34, 5, 2, 1, 30, 40, 53, 12, 45, 57, 98};
        List<Integer> list = Lists.newArrayList(array);

        proxyFactory.setTarget(list);
        List<Integer> proxyList = (List<Integer>)proxyFactory.getProxy();

        proxyList.indexOf(4);

        ToBeDecorated target = new ToBeDecorated();
        ToBeDecorated proxy;

        Pointcut pointcut = new DynamicPointcut();
        Advice advice = new DisplayTimeInterceptor();
        // аспект - срез(pointcut) + совет(advice) -> advisor
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setTarget(target);

        proxy = (ToBeDecorated)proxyFactory.getProxy();

        proxy.printInteger(5);
        proxy.printInteger(12);

         **/

        ApplicationContext beanFactory = new FileSystemXmlApplicationContext("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis2\\AOP\\src\\main\\resources\\ru.itis\\context.xml");

        ToBeDecorated target = (ToBeDecorated)beanFactory.getBean("toBeDecorated");

        target.randomSleep();

    }
}
