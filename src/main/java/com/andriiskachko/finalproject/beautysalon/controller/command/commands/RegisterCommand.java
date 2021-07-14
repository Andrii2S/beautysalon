package com.andriiskachko.finalproject.beautysalon.controller.command.commands;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;
import com.andriiskachko.finalproject.beautysalon.model.encoder.Sha256Encoder;
import com.andriiskachko.finalproject.beautysalon.model.validator.Validator;
import com.andriiskachko.finalproject.beautysalon.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;

public class RegisterCommand implements Command {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        Validator validator = new Validator();
        String name = request.getParameter(NAME);
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        String phone = request.getParameter(PHONE);

        if (!validator.isEmailValid(email)) {
            map.put(MESSAGE, MESSAGE_EMAIL_NOT_VALID);
            map.put(PAGE, REGISTRATION_PAGE);
            return map;
        }
        if (!validator.isPasswordValid(password)) {
            map.put(MESSAGE, MESSAGE_PASSWORD_NOT_VALID);
            map.put(PAGE, REGISTRATION_PAGE);
            return map;
        }
        if (!validator.isNameValid(name)) {
            map.put(MESSAGE, MESSAGE_NAME_NOT_VALID);
            map.put(PAGE, REGISTRATION_PAGE);
            return map;
        }
        if (!validator.isPhoneNumberValid(phone)) {
            map.put(MESSAGE, MESSAGE_PHONE_NOT_VALID);
            map.put(PAGE, REGISTRATION_PAGE);
            return map;
        }

        password = Sha256Encoder.encode(password);
        boolean success = userService.addUser(email, password, name, phone);
            if (success) {
                map.put(REDIRECT, SUCCESS_PAGE);
            } else {
                map.put(MESSAGE, MESSAGE_EMAIL_IN_USE);
                map.put(PAGE, REGISTRATION_PAGE);
            }
            return map;
        }
    }
