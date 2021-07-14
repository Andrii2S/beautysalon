package com.andriiskachko.finalproject.beautysalon.controller.command.commands;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;


public class ChangeLanguageCommand implements Command {

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter(LANGUAGE);
        request.getSession().setAttribute(LANGUAGE, language);
        Map<String, Object> map = new HashMap<>();
        map.put(REDIRECT,INDEX_PAGE);
        System.out.println("Language set to " + language);
        return map;
    }
}

