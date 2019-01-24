package com.stfn;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Setter
@Getter
public class PersonalFile {
    private int id;
    private static int nextId = 1;
    private String phoneNumb;
    private Person person;
    private LocalDate registrationDate;
    private ArrayList<Appointment> appointments;

    public PersonalFile() {
        setId();
        phoneNumb = "none";
        person = new Person();
        registrationDate = LocalDate.now();
        appointments = new ArrayList<>();
    }

    public PersonalFile(String phoneNumb) {
        this();
        this.phoneNumb = phoneNumb;
    }

    public PersonalFile(String phoneNumb, Person person) {
        this(phoneNumb);
        this.person = person;
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
