package com.stfn.dao.MySQL;

import com.stfn.beans.Schedule;
import com.stfn.beans.Timetable;
import com.stfn.dao.AbstractDao;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ScheduleDao extends AbstractDao<Schedule> {

    public ScheduleDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO doctor_schedule (doctor_id) VALUES(?);";
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
        return "UPDATE timetable SET day_of_week=?, time_start=?,time_end=? WHERE id=?;";
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
                    schedule.addTimeTable(DayOfWeek.valueOf(dayOfWeek), start, end);
                }
            }
            if (!exists) {
                Schedule schedule = new Schedule();
                schedule.setId(id);
                schedule.setDoctorId(doctorId);
                schedule.addTimeTable(DayOfWeek.valueOf(dayOfWeek), start, end);

                schedules.add(schedule);
            }
        }
        return schedules;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, Schedule obj) throws Exception {
        throw new NotImplementedException();
    }

    public void statementUpdate(PreparedStatement statement, DayOfWeek dayOfWeek, Timetable obj) throws Exception {
        try {
            statement.setString(1, dayOfWeek.toString());
            statement.setTime(2, Time.valueOf(obj.getTimeStart()));
            statement.setTime(3, Time.valueOf(obj.getTimeEnd()));
            statement.setInt(4, obj.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void statementInsert(PreparedStatement statement, Schedule obj) throws Exception {
        statement.setInt(1, obj.getDoctorId());
    }

    @Override
    public Schedule create(Schedule obj) throws Exception {
        Schedule tempObj = null;
        String query = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statementInsert(statement, obj);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        query = getSelectQuery() + "(SELECT last_insert_id();)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            Collection<Schedule> list = parseResultSet(resultSet);
            tempObj = list.iterator().next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempObj;
    }

    @Override
    public void update(Schedule obj) throws Exception {
        for (Map.Entry<DayOfWeek, Timetable> entry : obj.getSchedules().entrySet()) {
            String query = getUpdateQuery();
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statementUpdate(statement, entry.getKey(), entry.getValue());
                statement.execute();
            } catch (Exception e) {
                throw new Exception();
            }
        }
    }
}
