package com.sgsavch.controller.filters;

import com.sgsavch.controller.Servlet;
import com.sgsavch.model.entity.enums.Role;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;
import java.util.function.IntPredicate;

public class AuthFilter implements Filter {
    private static final Logger log = Logger.getLogger(AuthFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        ServletContext context = request.getServletContext();

        if(session.getAttribute("loggedUserRoles")!=null) {
            for (Role role : (Set<Role>) session.getAttribute("loggedUserRoles")) {
            }
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
