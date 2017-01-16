package ru.itis.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.config.JavaConfiguration;
import ru.itis.models.User;
import ru.itis.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfiguration.class);

        userService = context.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // получили пользователя
        User user = userService.getUser(10);
        // создали конвертер
        ObjectMapper objectMapper = new ObjectMapper();
        // получили строкове представление объекта в формате JSON
        String stringResponse = objectMapper.writeValueAsString(user);
        // указали контент-тайп для джейсона
        resp.setContentType("application/json");
        // записали результат
        resp.getWriter().write(stringResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получаем содержимое запроса - json
        String stringRequest = req.getReader().readLine();

        ObjectMapper objectMapper = new ObjectMapper();
        // выполняем конвертацию
        User myUser = objectMapper.readValue(stringRequest, User.class);
        // отправляем
        System.out.println(myUser.getName() + " " + myUser.getAutos().get(0).getModelName());
    }
}
