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
    private String phoneNumb;
    private LocalDateTime registrationDate;
    private ArrayList<Appointment> appointments;
    private Person person;

    public PersonalFile() {
        phoneNumb = "none";
        registrationDate= LocalDateTime.now();
        appointments = new ArrayList<>();
        person = new Person();
    }

    public PersonalFile(String phoneNumb) {
        this();
        this.phoneNumb = phoneNumb;
    }

    public PersonalFile(String phoneNumb, Person person) {
        this.phoneNumb = phoneNumb;
        this.person = person;
    }

    /*   public void setPhoneNumb(String phoneNumb) {
        if(phoneNumb.startsWith("0")&& phoneNumb.length()==9){
            this.phoneNumb="+38"+phoneNumb;
        }else this.phoneNumb=phoneNumb;
    }*/
}
