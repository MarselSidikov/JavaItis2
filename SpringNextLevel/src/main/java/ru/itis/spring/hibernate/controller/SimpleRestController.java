package ru.itis.spring.hibernate.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.spring.hibernate.dto.UserDto;
import ru.itis.spring.hibernate.models.User;
import ru.itis.spring.hibernate.service.UsersService;

import java.util.List;

import static ru.itis.spring.hibernate.converters.UsersListToUserDtoListConverter.convertAll;

@Controller
public class SimpleRestController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/users.json", method = RequestMethod.GET)
    @ResponseBody String getUsers() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> users = usersService.getAllUsers();

        List<UserDto> userDtos = convertAll(users);
        try {
            return objectMapper.writeValueAsString(userDtos);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @RequestMapping(value = "rest/users/{user-id}/autos",
            method = RequestMethod.GET)
    @ResponseBody public String getAutos(@PathVariable("user-id") int userId,
                                         @RequestParam("color") String color,
                                         @RequestHeader("Content-Type") String header) {
        System.out.println(userId);
        System.out.println(color);
        System.out.println(header);
        return null;
    }

    @RequestMapping(value = "rest/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        System.out.println(user.getName() + user.getAge());
    }

    @RequestMapping(value = "/forResponse", method = RequestMethod.GET)
    @ResponseBody public ResponseEntity<User> getResponse() {

    }
}
