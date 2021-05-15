package com.sgsavch.controller.Command.UserCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Hall;
import com.sgsavch.model.entity.enums.Language;
import com.sgsavch.model.entity.enums.StatusEvent;
import com.sgsavch.model.entity.enums.Theme;
import com.sgsavch.model.service.EventService;
import com.sgsavch.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UserListCommand implements Command {
    private static final Integer DEFAULT_CURRENT_PAGE = 1;
    private static final Integer DEFAULT_RECORDS_PER_PAGE = 5;

    public UserListCommand(UserService userService) {
        this.userService = userService;
    }

    UserService userService;

    public UserListCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        int currentPage = DEFAULT_CURRENT_PAGE;
        int recordsPerPage = DEFAULT_RECORDS_PER_PAGE;

        if(request.getParameter("tPage")!=null){
            currentPage = Integer.parseInt(request.getParameter("tPage"));
        }

        if(request.getParameter("recordsPerPage")!=null){
            recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        }

        List<User> users = userService.getUsersPaginated(currentPage, recordsPerPage);
        User user = new User();

        int rows = userService.getNumberOfRaws();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        request.setAttribute("user", user);
        request.setAttribute("users" , users);

//        request.setAttribute("roleAdmin", Role.ADMIN);


        return "/userList.jsp";
    }
}