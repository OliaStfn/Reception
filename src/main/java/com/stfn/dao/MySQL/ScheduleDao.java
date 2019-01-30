package com.stfn.dao.MySQL;

import com.stfn.beans.Doctor;
import com.stfn.beans.Schedule;
import com.stfn.dao.AbstractDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        return null;
    }

    @Override
    public String getSelectAllQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return null;
    }

    @Override
    public Collection<Doctor> parseResultSet(ResultSet resultSet) throws Exception {
        return null;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, Schedule obj) throws Exception {

    }

    @Override
    public void statementInsert(PreparedStatement statement, Schedule obj) throws Exception {

    }
}
