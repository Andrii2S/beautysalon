package com.andriiskachko.finalproject.beautysalon.model.dao.impl;

import com.andriiskachko.finalproject.beautysalon.db.PooledDataSource;
import com.andriiskachko.finalproject.beautysalon.model.dao.ServiceDao;
import com.andriiskachko.finalproject.beautysalon.model.dto.ServiceDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;


public class ServiceDaoImpl implements ServiceDao {

    @Override
    public List<ServiceDTO> getServices(String lang){
        List<ServiceDTO> services = new ArrayList<>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement(SQL_GET_SERVICES);
            rs = statement.executeQuery();
            while (rs.next()) {
                ServiceDTO service = new ServiceDTO();
                service.setId(rs.getLong("id"));
                service.setName(rs.getString("name_" + lang));
                service.setDescription(rs.getString("description_"+ lang));
                service.setTime(rs.getLong("timeslots"));
                services.add(service);
            }
            rs.close();
            statement.close();
            PooledDataSource.commitAndClose(con);
        } catch (SQLException ex) {
            PooledDataSource.rollbackAndClose(con);
            ex.printStackTrace();
        }
        return services;
    }
}
