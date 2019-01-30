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
        scheduleDao= (ScheduleDao) factory.getDao(Schedule.class);
    }
}
