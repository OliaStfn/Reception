package com.stfn.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Setter
@Getter
public class Catalog {
    private int id;
    private ArrayList<PersonalFile> personalFiles;
    private ArrayList<Doctor> doctors;

    public Catalog() {
        personalFiles = new ArrayList<>();
        doctors = new ArrayList<>();
    }

}
