package ru.itis.dao;

import ru.itis.models.User;

/**
 * Created by admin on 02.11.2016.
 */
public interface UsersDao {
    User find(int id);
}
