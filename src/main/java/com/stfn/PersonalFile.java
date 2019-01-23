package com.stfn;

import java.time.LocalDate;
import java.util.ArrayList;

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
        appointments= new ArrayList<>();
    }

    public PersonalFile(String phoneNumb) {
        this();
        this.phoneNumb = phoneNumb;
    }

    public PersonalFile(String phoneNumb, Person person) {
        this(phoneNumb);
        this.person = person;
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

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
        /*if(phoneNumb.startsWith("0")&& phoneNumb.length()==9){
            this.phoneNumb="+38"+phoneNumb;
        }else this.phoneNumb=phoneNumb;*/
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
}
