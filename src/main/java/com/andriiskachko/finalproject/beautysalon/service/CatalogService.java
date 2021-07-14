package com.andriiskachko.finalproject.beautysalon.service;

import com.andriiskachko.finalproject.beautysalon.model.dto.MasterDTO;
import com.andriiskachko.finalproject.beautysalon.model.dto.ServiceDTO;
import com.andriiskachko.finalproject.beautysalon.model.dto.ScheduleDTO;

import java.sql.Date;
import java.util.List;

public interface CatalogService {
    List<ServiceDTO> getServices (String lang);
    List<MasterDTO> getMasters (String lang);
    List<ScheduleDTO> getScheduleByDate (String lang, Date date);
    List<ScheduleDTO> getSchedule(String lang,Date date,String masterId,String serviceId);
}
