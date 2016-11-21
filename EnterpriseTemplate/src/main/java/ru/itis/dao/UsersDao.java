package ru.itis.dao;

import ru.itis.model.User;

import java.util.List;

public interface UsersDao {
    List<User> findAll();
}
