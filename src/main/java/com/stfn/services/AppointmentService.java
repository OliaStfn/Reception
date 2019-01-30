package com.stfn.services;

import com.stfn.beans.Appointment;
import com.stfn.dao.MySQL.AppointmentDao;
import com.stfn.dao.MySQL.Factory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppointmentService {
    private AppointmentDao appointmentDao;

    public AppointmentService() {
        Factory factory= new Factory();
        appointmentDao = (AppointmentDao) factory.getDao(Appointment.class);
    }
}
