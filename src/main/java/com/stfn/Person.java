package com.stfn;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
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

    public void setId() {
        id = nextId;
        nextId++;
    }
}
