package ru.itis.dao;

import ru.itis.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDaoArrayListImpl implements UsersDao {
    private List<User> listOfUsers;

    public UsersDaoArrayListImpl() {
        this.listOfUsers = new ArrayList<User>();
    }


    public List<User> findAll() {
        return this.listOfUsers;
    }

    public void saveUser(User user) {
        this.listOfUsers.add(user);
    }

    public User find(int id) {
        return null;
    }
}
