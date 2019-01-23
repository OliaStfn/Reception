package com.stfn;

import java.time.LocalDate;

public class Person {
    private int id;
    private static int nextId = 1;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;

    public Person() {
        setId();
        name = "none";
        surname = "none";
        dateOfBirth = LocalDate.now();
    }

    public Person(String name, String surname) {
        this();
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, LocalDate dateOfBirth) {
        this(name, surname);
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
