package com.sgsavch.controller;

import com.sgsavch.controller.Command.*;
import com.sgsavch.controller.Command.CarModelCommands.CarModelAddCommand;
import com.sgsavch.controller.Command.CarModelCommands.CarModelDeleteCommand;
import com.sgsavch.controller.Command.CarModelCommands.CarModelEditCommand;
import com.sgsavch.controller.Command.CarModelCommands.CarModelListCommand;
import com.sgsavch.controller.Command.EventCommands.EventCommand;
import com.sgsavch.controller.Command.EventCommands.EventListCommand;
import com.sgsavch.controller.Command.UserCommands.*;
import com.sgsavch.model.service.*;

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
        commands.put("event", new EventCommand(new EventService(),new TicketService(),new LectureService()));
        commands.put("users", new UserListCommand(new UserService()));
        //TODO: ERROR formatexception "USER"
        commands.put("user_edit", new UserEditCommand(new UserService()));
        //TODO user_delet
        //commands.put("user_delete", new UserDeleteCommand(new UserService()));
        //TODO setPeriod
        //commands.put("setPeriod", new SetPeriodCommand());
        //TODO setVehicles
        //commands.put("setVehicles", new SetVehiclesCommand());
        //TODO setsetOptions
        //commands.put("setOptions", new SetOptionsCommand());
        //TODO options
        //commands.put("options", new OptionListCommand(new OptionService()));
        //TODO option_edit
        //commands.put("option_edit", new OptionCommand(new OptionService()));
        //TODO order
        //commands.put("order", new OrderCommand(new OrderService()));
        //TODO order_edit
        //commands.put("order_edit", new OrderEditCommand(new OrderService()));
        //TODO order_delete
        //commands.put("order_delete", new OrderDeleteCommand(new OrderService()));
        //TODO orders
        //commands.put("orders", new OrderListCommand(new OrderService()));
        //TODO invoice
        //commands.put("invoice", new InvoiceCommand(new InvoiceService()));
        //TODO invoiceDamage
        //commands.put("invoiceDamage", new InvoiceDamageCommand(new InvoiceService()));
        //TODO carModels
        commands.put("carModels", new CarModelListCommand(new CarModelService()));
        //TODO carModel_add
        commands.put("carModel_add", new CarModelAddCommand(new CarModelService()));
        //TODO carModel_edit
        commands.put("carModel_edit", new CarModelEditCommand(new CarModelService()));
        //TODO carModel_delete
        commands.put("carModel_delete", new CarModelDeleteCommand(new CarModelService()));
        //TODO vehicles
        //commands.put("vehicles", new VehicleListCommand(new CarmodelService()));
        //TODO vehicle_edit
        //commands.put("vehicle_edit", new VehicleEditCommand(new CarmodelService()));
        //TODO vehicle_delete
        //commands.put("vehicle_delete", new VehiclelDeleteCommand(new UserService()));
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
        path = path.replaceAll(".*/carrent/" , "");
        Command command = commands.getOrDefault(path ,
                (r)->"/index.jsp");
        System.out.println("(Servlet)command.name: " + command.getClass().getName());
        String page = command.execute(request);
        System.out.println("(Servlet)page: " + page);
        if(page.contains("redirect:")){
            response.sendRedirect(page.replace("redirect:", "/carrent"));
        }else {
            request.getRequestDispatcher(page).forward(request, response);
        }
    }

}
