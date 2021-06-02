package com.sgsavch.controller.сommand.usercommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.service.UserService;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserSaveCommand implements Command {

    UserService userService;

    public UserSaveCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request)  {
        User user = userService.getUser(Long.valueOf(request.getParameter("userId")));
        String [] roleIds =  request.getParameterValues("checkedRoles");
        Set<Role> newRoles = new HashSet<>();
        for(String s:roleIds) {
            newRoles.add(Role.valueOf(s));
            System.out.println(s);
        }
        user = new User.Builder(user)
                .setEmail(request.getParameter("email"))
                .setFirstName(request.getParameter("firstName"))
                .setLastName(request.getParameter("lastName"))
                .build();
//        if(user.getRoles()!=null && !user.getRoles().isEmpty()) {
//            user.getRoles().clear();
//        }
        user = new User.Builder(user).setRoles(newRoles).build();
        System.out.println(user);
        userService.update(user);

        Command command = CommandContainer.get("users");
        String page = null;
        try {
            page = command.execute(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return page;
    }
}
