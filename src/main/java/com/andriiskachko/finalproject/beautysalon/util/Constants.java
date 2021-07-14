package com.andriiskachko.finalproject.beautysalon.util;

/**
 Class with project constants in order:
 -Pages
 -Command names
 -Fields
 -SQL queries
 */

public class Constants {

    public static final String PAGE = "page";
    public static final String INDEX_PAGE = "/index.jsp";
    public static final String LOGIN_PAGE = "/pages/login.jsp";
    public static final String REGISTRATION_PAGE = "/pages/registration.jsp";
    public static final String ERROR_403_PAGE = "/errors/error-403.jsp";
    public static final String ERROR_404_PAGE = "/errors/error-404.jsp";
    public static final String ERROR_500_PAGE = "/errors/error-500.jsp";
    public static final String SUCCESS_PAGE = "/pages/success.jsp";
    public static final String SERVICES_PAGE = "/pages/services.jsp";
    public static final String MASTERS_PAGE = "/pages/masters.jsp";
    public static final String SCHEDULE_PAGE = "/pages/schedule.jsp";
    
    /**
     * Commands
     */

    public static final String COMMAND = "command";
    public static final String LOGIN = "login";
    public static final String LOGOUT = "logout";
    public static final String CHANGE_LANGUAGE = "changeLanguage";
    public static final String REGISTRATION = "registration";
    public static final String LIST_SERVICES = "listServices";
    public static final String LIST_MASTERS = "listMasters";
    public static final String LIST_SCHEDULE = "listSchedule";
    public static final String LOAD_SHEDULE_PAGE = "loadSchedule";
    public static final String RESERVE_TIMESLOT = "bookAppointment";

    /**
     * Fields
     */

    public static final String USER = "user";
    public static final String MASTER = "master";
    public static final String ADMIN = "admin";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String PHONE = "phone";
    public static final String NAME = "name";
    public static final String LANGUAGE = "language";
    public static final String REDIRECT = "redirect";

    public static final String SERVICES = "services";
    public static final String MASTERS = "masters";
    public static final String SCHEDULE = "schedule";

    /**
     * SQL scripts
     */

    public static final String SQL_GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
    public static final String SQL_GET_USER_BY_EMAIL_PASSWORD = "SELECT * FROM users WHERE email = ? AND password = ?;";
    public static final String SQL_FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?;";
    public static final String SQL_ADD_USER = "INSERT INTO users (email, password, name, phone) VALUES (?,?,?,?);";
    public static final String SQL_GET_SERVICES = "SELECT * FROM services WHERE availability = true ";
    public static final String SQL_GET_MASTERS = "SELECT * FROM masters";
    public static final String SQL_GET_SCHEDULE_BY_DATE = "SELECT * FROM schedule JOIN services s on schedule.service_id = s.id JOIN masters m on schedule.master_id = m.id WHERE date = ? AND user_id IS NULL ORDER BY timeslot";
    public static final String SQL_TEST = "SELECT * FROM schedule JOIN services s on schedule.service_id = s.id JOIN masters m on schedule.master_id = m.id WHERE date = ? AND user_id IS NULL AND master_id = ? AND service_id = ? ORDER BY timeslot";
    public static final String SQL_GET_FILTERED_SCHEDULE = "SELECT * FROM schedule " +
            "JOIN services s on schedule.service_id = s.id " +
            "JOIN masters m on schedule.master_id = m.id WHERE date = ? AND user_id IS NULL " +
            "AND master_id = ? AND service_id = ? ORDER BY timeslot";

    /**
     * MESSAGES
     */

    public static final String MESSAGE = "message";
    public static final String MESSAGE_EMAIL_IN_USE = "message.this_email_in_use";
    public static final String MESSAGE_WRONG_LOGIN = "message.wrong_email_or_password";
    public static final String MESSAGE_EMAIL_NOT_VALID = "message.email_not_valid";
    public static final String MESSAGE_PASSWORD_NOT_VALID = "message.password_not_valid";
    public static final String MESSAGE_NAME_NOT_VALID = "message.name_not_valid";
    public static final String MESSAGE_PHONE_NOT_VALID = "message.phone_not_valid";
    public static final String MESSAGE_NOTHING_FOUND = "message.nothing_found";
    public static final String MESSAGE_SUCCESSFULLY_RESERVED = "message.successfully_reserved";
    public static final String MESSAGE_SOMETHING_WENT_WRONG = "message.something_went_wrong";
}
