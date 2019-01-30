package com.stfn.dao.MySQL;

import com.stfn.beans.Doctor;
import com.stfn.dao.AbstractDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class DoctorDao extends AbstractDao<Doctor> {
    public DoctorDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO doctor (first_name,last_name,date_of_birth,specialization)" +
                "VALUES (?,?,?,?);";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM doctor WHERE id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM doctor;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE doctor SET first_name=?, last_name=?,date_of_birth=?,specialization=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM doctor WHERE id=?";
    }

    @Override
    public Collection<Doctor> parseResultSet(ResultSet resultSet) throws Exception {
        Collection<Doctor> doctors = new ArrayList<Doctor>();
        try {
            while (resultSet.next()) {
                Doctor temp = new Doctor();
                temp.setId(resultSet.getInt("id"));
                temp.setFirstName(resultSet.getString("first_name"));
                temp.setLastName(resultSet.getString("last_name"));
                temp.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                temp.setSpecialization(resultSet.getString("specialization"));

                doctors.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, Doctor obj) throws Exception {
        try {
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setDate(3, Date.valueOf(obj.getDateOfBirth()));
            statement.setString(4, obj.getSpecialization());
            statement.setInt(5, obj.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void statementInsert(PreparedStatement statement, Doctor obj) throws Exception {
        try {
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setDate(3, Date.valueOf(obj.getDateOfBirth()));
            statement.setString(4, obj.getSpecialization());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
