package com.andriiskachko.finalproject.beautysalon.model.dao.impl;

import com.andriiskachko.finalproject.beautysalon.db.PooledDataSource;
import com.andriiskachko.finalproject.beautysalon.model.dao.ScheduleDao;
import com.andriiskachko.finalproject.beautysalon.model.dto.ScheduleDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;

public class ScheduleDaoImpl implements ScheduleDao {


    @Override
    public List<ScheduleDTO> getSchedule(String lang, Date date,String masterId,String serviceId)
    {
        List<ScheduleDTO> schedule = new ArrayList<>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement(SQL_GET_FILTERED_SCHEDULE);
            statement.setDate(1,date);
            statement.setInt(2, Integer.parseInt(masterId));
            statement.setInt(3, Integer.parseInt(serviceId));
            rs = statement.executeQuery();
            while (rs.next()){
                ScheduleDTO scheduleItem = new ScheduleDTO();
                scheduleItem.setId(rs.getLong("id"));
                scheduleItem.setMasterName(rs.getString("master_" + lang));
                scheduleItem.setServiceName(rs.getString("name_" + lang));
                scheduleItem.setTime(rs.getString("timeslot"));
                schedule.add(scheduleItem);
            }
        } catch (SQLException e)
        {
            PooledDataSource.rollbackAndClose(con);
            e.printStackTrace();
        }
        return schedule;
    }

    @Override
    public List<ScheduleDTO> getScheduleByDate(String lang, Date date){
        List<ScheduleDTO> schedule = new ArrayList<>();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement(SQL_GET_SCHEDULE_BY_DATE);
            statement.setDate(1,date);
            rs = statement.executeQuery();
            while (rs.next()) {
                ScheduleDTO scheduleItem = new ScheduleDTO();
                scheduleItem.setId(rs.getLong("id"));
                scheduleItem.setMasterName(rs.getString("master_" + lang));
                scheduleItem.setServiceName(rs.getString("name_" + lang));
                scheduleItem.setTime(rs.getString("timeslot"));
                schedule.add(scheduleItem);
            }
            rs.close();
            statement.close();
            PooledDataSource.commitAndClose(con);
        } catch (SQLException ex) {
            PooledDataSource.rollbackAndClose(con);
            ex.printStackTrace();
        }
        return schedule;
    }

    public boolean updateUserId (Long userId,Long scheduleId){
        Connection con = null;
        PreparedStatement statement = null;
        int result;
        boolean success = false;
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement("UPDATE schedule SET user_id = ? WHERE id = ? AND user_id IS NULL");
            statement.setLong(1,userId);
            statement.setLong(2,scheduleId);
            result = statement.executeUpdate();
            if(result>=1){
                success = true;
            }
            statement.close();
            PooledDataSource.commitAndClose(con);
        } catch (SQLException ex) {
            PooledDataSource.rollbackAndClose(con);
            ex.printStackTrace();
        }
        return success;
    }
}
