package com.sgsavch.controller.filters;

import com.sgsavch.model.entity.enums.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;
import java.util.function.IntPredicate;

public class AuthFilter implements Filter {
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

       while(req.getAttributeNames().hasMoreElements()){ System.out.println(req.getAttributeNames().nextElement());}

        System.out.println();
        System.out.println("(AuthFilter)req.Method: " + req.getMethod());
        System.out.println("(AuthFilter)req.AuthType: " + req.getAuthType());
        System.out.println("(AuthFilter)req.URl: " + req.getRequestURL().toString());
        System.out.println("(AuthFilter)session: " + session);
        System.out.println("(AuthFilter)session.loggedUsers: " + context.getAttribute("loggedUsers"));
        System.out.print("(AuthFilter)session ROLES: ");
        if(session.getAttribute("loggedUserRoles")!=null) {
            for (Role role : (Set<Role>) session.getAttribute("loggedUserRoles")) {
                System.out.print(", " + role);
            }
        }
        System.out.println();
        System.out.println("(AuthFilter)servletContext LoggedUsers: " + context.getAttribute("loggedUsers"));



        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
