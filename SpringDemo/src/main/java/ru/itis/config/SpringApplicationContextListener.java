package ru.itis.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringApplicationContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ru.itis.components\\application-context.xml");
        servletContextEvent.getServletContext().setAttribute("applicationContext", applicationContext);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
