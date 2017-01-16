package ru.itis.advice;


import org.springframework.aop.ThrowsAdvice;

public class ThrowsAdviceImpl implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {
        if (ex.getMessage().equals("SOME ERROR")) {
            System.out.println("SOME ERROR IN ADVICE");
        } else {
            System.out.println("UNDEFINED ERROR");
        }
    }
}
