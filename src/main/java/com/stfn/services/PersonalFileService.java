package com.stfn.services;

import com.stfn.beans.Person;
import com.stfn.beans.PersonalFile;
import com.stfn.dao.GenericDao;
import com.stfn.dao.MySQL.Factory;
import com.stfn.dao.MySQL.PersonalFileDao;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class PersonalFileService {
    private GenericDao<PersonalFile> personalFileDao;

    public PersonalFileService() {
        Factory factory = new Factory();
        personalFileDao = (PersonalFileDao) factory.getDao(PersonalFile.class);
    }

    public PersonalFile searchById(int id) {
        try {
            return personalFileDao.read(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PersonalFile searchByFullName(String name, String surname) {
        try {
            for (PersonalFile personalFile : personalFileDao.readAll()) {
                if (name.equals(personalFile.getPerson().getFirstName())
                        && surname.equals(personalFile.getPerson().getLastName())) {
                    return personalFile;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public PersonalFile searchByPhone(String phoneNumb) {
        try {
            for (PersonalFile personalFile : personalFileDao.readAll()) {
                if (personalFile.getPhoneNumb().contains(phoneNumb)) {
                    return personalFile;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public void addPersonalFile(String name, String surname, LocalDate bornDate, String phoneNumber) {
        Person person = new Person(name, surname, bornDate);
        PersonalFile personalFile = new PersonalFile(phoneNumber, person);
        try {
            personalFileDao.create(personalFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteById(int id) {
        try {
            personalFileDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteByPhone(String phoneNumb) {
        try {
            personalFileDao.delete(searchByPhone(phoneNumb).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePersonalFile(PersonalFile personalFile) {
        try{
            personalFileDao.update(personalFile);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
