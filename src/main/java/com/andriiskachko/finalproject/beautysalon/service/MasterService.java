package com.andriiskachko.finalproject.beautysalon.service;

import com.andriiskachko.finalproject.beautysalon.model.dto.MasterDTO;

import java.util.List;

public interface MasterService {
    List<MasterDTO> getMasters(String orderBy,String language);
    List<MasterDTO> getMasterByService(String orderBy,String serviceName,String language);



}
