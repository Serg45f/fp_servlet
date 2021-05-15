package com.sgsavch.controller.Command.UserCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.Theme;
import com.sgsavch.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class UserEditCommand implements Command {


    public UserEditCommand(UserService userService) {
        this.userService = userService;
    }

    UserService userService;

    public UserEditCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        User user = userService.getUser(id);
        user.setRoles(userService.getUserRoles(user.getId()));
        request.setAttribute("user", user);
        request.setAttribute("roles" , Arrays.asList(Role.values()));
        return "/userEdit.jsp";
    }
}
