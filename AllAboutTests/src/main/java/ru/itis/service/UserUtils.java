package ru.itis.service;

import ru.itis.models.User;

import java.util.List;

public interface UserUtils {
    void checkAlreadyRegistered(String userName, List<User> users);
}
