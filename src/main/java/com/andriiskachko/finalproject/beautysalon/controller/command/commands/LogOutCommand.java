package com.andriiskachko.finalproject.beautysalon.controller.command.commands;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;

public class LogOutCommand implements Command {
    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = (String) request.getSession().getAttribute(LANGUAGE);
        request.getSession().invalidate();
        Map<String, Object> map = new HashMap<>();
        map.put(REDIRECT,INDEX_PAGE);
        request.getSession().setAttribute(LANGUAGE,lang);
        return map;
    }
}
