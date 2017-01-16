package ru.itis.spring.hibernate.converters;


import ru.itis.spring.hibernate.dto.UserDto;
import ru.itis.spring.hibernate.models.User;

import java.util.ArrayList;
import java.util.List;

import static ru.itis.spring.hibernate.converters.UserToUserDtoConverter.convert;

public class UsersListToUserDtoListConverter {
    public static List<UserDto> convertAll(List<User> models) {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (User model : models) {
            UserDto userDto = convert(model);
            userDtos.add(userDto);
        }

        return userDtos;
    }
}
