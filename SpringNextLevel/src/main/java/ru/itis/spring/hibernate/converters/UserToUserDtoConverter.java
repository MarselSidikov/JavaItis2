package ru.itis.spring.hibernate.converters;


import ru.itis.spring.hibernate.dto.AutoDto;
import ru.itis.spring.hibernate.dto.UserDto;
import ru.itis.spring.hibernate.models.Auto;
import ru.itis.spring.hibernate.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserToUserDtoConverter {
    public static UserDto convert(User model) {
        int id = model.getId();
        List<AutoDto> autos = new ArrayList<AutoDto>();

        for (Auto auto : model.getAutos()) {
            AutoDto autoDto = new AutoDto(auto.getModel(), auto.getUser().getName());
            autos.add(autoDto);
        }
        return new UserDto(id, autos);
    }
}
