package com.sgsavch.controller.сommand;

import com.sgsavch.model.entity.enums.Role;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class CommandUtility {
    public static void setUserRole(HttpServletRequest request,
                            Set<Role> userRoles, String userName, Long userId) {
        Map<String,Role> roles = new HashMap<>();
        for(Role role:Role.values()) {
            roles.put(role.getRole(),role);
        }

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();

        context.setAttribute("loggedUserName", userName);
        context.setAttribute("loggedUserId", userId);
        session.setAttribute("loggedUserRoles", userRoles);
        session.setAttribute("roles", roles);
    }

    public static boolean checkUserIsLogged(HttpServletRequest request, String userName){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if(loggedUsers.stream().anyMatch(userName::equals)){
            return true;
        }
        loggedUsers.add(userName);
        request.getSession().getServletContext()
                .setAttribute("loggedUsers", loggedUsers);
        return false;
    }

    public static boolean deleteLoggedUser(HttpServletRequest request, String userName){
        HashSet<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
                .getAttribute("loggedUsers");

        if(loggedUsers.stream().anyMatch(userName::equals)){
            loggedUsers.remove(userName);
            request.getSession().getServletContext()
                    .setAttribute("loggedUsers", loggedUsers);
            return true;
        }

        return false;
    }

    public static boolean checkUserIsRegistered(String name, String pass) {
        return false;
    }
}
