package ru.itis.dao;

import ru.itis.models.Auto;
import ru.itis.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {

    public User find(int id) {
        User user = new User();
        user.setName("Marsel");
        user.setIds(new int[]{1, 2, 3});
        user.setAge(22);

        List<Auto> autos = new ArrayList<Auto>();
        autos.add(new Auto(10, "Camry"));
        autos.add(new Auto(12, "BMW"));

        user.setAutos(autos);

        return user;
    }
}
