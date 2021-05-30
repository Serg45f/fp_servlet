package com.sgsavch.controller;

import com.sgsavch.controller.filters.CommandAccessFilter;
import com.sgsavch.controller.сommand.*;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

@WebServlet("/servl")
@MultipartConfig
public class Servlet extends HttpServlet {
   //private Map<String, Command> commands = new HashMap<>();
   private static final Logger log = (Logger) LogManager.getLogger(Servlet.class);

    public void init(ServletConfig servletConfig){
        servletConfig.getServletContext()
                .setAttribute("loggedUsers", new HashSet<String>());
    }

    @SneakyThrows
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

//        log.debug("Controller starts");
//
//        // extract command name from the request
//        String commandName = request.getParameter("command");
//        log.trace("Request parameter: command --> " + commandName);
//
//        // obtain command object by its name
//        Command command = CommandContainer.get(commandName);
//        log.trace("Obtained command --> " + command);
//
//        // execute command and get forward address
//        String forward = command.execute(request);
//        log.trace("Forward address --> " + forward);
//
//        log.debug("Controller finished, now go to forward address --> " + forward);
//
//        // if the forward address is not null go to the address
//        if (forward != null) {
//            RequestDispatcher disp = request.getRequestDispatcher(forward);
//            disp.forward(request, response);
//        }

        String path = request.getRequestURI();
        path = path.replaceAll(".*/carrent/" , "");
        Command command = CommandContainer.get(path);
//        Command command = commands.getOrDefault(path ,
//                (r)->"/index.jsp");
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
