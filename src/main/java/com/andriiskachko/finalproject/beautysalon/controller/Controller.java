package com.andriiskachko.finalproject.beautysalon.controller;

import java.io.*;
import javax.servlet.http.*;

public class Controller extends HttpServlet {
    private String message;

@Override
    public void init() {
        message = "Hello !";
    }

@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

}