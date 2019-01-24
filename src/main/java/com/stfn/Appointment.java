package com.stfn;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
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

    public void setId() {
        id = nextId;
        nextId++;
    }
}
