package ru.itis.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.itis.model.Auto;
import ru.itis.model.User;
import ru.itis.model.UserAuto;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UsersDao {

    // language=sql
    private static String SQL_SELECT_USERS_WITH_AUTO =
            "SELECT * FROM group_member,autos WHERE group_member.id = " +
                    "autos.member_id ORDER BY member_id;";

    // language=sql
    private static String SQL_GET_USERS = "SELECT * FROM group_member;";
    // language=sql
    private static String SQL_GET_AUTO = "SELECT * FROM autos";

    // language=sql
    private static String SQL_GET_USER_BY_ID =
            "SELECT * FROM group_member WHERE id = :userId;";

    // шаблон для работы с базами данных
    private NamedParameterJdbcTemplate template;

    private Map<Long, User> userMap;
    // dataSource - источник данных
    public UsersDao(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
        userMap = new HashMap<Long, User>();
    }

    RowMapper<User> userRowMapper = new RowMapper<User>() {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User(resultSet.getLong("id"), resultSet.getString("name"), new ArrayList<Auto>());
            userMap.put(user.getId(), user);
            return user;
        }
    };

    RowMapper<Auto> autoRowMapper = new RowMapper<Auto>() {
        public Auto mapRow(ResultSet resultSet, int i) throws SQLException {
            Auto auto = new Auto(resultSet.getLong("id"), resultSet.getString("model"),
                    userMap.get(resultSet.getLong("member_id")));

            userMap.get(auto.getOwner().getId()).getAutos().add(auto);
            return auto;
        }
    };

    RowMapper<UserAuto> userAutoRowMapper = new RowMapper<UserAuto>() {
        public UserAuto mapRow(ResultSet resultSet, int i) throws SQLException {
            long userId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            long autoId = resultSet.getInt(3);
            String model = resultSet.getString(4);
            long memberId = resultSet.getInt(5);

            UserAuto userAuto = new UserAuto(userId, name, autoId, model, memberId);

            return userAuto;
        }
    };

    public List<User> findAllWithAutos() {
        List<UserAuto> result = template.query(SQL_SELECT_USERS_WITH_AUTO, userAutoRowMapper);
        for (UserAuto userAuto : result) {
            System.out.println(userAuto.getUserId() + " " + userAuto.getName()
            + " " + userAuto.getAutoId() + " " + userAuto.getModel() + " " + userAuto.getMemberId());
        }

        long currentId = result.get(0).getUserId();
        String currentName = result.get(0).getName();
        List<Auto> autos = new ArrayList<Auto>();
        List<User> realyResult = new ArrayList<User>();
        User user = new User(currentId, currentName, autos);
        Auto auto;
        int i = 0;
        while (i < result.size()){
            if (user.getId().equals(result.get(i).getUserId())) {
                auto = new Auto(result.get(i).getAutoId(), result.get(i).getModel(), user);
                user.getAutos().add(auto);
            } else {
                realyResult.add(user);
                user = new User(result.get(i).getUserId(), result.get(i).getName(), new ArrayList<Auto>());
                auto = new Auto(result.get(i).getAutoId(), result.get(i).getModel(), user);
                user.getAutos().add(auto);
            }
            i++;
        }
        realyResult.add(user);
        return realyResult;
    }

    public List<User> findAll() {
        template.query(SQL_GET_USERS, userRowMapper);
        template.query(SQL_GET_AUTO, autoRowMapper);

        return new ArrayList<User>(userMap.values());
    }

    public User find(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", id);
        return template.queryForObject(SQL_GET_USER_BY_ID, params, userRowMapper);
    }
}
