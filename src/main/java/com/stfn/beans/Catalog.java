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
            if (name.equals(personalFile.getPerson().getFirstName())
                    && surname.equals(personalFile.getPerson().getLastName())) {
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

    public Doctor searchDocById(int id) {
        for (Doctor doctor : doctors) {
            if (id == doctor.getId()) {
                return doctor;
            }
        }
        return null;
    }

    public Doctor searchDocByFullName(String name, String surname) {
        for (Doctor doctor : doctors) {
            if (name.equals(doctor.getFirstName()) && surname.equals(doctor.getLastName())) {
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> searchDocBySpecialization(String specialization) {
        ArrayList<Doctor> doctorSpec = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if ((doctor.getSpecialization().toLowerCase()).contains(specialization.toLowerCase())) {
                doctorSpec.add(doctor);
            }
        }
        return doctorSpec;
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

    public void deleteDoctor(int id) {
        for (Doctor doctor : doctors) {
            if (id == doctor.getId()) {
                doctors.remove(doctor);
            }
        }
    }
}
