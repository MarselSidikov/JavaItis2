package ru.itis;

import ru.itis.factories.ServiceFactory;
import ru.itis.model.User;
import ru.itis.service.UserService;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        UserService userService = ServiceFactory.getInstance().getUserService();

        boolean isRegistered = userService.isRegistered("Nastya");
        System.out.println(isRegistered);
    }
}
