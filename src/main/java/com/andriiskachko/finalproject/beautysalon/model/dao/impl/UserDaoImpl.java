package com.andriiskachko.finalproject.beautysalon.model.dao.impl;

import com.andriiskachko.finalproject.beautysalon.db.PooledDataSource;
import com.andriiskachko.finalproject.beautysalon.model.dao.EntityMapper;
import com.andriiskachko.finalproject.beautysalon.model.dao.UserDao;
import com.andriiskachko.finalproject.beautysalon.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserById(long id) {
        User user = new User();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement(SQL_GET_USER_BY_ID);
            UserMapper mapper = new UserMapper();
            statement.setLong(1, id);
            rs = statement.executeQuery();
            if (rs.next()) {
                user = mapper.mapRow(rs);
            }
            rs.close();
            statement.close();
            PooledDataSource.commitAndClose(con);
        } catch (SQLException ex) {
            PooledDataSource.rollbackAndClose(con);
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public User getUser(String email, String password) {
        User user = new User();
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs;
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement(SQL_GET_USER_BY_EMAIL_PASSWORD);
            UserMapper mapper = new UserMapper();
            statement.setString(1, email);
            statement.setString(2, password);
            rs = statement.executeQuery();
            if (rs.next()) {
                user = mapper.mapRow(rs);
            }
            rs.close();
            statement.close();
            PooledDataSource.commitAndClose(con);
        } catch (SQLException ex) {
            PooledDataSource.rollbackAndClose(con);
            ex.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean isEmailAvailable(String email) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet rs;
        User user = new User();
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement(SQL_FIND_USER_BY_EMAIL);
            UserMapper mapper = new UserMapper();
            statement.setString(1, email);
            rs = statement.executeQuery();
            if (rs.next()) {
                user = mapper.mapRow(rs);
            }
            rs.close();
            statement.close();
            PooledDataSource.commitAndClose(con);
        } catch (SQLException ex) {
            PooledDataSource.rollbackAndClose(con);
            ex.printStackTrace();
        }

        return user.getId() == 0;
    }

    @Override
    public boolean addUser(String email, String password, String name, String phone) {
        boolean success;
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = PooledDataSource.getConnection();
            statement = con.prepareStatement(SQL_ADD_USER);
            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, name);
            statement.setString(4, phone);
            statement.executeUpdate();

            statement.close();
            PooledDataSource.commitAndClose(con);
            success = true;
        } catch (SQLException ex) {
            success = false;
            PooledDataSource.rollbackAndClose(con);
            ex.printStackTrace();
        }
        return success;
    }

    private class UserMapper implements EntityMapper<User> {

        @Override
        public User mapRow(ResultSet rs) {
            try {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setEmail(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setName(rs.getString(4));
                user.setPhone(rs.getString(5));
                return user;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}

