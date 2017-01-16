package ru.itis.spring.hibernate.dto;

public class AutoDto {
    private String model;
    private String userName;

    public AutoDto() {
    }

    public AutoDto(String model, String userName) {
        this.model = model;
        this.userName = userName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
