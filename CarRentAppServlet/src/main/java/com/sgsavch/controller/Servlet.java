package com.sgsavch.controller;

import com.sgsavch.controller.Command.*;
import com.sgsavch.controller.Command.CarModelCommands.*;
import com.sgsavch.controller.Command.EventCommands.EventCommand;
import com.sgsavch.controller.Command.EventCommands.EventListCommand;
import com.sgsavch.controller.Command.OptionsCommands.OptionListCommand;
import com.sgsavch.controller.Command.OrdersCommands.SetPeriodCommand;
import com.sgsavch.controller.Command.UserCommands.*;
import com.sgsavch.controller.Command.VehiclesCommands.VehicleAddCommand;
import com.sgsavch.controller.Command.VehiclesCommands.VehicleDeleteCommand;
import com.sgsavch.controller.Command.VehiclesCommands.VehicleEditCommand;
import com.sgsavch.controller.Command.VehiclesCommands.VehicleListCommand;
import com.sgsavch.model.service.*;
import lombok.SneakyThrows;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
        commands.put("event", new EventCommand(new EventService()));
        commands.put("users", new UserListCommand(new UserService()));
        //TODO: ERROR formatexception "USER"
        commands.put("user_edit", new UserEditCommand(new UserService()));
        //TODO user_delet
        //commands.put("user_delete", new UserDeleteCommand(new UserService()));
        //TODO setPeriod
        commands.put("setPeriod", new SetPeriodCommand());
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
        commands.put("carModels", new CarModelListCommand(new CarModelService()));
        commands.put("carModel_add", new CarModelAddCommand(new CarModelService()));
        commands.put("carModel_edit", new CarModelEditCommand(new CarModelService()));
        commands.put("carModel_delete", new CarModelDeleteCommand(new CarModelService()));
        commands.put("carModel_save", new CarModelSaveCommand(new CarModelService()));
        commands.put("vehicles", new VehicleListCommand(new VehicleService()));
        commands.put("vehicle_add", new VehicleAddCommand(new CarModelService(), new UserService()));
        commands.put("vehicle_edit", new VehicleEditCommand(new VehicleService(), new CarModelService(), new UserService()));
        commands.put("vehicle_delete", new VehicleDeleteCommand(new VehicleService()));
    }

    @SneakyThrows
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
        //response.getWriter().print("Hello from servlet");
    }

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }



    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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
