package com.stfn.dao.MySQL;

import com.stfn.beans.Appointment;
import com.stfn.dao.AbstractDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

public class AppointmentDao extends AbstractDao<Appointment> {
    public AppointmentDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO appointment (cab_number,date_of_visit,doctor_id,personal_file_id)" +
                "VALUES(?,?,?,?);";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM appointment WHERE id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM appointment;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE appointment SET cab_number=?,date_of_visit=?,doctor_id=?," +
                "personal_file_id=?; ";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM appointment WHERE id=?;";
    }

    @Override
    public Collection<Appointment> parseResultSet(ResultSet resultSet) throws Exception {
        Collection<Appointment> appointments = new ArrayList<Appointment>();
        while (resultSet.next()) {
            Appointment temp = new Appointment();
            temp.setCabNumb(resultSet.getString("cab_number"));
            temp.setDateOfVisit(resultSet.getTimestamp("date_of_visit").toLocalDateTime());
            temp.setDoctorId(resultSet.getInt("doctor_id"));
            temp.setPersonalProfileId(resultSet.getInt("personal_file_id"));

            appointments.add(temp);
        }
        return appointments;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, Appointment obj) throws Exception {
        statement.setString(1, obj.getCabNumb());
        statement.setTimestamp(2, Timestamp.valueOf(obj.getDateOfVisit()));
        statement.setInt(3, obj.getDoctorId());
        statement.setInt(4, obj.getPersonalProfileId());
        statement.setInt(5, obj.getId());
    }

    @Override
    public void statementInsert(PreparedStatement statement, Appointment obj) throws Exception {
        statement.setString(1, obj.getCabNumb());
        statement.setTimestamp(2, Timestamp.valueOf(obj.getDateOfVisit()));
        statement.setInt(3, obj.getDoctorId());
        statement.setInt(4, obj.getPersonalProfileId());
    }
}
