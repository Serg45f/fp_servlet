package com.sgsavch.controller.сommand.usercommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class ActivatedCommand implements Command {
    UserService userService;

    public ActivatedCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        String code = request.getParameter("code");
        boolean isActivated = userService.activateUser(code);
        if (isActivated) {
            request.setAttribute("message", "Congratulations, user successfully activated!");
        } else {
            request.setAttribute("message", "Sorry, but activation code has not found");
        }
        return Path.PAGE__LOGIN;
    }
}

