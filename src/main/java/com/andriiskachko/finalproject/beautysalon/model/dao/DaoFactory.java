package com.andriiskachko.finalproject.beautysalon.model.dao;

import com.andriiskachko.finalproject.beautysalon.model.dao.impl.*;

public class DaoFactory {
    private static final DaoFactory DaoFactoryInstance = new DaoFactory();
    private final UserDao userDao = new UserDaoImpl();
    private final AdminDao adminDao = new AdminDaoImpl();
    private final MasterDao masterDao = new MasterDaoImpl();
    private final ScheduleDao scheduleDao = new ScheduleDaoImpl();
    private final ServiceDao serviceDao = new ServiceDaoImpl();
    private final FeedbackDao feedbackDao = new FeedbackDaoImpl();



    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryInstance;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public MasterDao getMasterDao() {
        return masterDao;
    }

    public ScheduleDao getScheduleDao() {
        return scheduleDao;
    }

    public ServiceDao getServiceDao() {
        return serviceDao;
    }

    public FeedbackDao getFeedbackDao() {
        return feedbackDao;
    }
}
