package com.andriiskachko.finalproject.beautysalon.model.dao;

import com.andriiskachko.finalproject.beautysalon.model.dto.ScheduleDTO;

import java.sql.Date;
import java.util.List;

public interface ScheduleDao {
    List<ScheduleDTO> getSchedule(String lang, Date date, String masterId, String serviceId);
    List<ScheduleDTO> getScheduleByDate(String lang, Date date);

    boolean updateUserId(Long userId, Long scheduleId);
}
