package com.stfn.services;

import com.stfn.beans.Doctor;
import com.stfn.beans.Schedule;
import com.stfn.dao.GenericDao;
import com.stfn.dao.MySQL.DoctorDao;
import com.stfn.dao.MySQL.Factory;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
public class DoctorService {
    private GenericDao<Doctor> doctorDao;

    public DoctorService() {
        Factory factory = new Factory();
        doctorDao = (DoctorDao) factory.getDao(Doctor.class);
    }

    public Doctor searchDocById(int id) {
        try {
            for (Doctor doctor : doctorDao.readAll()) {
                if (id == doctor.getId()) {
                    return doctor;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Doctor searchDocByFullName(String name, String surname) {
        try {
            for (Doctor doctor : doctorDao.readAll()) {
                if (name.equals(doctor.getFirstName()) && surname.equals(doctor.getLastName())) {
                    return doctor;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Doctor> searchDocBySpecialization(String specialization) {
        ArrayList<Doctor> doctorSpec = new ArrayList<>();
        try {
            for (Doctor doctor : doctorDao.readAll()) {
                if ((doctor.getSpecialization().toLowerCase()).contains(specialization.toLowerCase())) {
                    doctorSpec.add(doctor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorSpec;
    }

    public void addDoctor(String name, String surname, LocalDate dateOfBirth, String specialization, Schedule schedule) {
        Doctor doctor = new Doctor(name, surname, dateOfBirth, specialization, schedule);
        try {
            doctorDao.create(doctor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDoctor(int id) {
        try {
            doctorDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

