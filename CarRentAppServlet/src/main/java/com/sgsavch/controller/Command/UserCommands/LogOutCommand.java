package com.sgsavch.controller.Command.UserCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.controller.Command.CommandUtility;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        // ToDo delete разобраться пример Блинова
        /*String page = ConfigurationManager.getProperty("path.page.index");
        // уничтожение сессии
        request.getSession().invalidate();*/
        // ToDo delete current user (context & session)
        CommandUtility.deleteLoggedUser(request, (String) request.getSession().getServletContext().getAttribute("userName"));

        CommandUtility.setUserRole(request, Collections.singleton(Role.UNKNOWN), "Guest",0L);
        return "redirect:/index.jsp";
    }
}
