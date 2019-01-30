package com.stfn.services;

import com.stfn.beans.Doctor;
import com.stfn.dao.MySQL.DoctorDao;
import com.stfn.dao.MySQL.Factory;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DoctorService {
    private DoctorDao doctorDao;

    public DoctorService() {
        Factory factory = new Factory();
        doctorDao = (DoctorDao) factory.getDao(Doctor.class);
    }
}
