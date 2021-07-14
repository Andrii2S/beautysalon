package com.andriiskachko.finalproject.beautysalon.controller.command.commands;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;
import com.andriiskachko.finalproject.beautysalon.model.dto.MasterDTO;
import com.andriiskachko.finalproject.beautysalon.model.dto.ServiceDTO;
import com.andriiskachko.finalproject.beautysalon.service.CatalogService;
import com.andriiskachko.finalproject.beautysalon.service.impl.CatalogServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;
import static com.andriiskachko.finalproject.beautysalon.util.Constants.SERVICES;

public class ListMastersCommand implements Command {

    CatalogService catalogService = new CatalogServiceImpl();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        List<MasterDTO> masters = new ArrayList<>();
        String lang = "en";
        if (request.getSession().getAttribute(LANGUAGE) != null) {
            lang = (String) request.getSession().getAttribute(LANGUAGE);
        }
        masters = catalogService.getMasters(lang);
        map.put(PAGE, MASTERS_PAGE);
        map.put(MASTERS, masters);
        return map;
    }
}
