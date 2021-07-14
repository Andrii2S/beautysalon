package com.andriiskachko.finalproject.beautysalon.controller.command.commands;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;
import com.andriiskachko.finalproject.beautysalon.model.entity.User;
import com.andriiskachko.finalproject.beautysalon.service.AppointmentService;
import com.andriiskachko.finalproject.beautysalon.service.CatalogService;
import com.andriiskachko.finalproject.beautysalon.service.ServiceFactory;
import com.andriiskachko.finalproject.beautysalon.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;

public class ReserveTimeslotCommand implements Command {

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = ServiceFactory.getUserService();
        CatalogService catalogService = ServiceFactory.getCatalogService();
        AppointmentService appointmentService = ServiceFactory.getAppointmentService();
        Map<String,Object> map = new HashMap<>();
        Long scheduleId = Long.parseLong(request.getParameter("scheduleId"));
        User user = (User) request.getSession().getAttribute(USER);

        if(appointmentService.bookSlot(user.getId(),scheduleId)){
            map.put(REDIRECT,SUCCESS_PAGE);
            map.put(MESSAGE,MESSAGE_SUCCESSFULLY_RESERVED);
        } else {
            map.put(PAGE,SCHEDULE_PAGE);
            map.put(MESSAGE,MESSAGE_SOMETHING_WENT_WRONG);
        }
        return map;
    }
}
