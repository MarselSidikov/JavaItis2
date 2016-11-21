package ru.itis.dao;

import ru.itis.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoJdbcImpl implements UsersDao {

    private Connection connection;

    // language=SQL
    private static final String SQL_SELECT_USER =
            "SELECT * FROM group_member;";

    public  UsersDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USER);
            List<User> resultList = new ArrayList<User>();
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String userName = resultSet.getString("name");

                User user = new User(userId, userName);
                resultList.add(user);
            }

            return resultList;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
