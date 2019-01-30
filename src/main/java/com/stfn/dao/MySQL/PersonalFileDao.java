package com.stfn.dao.MySQL;

import com.stfn.beans.PersonalFile;
import com.stfn.dao.AbstractDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PersonalFileDao extends AbstractDao<PersonalFile> {
    public PersonalFileDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getCreateQuery() {
        return "INSERT INTO personal_file (first_name,last_name,date_of_birth,phone_number," +
                "registration_date VALUES (?,?,?,?,?);";
    }

    @Override
    public String getSelectQuery() {
        return "SELECT * FROM personal_file WHERE id=";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM personal_file;";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE doctor SET first_name=?, last_name=?,date_of_birth=?,phone_number=?," +
                "registration_date=?;";
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM personal_file WHERE id=?";
    }

    @Override
    public Collection<PersonalFile> parseResultSet(ResultSet resultSet) throws Exception {
        Collection<PersonalFile> personalFiles = new ArrayList<PersonalFile>();
        try {
            while (resultSet.next()) {
                PersonalFile temp = new PersonalFile();
                temp.setId(resultSet.getInt("id"));
                temp.setFirstName(resultSet.getString("first_name"));
                temp.setLastName(resultSet.getString("last_name"));
                temp.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());
                temp.setPhoneNumb(resultSet.getString("phone_number"));
                temp.setRegistrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime());

                personalFiles.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return personalFiles;
    }

    @Override
    public void statementUpdate(PreparedStatement statement, PersonalFile obj) throws Exception {
        try {
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setDate(3, Date.valueOf(obj.getDateOfBirth()));
            statement.setString(4, obj.getPhoneNumb());
            statement.setTimestamp(5, Timestamp.valueOf(obj.getRegistrationDate()));
            statement.setInt(6, obj.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void statementInsert(PreparedStatement statement, PersonalFile obj) throws Exception {
        try {
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setDate(3, Date.valueOf(obj.getDateOfBirth()));
            statement.setString(4, obj.getPhoneNumb());
            statement.setTimestamp(5, Timestamp.valueOf(obj.getRegistrationDate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
