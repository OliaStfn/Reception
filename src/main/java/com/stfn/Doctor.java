package com.stfn;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Doctor extends Person {
    private int id;
    private static int nextId = 1;
    private String specialization;
    private Schedule schedule;
    private ArrayList<Appointment> appointments;

    public Doctor() {
        super();
        setId();
        specialization = "none";
        schedule = new Schedule();
        appointments = new ArrayList<>();
    }

    public Doctor(String specialization, Schedule schedule) {
        this();
        this.specialization = specialization;
        this.schedule = schedule;
    }

    public Doctor(String name, String surname, LocalDate dateOfBirth, String specialization,
                  Schedule schedule) {
        super(name, surname, dateOfBirth);
        setId();
        appointments = new ArrayList<>();
        this.specialization = specialization;
        this.schedule = schedule;
    }

    public void addAppointment(int doctorId, int personalFileId, String cabNumb, LocalDateTime visitDay) {
        Appointment appointment = new Appointment(doctorId, personalFileId, cabNumb, visitDay);
        appointments.add(appointment);
    }

    public void deleteAppointment(int id){
        for (Appointment appointment: appointments){
            if(id==appointment.getId()){
                appointments.remove(appointment);
            }
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
}
