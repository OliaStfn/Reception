package com.stfn.dao.MySQL;

import com.stfn.beans.Schedule;
import com.stfn.beans.Timetable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Collection;

public class TimetableDao {
    private Connection connection;

    public TimetableDao() {
        connection = new Factory().getConnection();
    }

    public Timetable create(Timetable timeTable, DayOfWeek dayOfWeek,
                            int scheduleId) {
        Timetable temp = new Timetable();
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO" +
                " timetable (day_of_week,time_start,time_end,schedule_id) VALUES(?,?,?,?);")) {
            statement.setString(1, dayOfWeek.toString());
            statement.setTime(2, Time.valueOf(timeTable.getTimeStart()));
            statement.setTime(3, Time.valueOf(timeTable.getTimeEnd()));
            statement.setInt(4, scheduleId);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM timetable " +
                "WHERE id=(SELECT last_insert_id());")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                temp.setTimeStart(resultSet.getTime("time_start").toLocalTime());
                temp.setTimeEnd(resultSet.getTime("time_end").toLocalTime());
                temp.setId(resultSet.getInt("id"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}
