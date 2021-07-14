package com.andriiskachko.finalproject.beautysalon.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
    Command interface
 */

public interface Command {
    Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response);
}