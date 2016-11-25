package ru.itis;

import ru.itis.dao.UsersDao;
import ru.itis.factories.DataSourceFactory;
import ru.itis.model.User;

import java.util.List;
import java.util.ListResourceBundle;

public class Program {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao(DataSourceFactory.getDataSourceFactory().getDataSource());
        List<User> result = usersDao.findAllWithAutos();
        List<User> result2 = usersDao.findAll();
        User user = usersDao.find(4);

        int i = 0;
    }
}
