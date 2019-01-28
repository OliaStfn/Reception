package com.stfn.dao.MySQL;

import com.stfn.beans.PersonalFile;
import com.stfn.dao.AbstractDao;

import java.sql.Connection;

public class PersonalFileDao extends AbstractDao<PersonalFile> {
    public PersonalFileDao(Connection connection) {
        super(connection);
    }
}
