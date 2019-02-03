package com.stfn.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalFile that = (PersonalFile) o;
        return Objects.equals(phoneNumb, that.phoneNumb) &&
                Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumb, person);
    }
}
