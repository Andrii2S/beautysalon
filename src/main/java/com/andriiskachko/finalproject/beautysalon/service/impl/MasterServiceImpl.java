package com.andriiskachko.finalproject.beautysalon.service.impl;

import com.andriiskachko.finalproject.beautysalon.model.dao.impl.MasterDaoImpl;
import com.andriiskachko.finalproject.beautysalon.model.dto.MasterDTO;
import com.andriiskachko.finalproject.beautysalon.service.MasterService;

import java.util.List;

public class MasterServiceImpl implements MasterService {
    private MasterDaoImpl masterDaoImpl = new MasterDaoImpl();

    @Override
    public List<MasterDTO> getMasters(String orderBy, String language) {
        return null;
    }

    @Override
    public List<MasterDTO> getMasterByService(String orderBy, String serviceName, String language) {
        return null;
    }
}
