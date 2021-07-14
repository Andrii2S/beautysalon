package com.andriiskachko.finalproject.beautysalon.controller.command.commands;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;
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

public class ListServicesCommand implements Command {

    CatalogService catalogService = new CatalogServiceImpl();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        List<ServiceDTO> services = new ArrayList<>();
        String lang = "en";
        if (request.getSession().getAttribute(LANGUAGE) != null) {
            lang = (String) request.getSession().getAttribute(LANGUAGE);
        }
        services = catalogService.getServices(lang);

        map.put(PAGE, SERVICES_PAGE);
        map.put(SERVICES, services);
        return map;
    }
}
