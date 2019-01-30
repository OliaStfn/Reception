package com.stfn.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter
public class PersonalFile {
    private int id;
    private static int nextId = 1;
    private String phoneNumb;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDateTime registrationDate;
    private ArrayList<Appointment> appointments;

    public PersonalFile() {
        setId();
        phoneNumb = "none";
        registrationDate= LocalDateTime.now();
        appointments = new ArrayList<>();
    }

    public PersonalFile(String phoneNumb) {
        this();
        this.phoneNumb = phoneNumb;
    }


    public void setId() {
        id = nextId;
        nextId++;
    }

 /*   public void setPhoneNumb(String phoneNumb) {
        if(phoneNumb.startsWith("0")&& phoneNumb.length()==9){
            this.phoneNumb="+38"+phoneNumb;
        }else this.phoneNumb=phoneNumb;
    }*/
}
