package com.andriiskachko.finalproject.beautysalon.controller.command.commands;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;
import com.andriiskachko.finalproject.beautysalon.model.dto.MasterDTO;
import com.andriiskachko.finalproject.beautysalon.model.dto.ServiceDTO;
import com.andriiskachko.finalproject.beautysalon.model.dto.ScheduleDTO;
import com.andriiskachko.finalproject.beautysalon.service.CatalogService;
import com.andriiskachko.finalproject.beautysalon.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;


public class ListScheduleCommand implements Command {
    CatalogService catalogService = ServiceFactory.getCatalogService();


    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        List<ScheduleDTO> schedule = new ArrayList<>();
        List<MasterDTO> masters = new ArrayList<>();
        List<ServiceDTO> services = new ArrayList<>();
        Date date;
        String dateString = request.getParameter("date");
        if(dateString.isEmpty()){
            date = Date.valueOf(LocalDate.now().toString());
        }
        else {
            date = Date.valueOf(dateString);
        }
        String mastersId = request.getParameter("masterId");
        String serviceId = request.getParameter("serviceId");
        String lang = "en";
        if (request.getSession().getAttribute(LANGUAGE) != null) {
            lang = (String) request.getSession().getAttribute(LANGUAGE);
        }
        schedule = catalogService.getSchedule(lang,date,mastersId,serviceId);
        services = catalogService.getServices(lang);
        masters = catalogService.getMasters(lang);
        if(schedule.isEmpty()){
            map.put(MESSAGE,MESSAGE_NOTHING_FOUND);
        }
        map.put(PAGE, SCHEDULE_PAGE);
        map.put(SCHEDULE, schedule);
        map.put(MASTERS,masters);
        map.put(SERVICES,services);
        return map;
    }
}
