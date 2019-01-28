package com.stfn.dao.MySQL;

import com.stfn.beans.Doctor;
import com.stfn.dao.AbstractDao;

import java.sql.Connection;

public class DoctorDao extends AbstractDao<Doctor> {
    public DoctorDao(Connection connection) {
        super(connection);
    }
}
