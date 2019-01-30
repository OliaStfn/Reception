package com.stfn.beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter
public class Doctor extends Person{
    private int id;
    private String specialization;
    private Schedule schedule;
    private ArrayList<Appointment> appointments;

    public Doctor() {
        super();
        specialization = "none";
        schedule = new Schedule();
        appointments = new ArrayList<>();
    }

    public Doctor(String name, String surname, LocalDate dateOfBirth, String specialization,
                  Schedule schedule) {
        appointments = new ArrayList<>();
        this.specialization = specialization;
        this.schedule = schedule;
    }

    public void addAppointment(int doctorId, int personalFileId, String cabNumb, LocalDateTime visitDay) {
        Appointment appointment = new Appointment(doctorId, personalFileId, cabNumb, visitDay);
        appointments.add(appointment);
    }

    public void deleteAppointment(int id) {
        for (Appointment appointment : appointments) {
            if (id == appointment.getId()) {
                appointments.remove(appointment);
            }
        }
    }
}
