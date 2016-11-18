package ru.itis.homework;


import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class UsersDao {
    private Connection connection;

    public UsersDao(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() {
        // Statement statement = connection.createStatement();
        return null;
    }
}
