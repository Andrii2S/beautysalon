package com.andriiskachko.finalproject.beautysalon.service;

import com.andriiskachko.finalproject.beautysalon.service.impl.*;

public class ServiceFactory {
    private static UserService userService;
    private static MasterService masterService;
    private static AdminService adminService;
    private static CatalogService catalogService;
    private static AppointmentService appointmentService;
    private static FeedbackService feedbackService;

    static {
        userService = new UserServiceImpl();
        masterService = new MasterServiceImpl();
        adminService = new AdminServiceImpl();
        catalogService = new CatalogServiceImpl();
        appointmentService = new AppointmentServiceImpl();
        feedbackService = new FeedbackServiceImpl();
    }

    public static UserService getUserService() {
        return userService;
    }

    public static MasterService getMasterService() {
        return masterService;
    }

    public static AdminService getAdminService() {
        return adminService;
    }

    public static CatalogService getCatalogService() {
        return catalogService;
    }

    public static AppointmentService getAppointmentService() {
        return appointmentService;
    }

    public static FeedbackService getFeedbackService() {
        return feedbackService;
    }

}
