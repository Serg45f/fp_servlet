package com.sgsavch.controller;

import com.sgsavch.controller.Command.*;
import com.sgsavch.controller.Command.EventCommands.EventCommand;
import com.sgsavch.controller.Command.EventCommands.EventListCommand;
import com.sgsavch.controller.Command.TicketCommands.TicketTableAggregateCommand;
import com.sgsavch.controller.Command.TicketCommands.TicketListCommand;
import com.sgsavch.controller.Command.UserCommands.*;
import com.sgsavch.model.service.EventService;
import com.sgsavch.model.service.LectureService;
import com.sgsavch.model.service.TicketService;
import com.sgsavch.model.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Servlet extends HttpServlet {
    private Map<String, Command> commands = new HashMap<>();

    public void init(ServletConfig servletConfig){

        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());

        commands.put("logout", new LogOutCommand());
        commands.put("login", new LoginCommand(new UserService()));
        commands.put("activate", new ActivatedCommand(new UserService()));
        commands.put("registration", new RegisterCommand(new UserService()));
        commands.put("exception" , new ExceptionCommand());
        commands.put("events", new EventListCommand(new EventService()));
//        commands.put("events/edit", new EventEditCommand(new EventService()));
//        commands.put("events/delete", new EventDeleteCommand(new EventService()));
//        commands.put("tickets/edit", new TicketEditCommand(new TicketService()));
//        commands.put("tickets/delete", new TicketDeleteCommand(new TicketService()));
        commands.put("tickets", new TicketListCommand(new TicketService()));
        commands.put("ticketsTableAggregate", new TicketTableAggregateCommand(new TicketService()));
        commands.put("users", new UserListCommand(new UserService()));
        commands.put("users/edit", new UserEditCommand(new UserService()));
//        commands.put("users/delete", new UserDeleteCommand(new UserService()));
        commands.put("event", new EventCommand(new EventService(),new TicketService(),new LectureService()));
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
        //response.getWriter().print("Hello from servlet");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }



    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getRequestURI();
        path = path.replaceAll(".*/conf/" , "");
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        System.out.println("(Servlet)command.name: " + command.getClass().getName());
        String page = command.execute(request);
        System.out.println("(Servlet)page: " + page);
        //request.getRequestDispatcher(page).forward(request,response);
        if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", "/conf"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

}
