package com.stfn.dao.MySQL;

import com.stfn.beans.Schedule;
import com.stfn.dao.AbstractDao;

import java.sql.Connection;

public class ScheduleDao extends AbstractDao<Schedule> {

    public ScheduleDao(Connection connection) {
        super(connection);
    }
}
