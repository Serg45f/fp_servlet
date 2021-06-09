package com.sgsavch.controller.сommand.usercommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandUtility;
import com.sgsavch.model.entity.User;
import com.sgsavch.utils.BCrypt;
import com.sgsavch.model.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LoginCommand implements Command {
    private static final Logger log = Logger.getLogger(LoginCommand.class);

    UserService userService;

    public LoginCommand(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession();

        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            return "/WEB-INF/login.jsp";
        }
        if(CommandUtility.checkUserIsLogged(request, name)){

            return "/WEB-INF/error.jsp";
        }

        User user = userService.getUserByUsername(name);
        User userAuth = null;
        String message;

        if(BCrypt.checkpw(pass,user.getPassword()) && user != null) {
            userAuth = user;
            CommandUtility.setUserRole(request, userAuth.getRoles(), userAuth.getEmail(),userAuth.getId());
            message = "Welcome, " + userAuth.getFirstName() + "! You have successfully logged in!";
        }else{
            message = userAuth.getFirstName() + "! Your name or password incorrect! Try again or register yourself.";
        }
        request.setAttribute("message", message);

        if(session != null && session.getAttribute("orderStage") != null && (Integer )session.getAttribute("orderStage") == 4){
            return Path.COMMAND__SET_ORDER;
        }

        return Path.PAGE__LOGIN;
    }

}
