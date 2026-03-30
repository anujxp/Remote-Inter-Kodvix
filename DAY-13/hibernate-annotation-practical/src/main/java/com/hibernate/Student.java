package com.hibernate;


import jakarta.persistence.*;

@Entity
@Table(name = "student_anno")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private int id;

    @Column(name = "student_name", length = 100, nullable = false)
    private String name;

    private String city;

    // Constructors
    public Student() {}
    public Student(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}