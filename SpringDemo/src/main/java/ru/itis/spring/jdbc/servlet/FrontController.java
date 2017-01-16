package ru.itis.spring.jdbc.servlet;


import org.springframework.web.util.UriTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController extends HttpServlet {

    private final UriTemplate deleteAutoTemplate = new UriTemplate("/users/{user-id}/autos/{auto-id}");

    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HELLO");
        String requestMethod = req.getMethod();
        String requestUri = req.getRequestURI();

        if (deleteAutoTemplate.matches(requestUri)) {
            Map<String, String> pathVariablesValues = deleteAutoTemplate.match(requestUri);
            req.setAttribute("user-id", pathVariablesValues.get("user-id"));
            req.setAttribute("auto-id", pathVariablesValues.get("auto-id"));
            req.getRequestDispatcher("/users").forward(req, resp);
        }
        if (requestMethod.equals("PUT") && requestUri.equals("/users")) {
            req.getRequestDispatcher("/users").forward(req, resp);
        } else {
            req.getRequestDispatcher("example.jsp").forward(req, resp);
        }
    }

}
