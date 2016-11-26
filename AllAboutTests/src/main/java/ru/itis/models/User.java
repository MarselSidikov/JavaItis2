package ru.itis.models;

public class User {
    private String name;
    private char sex;
    private String status;

    public User(String name, char sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
