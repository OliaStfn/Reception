package com.stfn;

import java.time.LocalDate;
import java.util.ArrayList;

public class Catalog {
    private int id;
    private static int nextId = 1;
    private ArrayList<PersonalFile> personalFiles;
    private ArrayList<Doctor> doctors;

    public Catalog() {
        setId();
        personalFiles = new ArrayList<>();
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

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<PersonalFile> getPersonalFiles() {
        return personalFiles;
    }

    public void setPersonalFiles(ArrayList<PersonalFile> personalFiles) {
        this.personalFiles = personalFiles;
    }

    public PersonalFile searchById(int id) {
        for (PersonalFile personalFile : personalFiles) {
            if (id == personalFile.getId()) {
                return personalFile;
            }
        }
        return null;
    }

    public PersonalFile searchByFullName(String name, String surname) {
        for (PersonalFile personalFile : personalFiles) {
            if (name.equals(personalFile.getPerson().getName())
                    && surname.equals(personalFile.getPerson().getSurname())) {
                return personalFile;
            }
        }
        return null;
    }

    public PersonalFile searchByPhone(String phoneNumb) {
        for (PersonalFile personalFile : personalFiles) {
            if (personalFile.getPhoneNumb().contains(phoneNumb)) {
                return personalFile;
            }
        }
        return null;
    }

    public void addPersonalFile(String name, String surname, LocalDate bornDate, String phoneNumber) {
        Person person = new Person(name, surname, bornDate);
        PersonalFile personalFile = new PersonalFile(phoneNumber, person);
        personalFiles.add(personalFile);
    }

    public void deleteById(int id) {
        personalFiles.remove(searchById(id));
    }

    public void deleteByPhone(String phoneNumb) {
        personalFiles.remove(searchByPhone(phoneNumb));
    }

    public void addDoctor(String name, String surname, LocalDate dateOfBirth, String specialization, Schedule schedule) {
        Doctor doctor = new Doctor(name, surname, dateOfBirth, specialization, schedule);
        doctors.add(doctor);
    }

    public void deleteDoctor(int id){
        for(Doctor doctor:doctors){
            if(id==doctor.getId()){
                doctors.remove(doctor);
            }
        }
    }
}
