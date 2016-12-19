package ru.itis.spring.hibernate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spring.hibernate.dao.UsersDao;
import ru.itis.spring.hibernate.models.User;

import java.util.List;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<User> getAllUsers() {
        return usersDao.findAll();
    }
}
