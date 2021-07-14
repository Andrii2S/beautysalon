package com.andriiskachko.finalproject.beautysalon.model.dao;

import com.andriiskachko.finalproject.beautysalon.model.entity.User;

public interface UserDao {
    User getUserById(long id);
    User getUser(String email, String password);
    boolean isEmailAvailable(String email);
    boolean addUser(String email, String password, String name, String phone);
}
