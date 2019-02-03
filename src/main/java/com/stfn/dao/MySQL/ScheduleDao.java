package com.stfn.dao.MySQL;

import com.stfn.beans.Schedule;
import com.stfn.dao.AbstractDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

public class ScheduleDao extends AbstractDao<Schedule> {

    public ScheduleDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM schedule sc LEFT JOIN timetable tt " +
                "ON sc.id= tt.schedule_id WHERE sc.id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM schedule sc LEFT JOIN timetable tt " +
                "ON sc.id= tt.schedule_id ;";
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM schedule WHERE id=?";
    }

    @Override
    public Collection<Schedule> parseResultSet(ResultSet resultSet) throws Exception {
        Collection<Schedule> schedules = new ArrayList<Schedule>();
        while (resultSet.next()) {
            boolean exists = false;
            int id = resultSet.getInt("doctor_schedule.id");
            int doctorId = resultSet.getInt("doctor_id");
            String dayOfWeek = resultSet.getString("day_of_day");
            LocalTime start = resultSet.getTime("time_start").toLocalTime();
            LocalTime end = resultSet.getTime("time_end").toLocalTime();

            for (Schedule schedule : schedules) {
                if (schedule.getId() == id) {
                    exists = true;
                    schedule.addTimeTable(DayOfWeek.valueOf(dayOfWeek),start,end);
                }
            }
            if(!exists){
                Schedule schedule = new Schedule();
                schedule.setId(id);
                schedule.setDoctorId(doctorId);
                schedule.addTimeTable(DayOfWeek.valueOf(dayOfWeek),start,end);

                schedules.add(schedule);
            }
        }
        return schedules;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, Schedule obj) throws Exception {

    }

    @Override
    public void statementInsert(PreparedStatement statement, Schedule obj) throws Exception {

    }
}
