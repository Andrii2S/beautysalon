package com.andriiskachko.finalproject.beautysalon.service.impl;

import com.andriiskachko.finalproject.beautysalon.model.dao.DaoFactory;
import com.andriiskachko.finalproject.beautysalon.model.dao.ScheduleDao;
import com.andriiskachko.finalproject.beautysalon.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {

    @Override
    public boolean bookSlot(Long userId, Long scheduleId) {
        ScheduleDao scheduleDao = DaoFactory.getInstance().getScheduleDao();
        return scheduleDao.updateUserId(userId,scheduleId);
    }
}
