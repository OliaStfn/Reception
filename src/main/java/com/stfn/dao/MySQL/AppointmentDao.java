package com.stfn.dao.MySQL;

import com.stfn.beans.Appointment;
import com.stfn.dao.AbstractDao;

import java.sql.Connection;

public class AppointmentDao  extends AbstractDao<Appointment> {
    public AppointmentDao(Connection connection) {
        super(connection);
    }
}
