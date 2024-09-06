package com.mmako.spring.service.models;

public class ServiceUser {
    private String name;
    private String surname;
    private String number;

    public ServiceUser(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
    }

    // Getters and Setters (if needed)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
