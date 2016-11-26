package ru.itis.service;

import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UsersDao usersDao;
    private UserUtils userUtils;

    public UserServiceImpl(UsersDao usersDao, UserUtils userUtils) {
        this.usersDao = usersDao;
        this.userUtils = userUtils;
    }

    public void addUser(User user) {
        user.setStatus("Added");
        usersDao.saveUser(user);
    }

    public User findUserById(int id) {
        return usersDao.find(id);
    }

    public void registerUser(User newUser) {
        List<User> users = usersDao.findAll();

        userUtils.checkAlreadyRegistered(newUser.getName(), users);

        usersDao.saveUser(newUser);
    }

    public boolean isMan(String userName) {
        List<User> users = usersDao.findAll();

        for (User user : users) {
            if (user.getName().equals(userName)) {
                return user.getSex() == 'm';
            }
        }

        throw new IllegalArgumentException("User with name <" + userName + "> not found");
    }
}
