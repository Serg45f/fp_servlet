package com.sgsavch.controller.сommand.usercommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandUtility;
import com.sgsavch.model.entity.enums.Role;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public class LogOutCommand implements Command {
    private static final Logger log = Logger.getLogger(LogOutCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        request.getSession().invalidate();

        CommandUtility.deleteLoggedUser(request, (String) request.getSession().getServletContext().getAttribute("loggedUserName"));

        CommandUtility.setUserRole(request, Collections.singleton(Role.UNKNOWN), "Guest",0L);
        return Path.PAGE__LOGIN;
    }
}
