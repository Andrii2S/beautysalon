package com.andriiskachko.finalproject.beautysalon.controller.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andriiskachko.finalproject.beautysalon.util.Constants.*;


public class MasterFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute(MASTER) == null) {
            res.sendRedirect(req.getContextPath() + ERROR_403_PAGE);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
