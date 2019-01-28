package com.stfn.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class Person {
    private int id;
    private static int nextId = 1;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person() {
        setId();
        firstName = "none";
        lastName = "none";
        dateOfBirth = LocalDate.now();
    }

    public Person(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, LocalDate dateOfBirth) {
        this(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }
}
