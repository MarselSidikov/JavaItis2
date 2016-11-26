package ru.itis.service;


import ru.itis.models.User;

public interface UserService {
    boolean isMan(String userName);
    void addUser(User user);
    User findUserById(int id);
    void registerUser(User user);
}
