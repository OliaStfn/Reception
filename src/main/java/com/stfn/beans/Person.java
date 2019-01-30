package com.stfn.beans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;


    public Person(String name, String surname, LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}