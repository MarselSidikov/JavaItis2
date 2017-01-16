package ru.itis.service;

import ru.itis.dao.UsersDao;
import ru.itis.models.User;

public class UserServiceImpl implements UserService {

    private UsersDao usersDao;

    public UserServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }


    public User getUser(int id) {
        return usersDao.find(id);
    }
}
