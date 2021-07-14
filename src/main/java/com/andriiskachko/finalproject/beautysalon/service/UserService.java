package com.andriiskachko.finalproject.beautysalon.service;

import com.andriiskachko.finalproject.beautysalon.model.entity.User;

import java.util.Map;

public interface UserService {
    User getUserById(long id);
    User login(String email, String password);
    boolean isEmailAvailable(String email);
    boolean addUser(String email,String password,String name,String phone);
}
