package ru.itis;

import java.sql.*;

public class Main {

    // language=SQL
    private static final String SQL_SELECT_USER =
            "SELECT * FROM group_member;";

    // language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO group_member(id, name) VALUES(?, ?);";

    public static void main(String[] args) {
        Connection connection = null;

        String url = "jdbc:postgresql://localhost:5432/java_itis_group";

        String name = "postgres";
        String password = "qwerty007";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(SQL_SELECT_USER);

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + "," + resultSet.getString("name"));
            }

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            preparedStatement.setInt(1, 10);
            preparedStatement.setString(2, "Petya");

            preparedStatement.execute();
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
