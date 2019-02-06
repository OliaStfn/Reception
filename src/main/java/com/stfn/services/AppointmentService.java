package com.stfn.services;

import com.stfn.beans.Appointment;
import com.stfn.dao.GenericDao;
import com.stfn.dao.MySQL.AppointmentDao;
import com.stfn.dao.MySQL.Factory;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

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

    public Appointment readById(int id){
        try {
           return  appointmentDao.read(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Appointment> readByDocId(int doctorId){
        ArrayList<Appointment>result= new ArrayList<Appointment>();
        try {
            for(Appointment appointment: appointmentDao.readAll()){
                if(doctorId== appointment.getDoctorId()){
                    result.add(appointment);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Appointment> readByPersonalFileId(int personalFileId){
        ArrayList<Appointment> result = new ArrayList<Appointment>();
        try{
            for(Appointment appointment : appointmentDao.readAll()){
                if(personalFileId== appointment.getPersonalProfileId()){
                    result.add(appointment);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
