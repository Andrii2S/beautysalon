package com.andriiskachko.finalproject.beautysalon.controller;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;
import com.andriiskachko.finalproject.beautysalon.controller.command.commands.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;


public class Controller extends HttpServlet {
    private Map<String, Command> commands;

    @Override
    public void init() {
        commands = new HashMap<>();
        commands.put(LOGIN, new LoginCommand());
        commands.put(LOGOUT, new LogOutCommand());
        commands.put(CHANGE_LANGUAGE, new ChangeLanguageCommand());
        commands.put(REGISTRATION, new RegisterCommand());
        commands.put(LIST_SERVICES, new ListServicesCommand());
        commands.put(LIST_MASTERS, new ListMastersCommand());
        commands.put(LIST_SCHEDULE, new ListScheduleCommand());
        commands.put(LOAD_SHEDULE_PAGE, new LoadSchedulePageCommand());
        commands.put(RESERVE_TIMESLOT, new ReserveTimeslotCommand());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = commands.get(request.getParameter(COMMAND));
        Map<String, Object> map = command.execute(request, response);
        if (map.containsKey(REDIRECT)) {
            response.sendRedirect(getServletContext().getContextPath() + map.getOrDefault(REDIRECT,ERROR_500_PAGE));
        } else {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }
            getServletContext().getRequestDispatcher((String) map.get(PAGE)).forward(request, response);
        }

    }

}