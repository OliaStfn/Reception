package com.stfn.services;

import com.stfn.beans.PersonalFile;
import com.stfn.dao.MySQL.Factory;
import com.stfn.dao.MySQL.PersonalFileDao;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonalFileService {
    private PersonalFileDao personalFileDao;

    public PersonalFileService() {
        Factory factory = new Factory();
        personalFileDao= (PersonalFileDao) factory.getDao(PersonalFile.class);
    }
}
