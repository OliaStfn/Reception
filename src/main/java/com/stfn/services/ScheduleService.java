package com.stfn.services;

import com.stfn.beans.Schedule;
import com.stfn.dao.MySQL.Factory;
import com.stfn.dao.MySQL.ScheduleDao;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ScheduleService {
    private ScheduleDao scheduleDao;

    public ScheduleService() {
        Factory factory = new Factory();
        scheduleDao = (ScheduleDao) factory.getDao(Schedule.class);
    }

    public void addSchedule(int doctorId) {
        Schedule schedule = new Schedule(doctorId);
        try {
            scheduleDao.create(schedule);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSchedule(int doctorId){
        try {
            scheduleDao.delete(doctorId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
