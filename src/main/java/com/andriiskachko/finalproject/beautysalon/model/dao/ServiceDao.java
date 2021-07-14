package com.andriiskachko.finalproject.beautysalon.model.dao;

import com.andriiskachko.finalproject.beautysalon.model.dto.ServiceDTO;

import java.util.List;

public interface ServiceDao {
    List<ServiceDTO> getServices(String lang);
}
