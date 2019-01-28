package com.stfn.dao.MySQL;

import com.stfn.beans.Appointment;
import com.stfn.beans.Doctor;
import com.stfn.beans.PersonalFile;
import com.stfn.beans.Schedule;
import com.stfn.dao.DaoFactory;
import com.stfn.dao.GenericDao;
import lombok.extern.log4j.Log4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

@Log4j
public class Factory implements DaoFactory {
    private static final String URL = "";
    private static final String NAME = "";
    private static final String PASS = "";
    private HashMap<Class, Creator> daoCreators;
    private static String driverName = "com.mysql.jdbc.Driver";

    public Factory() {
        daoCreators = new HashMap<>();
        addDaoCreators();
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, NAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public GenericDao getDao(Class bean) {
        Creator creatorForDao = daoCreators.get(bean);
        GenericDao daoForBean = creatorForDao.createDao(getConnection());
        return daoForBean;
    }

    private void addDaoCreators() {
        daoCreators.put(Appointment.class, new Creator() {
            @Override
            public GenericDao createDao(Connection connection) {
                return new AppointmentDao(connection);
            }
        });
        daoCreators.put(Doctor.class, DoctorDao::new);
        daoCreators.put(PersonalFile.class, PersonalFileDao::new);
        daoCreators.put(Schedule.class, ScheduleDao::new);

    }
}
