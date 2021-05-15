package com.sgsavch.controller.Command;

import com.sgsavch.model.entity.User;
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

        if(userRoles.contains(roles.get("USER"))) System.out.println("(CommandUtility::setUserRole)USER");
        if(userRoles.contains(roles.get("ADMIN"))) System.out.println("(CommandUtility::setUserRole)ADMIN");
        if(userRoles.contains(roles.get("SPEAKER"))) System.out.println("(CommandUtility::setUserRole)SPEAKER");
        if(userRoles.contains(roles.get("CANDIDATE"))) System.out.println("(CommandUtility::setUserRole)CANDIDATE");
        if(userRoles.contains(roles.get("UNCONFIRMED"))) System.out.println("(CommandUtility::setUserRole)UNCONFIRMED");
        if(userRoles.contains(roles.get("UNKNOWN"))) System.out.println("(CommandUtility::setUserRole)UNKNOWN");
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
        loggedUsers.stream().forEach(e-> System.out.println("(CommandUtility::deleteLoggedUser)loggedUsers: " + e));

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
