package com.andriiskachko.finalproject.beautysalon.controller.command.commands;

import com.andriiskachko.finalproject.beautysalon.controller.command.Command;
import com.andriiskachko.finalproject.beautysalon.model.encoder.Sha256Encoder;
import com.andriiskachko.finalproject.beautysalon.model.entity.User;
import com.andriiskachko.finalproject.beautysalon.model.validator.Validator;
import com.andriiskachko.finalproject.beautysalon.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;

public class LoginCommand implements Command {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response) {
        Validator validator = new Validator();
        Map<String, Object> map = new HashMap<>();
        String email = request.getParameter(EMAIL);
        String password = request.getParameter(PASSWORD);
        if (!validator.isEmailValid(email)){
            map.put(MESSAGE,MESSAGE_EMAIL_NOT_VALID);
            map.put(PAGE,LOGIN_PAGE);
            return map;
        }
        if (!validator.isPasswordValid(password)){
            map.put(MESSAGE,MESSAGE_PASSWORD_NOT_VALID);
            map.put(PAGE,LOGIN_PAGE);
            return map;
        }

        User user = userService.login(email, Sha256Encoder.encode(password));
        if (user.getId() != 0)
        {
            map.put(REDIRECT, SUCCESS_PAGE);
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(-1);
            session.setAttribute(USER, user);
        }
        else
        {
            map.put(PAGE, LOGIN_PAGE);
            map.put(MESSAGE, MESSAGE_WRONG_LOGIN);
        }
        return map;
    }
}

