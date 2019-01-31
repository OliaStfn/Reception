package com.stfn.services;

import com.stfn.beans.Appointment;
import com.stfn.dao.GenericDao;
import com.stfn.dao.MySQL.AppointmentDao;
import com.stfn.dao.MySQL.Factory;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class AppointmentService {
    private GenericDao<Appointment> appointmentDao;

    public AppointmentService() {
        Factory factory = new Factory();
        appointmentDao = (AppointmentDao) factory.getDao(Appointment.class);
    }

    public void addAppointment(int doctorId, int personalFileId, String cabNumb, LocalDateTime visitDay) {
        Appointment appointment = new Appointment(doctorId, personalFileId, cabNumb, visitDay);
        try {
            appointmentDao.create(appointment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int id) {
        try {
            appointmentDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
