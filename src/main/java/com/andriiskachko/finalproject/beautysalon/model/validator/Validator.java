package com.andriiskachko.finalproject.beautysalon.model.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean isPasswordValid(String pass) {
        if (pass == null || pass.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[а-яА-Я\\wіІїЇ@#$%^&+=]{6,64}$");
        Matcher matcher = pattern.matcher(pass);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    public boolean isNameValid(String name){
        if (name == null || name.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[A-Za-zА-ЯІЇа-яії ]{3,20}$");
        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    public boolean isPhoneNumberValid (String phone){
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[+][0-9]{10,13}$");
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }

    public boolean isEmailValid (String email){
        if (email == null || email.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^.{3,25}@.{3,25}$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
}