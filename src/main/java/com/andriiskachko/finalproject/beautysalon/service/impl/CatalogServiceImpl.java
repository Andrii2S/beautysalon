package com.andriiskachko.finalproject.beautysalon.service.impl;

import com.andriiskachko.finalproject.beautysalon.model.dao.impl.MasterDaoImpl;
import com.andriiskachko.finalproject.beautysalon.model.dao.impl.ServiceDaoImpl;
import com.andriiskachko.finalproject.beautysalon.model.dao.impl.ScheduleDaoImpl;
import com.andriiskachko.finalproject.beautysalon.model.dto.MasterDTO;
import com.andriiskachko.finalproject.beautysalon.model.dto.ServiceDTO;
import com.andriiskachko.finalproject.beautysalon.model.dto.ScheduleDTO;
import com.andriiskachko.finalproject.beautysalon.service.CatalogService;

import java.sql.Date;
import java.util.List;

public class CatalogServiceImpl implements CatalogService {
    ServiceDaoImpl serviceDAO = new ServiceDaoImpl();
    MasterDaoImpl masterDaoImpl = new MasterDaoImpl();
    ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();

    @Override
    public List<ServiceDTO> getServices(String lang) {
        return serviceDAO.getServices(lang);
    }

    @Override
    public List<MasterDTO> getMasters(String lang) {
        return masterDaoImpl.getMasters(lang);
    }

    @Override
    public List<ScheduleDTO> getScheduleByDate(String lang, Date date) {
        return scheduleDaoImpl.getScheduleByDate(lang, date);
    }

    @Override
    public List<ScheduleDTO> getSchedule(String lang, Date date, String masterId, String serviceId) {
        return scheduleDaoImpl.getSchedule(lang, date, masterId, serviceId);
    }


}
