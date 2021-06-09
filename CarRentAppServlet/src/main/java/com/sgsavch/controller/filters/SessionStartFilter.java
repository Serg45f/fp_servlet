package com.sgsavch.controller.filters;

import com.sgsavch.controller.Servlet;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class SessionStartFilter implements Filter {
    private static final Logger log = Logger.getLogger(SessionStartFilter.class);

    public void init(FilterConfig arg0) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        if (req.getSession().getAttribute("orderStage") == null) {
            req.getSession().setAttribute("orderStage", 0);
        }
        chain.doFilter(request, response);
    }

    public void destroy() {}
}
