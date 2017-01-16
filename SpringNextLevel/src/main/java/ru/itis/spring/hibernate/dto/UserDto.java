package ru.itis.spring.hibernate.dto;

import java.util.List;

public class UserDto {
    private int id;
    private List<AutoDto> autoDto;

    public UserDto() {
    }

    public UserDto(int id, List<AutoDto> autoDto) {
        this.id = id;
        this.autoDto = autoDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AutoDto> getAutoDto() {
        return autoDto;
    }

    public void setAutoDto(List<AutoDto> autoDto) {
        this.autoDto = autoDto;
    }
}
