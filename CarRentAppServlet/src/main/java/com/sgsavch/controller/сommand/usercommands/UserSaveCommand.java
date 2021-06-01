package com.sgsavch.controller.сommand.usercommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class UserSaveCommand implements Command {

    UserService userService;

    public UserSaveCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, SQLException, IOException {

        //User user = new User.Builder().build();

        List<User> users = userService.getAllUsers();
       // user = new User.Builder().setRoles(userService.getUserRoles(user.getId())).build();
        request.setAttribute("users", users);

        Command command = CommandContainer.get("users");
        String page = command.execute(request);

        return page;
    }
}
