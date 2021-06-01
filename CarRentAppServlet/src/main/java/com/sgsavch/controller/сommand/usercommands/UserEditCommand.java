package com.sgsavch.controller.сommand.usercommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class UserEditCommand implements Command {

    UserService userService;

    public UserEditCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        User user = userService.getUser(Long.valueOf(request.getParameter("userId")));
       // user = new User.Builder().setRoles(userService.getUserRoles(user.getId())).build();
        request.setAttribute("editedUser", user);
        request.setAttribute("allRoles" , Arrays.asList(Role.values()));

        return Path.PAGE__USER_EDIT;
    }
}
