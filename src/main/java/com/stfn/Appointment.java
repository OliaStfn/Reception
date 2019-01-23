package com.stfn;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private static int nextId = 1;
    private int doctorId;
    private int personalProfileId;
    private String cabNumb;
    private LocalDateTime dateOfVisit;

    public Appointment() {
        setId();
        doctorId = 0;
        personalProfileId = 0;
        cabNumb = "none";
        dateOfVisit = LocalDateTime.now();
    }

    public Appointment(int doctorId, int personalProfileId, String cabNumb, LocalDateTime dateOfVisit) {
        setId();
        this.doctorId = doctorId;
        this.personalProfileId = personalProfileId;
        this.cabNumb = cabNumb;
        this.dateOfVisit = dateOfVisit;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPersonalProfileId() {
        return personalProfileId;
    }

    public void setPersonalProfileId(int personalProfileId) {
        this.personalProfileId = personalProfileId;
    }

    public String getCabNumb() {
        return cabNumb;
    }

    public void setCabNumb(String cabNumb) {
        this.cabNumb = cabNumb;
    }

    public LocalDateTime getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDateTime dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }
}
