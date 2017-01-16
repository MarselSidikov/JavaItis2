package ru.itis.pointcut;


import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import ru.itis.ToBeDecorated;

import java.lang.reflect.Method;

public class DynamicPointcut extends DynamicMethodMatcherPointcut {
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> clazz) {
                return clazz == ToBeDecorated.class;
            }
        };
    }

    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        if (args.length == 0) {
            return false;
        }

        Object obj = args[0];

        if (obj instanceof Integer) {
            return (Integer) obj > 10;
        } else {
            return false;
        }
    }
}
