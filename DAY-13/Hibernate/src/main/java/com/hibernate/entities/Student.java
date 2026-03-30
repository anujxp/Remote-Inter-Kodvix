package com.hibernate.entities;

public class Student {
    private int id;
    private String name;
    private String city;

    // Default Constructor, Getters and Setters are MANDATORY
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // ... add name and city getters/setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}