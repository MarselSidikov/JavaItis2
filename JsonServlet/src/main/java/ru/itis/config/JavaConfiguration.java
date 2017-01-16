package ru.itis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoImpl;
import ru.itis.service.UserService;
import ru.itis.service.UserServiceImpl;

@Configuration
public class JavaConfiguration {

    @Bean
    public UserService userService() {
        return new UserServiceImpl(usersDao());
    }

    @Bean
    public UsersDao usersDao() {
        return new UsersDaoImpl();
    }
}
