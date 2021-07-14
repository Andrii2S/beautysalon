package com.andriiskachko.finalproject.beautysalon.controller.filters;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding(DEFAULT_ENCODING);
        servletRequest.setCharacterEncoding(DEFAULT_ENCODING);

        filterChain.doFilter(servletRequest, servletResponse);
    }

}