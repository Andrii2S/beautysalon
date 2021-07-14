package com.andriiskachko.finalproject.beautysalon.model.dao.impl;

import com.andriiskachko.finalproject.beautysalon.db.PooledDataSource;
import com.andriiskachko.finalproject.beautysalon.model.dao.EntityMapper;
import com.andriiskachko.finalproject.beautysalon.model.dao.MasterDao;
import com.andriiskachko.finalproject.beautysalon.model.dto.MasterDTO;
import com.andriiskachko.finalproject.beautysalon.model.entity.Master;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.SQL_GET_MASTERS;


public class MasterDaoImpl implements MasterDao {

    public List<MasterDTO> getMasters(String lang){
        List<MasterDTO> masters = new ArrayList<>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement(SQL_GET_MASTERS);
            rs = statement.executeQuery();
            while (rs.next()) {
                MasterDTO master = new MasterDTO();
                master.setId(rs.getLong("id"));
                master.setName(rs.getString("master_" + lang));
                master.setInformation(rs.getString("information_"+ lang));
                master.setRating(rs.getDouble("rating"));
                masters.add(master);
            }
            rs.close();
            statement.close();
            PooledDataSource.commitAndClose(con);
        } catch (SQLException ex) {
            PooledDataSource.rollbackAndClose(con);
            ex.printStackTrace();
        }
        return masters;
    }

    private class UserMapper implements EntityMapper<Master> {

        @Override
        public Master mapRow(ResultSet rs) {
            try {
                Master master = new Master();
                master.setId(rs.getLong(1));
                master.setLogin(rs.getString(2));
                master.setPassword(rs.getString(3));
                master.setNameEn(rs.getString(4));
                master.setNameUa(rs.getString(5));
                master.setInformationEn(rs.getString(6));
                master.setInformationUa(rs.getString(7));
                master.setRating(rs.getDouble(8));
                return master;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
