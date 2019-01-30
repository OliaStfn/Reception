package com.stfn.dao;

import com.stfn.beans.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;

public abstract class AbstractDao<T> implements GenericDao<T> {
    protected Connection connection;

    public AbstractDao(Connection connection) {
        this.connection = connection;
    }

    public abstract String getCreateQuery();

    public abstract String getSelectQuery();

    public abstract String getSelectAllQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    public abstract Collection<T> parseResultSet(ResultSet resultSet) throws Exception;

    public abstract void statementUpdate(PreparedStatement statement, T obj) throws Exception;

    public abstract void statementInsert(PreparedStatement statement, T obj) throws Exception;


    @Override
    public T create(T obj) throws Exception {
        T tempObj = null;
        String query = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statementInsert(statement, obj);
            int changedFields = statement.executeUpdate();
            if (changedFields != 1) {
                throw new Exception("More then 1 object: " + changedFields);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        query = getSelectQuery() + "(SELECT last_insert_id();)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            Collection<T> list = parseResultSet(resultSet);
            if (list == null || list.size() != 1) {
                throw new Exception("Error on searching last object");
            }
            tempObj = list.iterator().next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempObj;
    }

    @Override
    public T read(int id) throws Exception {
        Collection<T> list = null;
        String query = getSelectQuery() + id + ";";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null || list.size() == 0) {
            return null;
        }
        if (list.size() > 1) {
            throw new Exception("More than 1 object");
        }

        return list.iterator().next();
    }

    @Override
    public Collection<T> readAll() {
        Collection<T> list=null;
        String query = getSelectAllQuery();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return list;
    }


    @Override
    public void update(T obj) throws Exception {
        String query = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statementUpdate(statement, obj);
            statement.execute();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String query = getDeleteQuery();
        try (PreparedStatement statement=connection.prepareStatement(query)){
            statement.setInt(1,id);
            statement.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
