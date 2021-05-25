package com.sgsavch.controller;

import com.sgsavch.controller.сommand.*;
import lombok.SneakyThrows;

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
   // private Map<String, Command> commands = new HashMap<>();

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
