package com.andriiskachko.finalproject.beautysalon.service.impl;

import com.andriiskachko.finalproject.beautysalon.model.dao.impl.UserDaoImpl;
import com.andriiskachko.finalproject.beautysalon.model.entity.User;
import com.andriiskachko.finalproject.beautysalon.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDAO = new UserDaoImpl();

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }


    @Override
    public User login(String email, String password) {
        return userDAO.getUser(email,password);
    }

    @Override
    public boolean isEmailAvailable(String email) {
        return userDAO.isEmailAvailable(email);
    }

    @Override
    public boolean addUser(String email, String password, String name, String phone) {
        return userDAO.addUser(email, password, name, phone);
    }

}
