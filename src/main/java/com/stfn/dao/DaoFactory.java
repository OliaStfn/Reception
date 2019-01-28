package com.stfn.dao;

import java.sql.Connection;

public interface DaoFactory {

    interface Creator {
        GenericDao createDao(Connection connection);
    }

    Connection getConnection();


    GenericDao getDao(Class bean);
}
