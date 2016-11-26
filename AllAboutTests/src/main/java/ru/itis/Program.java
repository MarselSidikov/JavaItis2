package ru.itis;

import ru.itis.dao.UsersDao;
import ru.itis.dao.UsersDaoArrayListImpl;
import ru.itis.models.User;
import ru.itis.service.UserService;
import ru.itis.service.UserServiceImpl;

public class Program {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDaoArrayListImpl();

        User marsel = new User("Marsel", 'm');
        User nastya = new User("Nastya", 'w');

        usersDao.saveUser(marsel);
        usersDao.saveUser(nastya);

        UserService userService = new UserServiceImpl(usersDao, null);

        System.out.println(userService.isMan("Marsel"));
        System.out.println(userService.isMan("Nastya"));

        userService.isMan("Gheburek");

    }
}
