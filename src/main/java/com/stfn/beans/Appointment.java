package com.stfn.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class Appointment {
    private int id;
    private int doctorId;
    private int personalProfileId;
    private String cabNumb;
    private LocalDateTime dateOfVisit;

    public Appointment() {
        doctorId = 0;
        personalProfileId = 0;
        cabNumb = "none";
        dateOfVisit = LocalDateTime.now();
    }

    public Appointment(int doctorId, int personalProfileId, String cabNumb, LocalDateTime dateOfVisit) {
        this.doctorId = doctorId;
        this.personalProfileId = personalProfileId;
        this.cabNumb = cabNumb;
        this.dateOfVisit = dateOfVisit;
    }
}
