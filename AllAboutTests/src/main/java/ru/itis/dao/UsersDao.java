package ru.itis.dao;

import ru.itis.models.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UsersDao {
    List<User> findAll();
    void saveUser(User user);
    User find(int id);
}
