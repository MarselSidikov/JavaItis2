package ru.itis.service;

import ru.itis.models.User;

import java.util.List;

public class UserUtilsImpl implements UserUtils {
    public void checkAlreadyRegistered(String userName, List<User> users) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
