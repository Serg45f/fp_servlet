package com.sgsavch.controller.Command.UserCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.controller.Command.CommandUtility;
import com.sgsavch.model.entity.User;
import com.sgsavch.utils.BCrypt;
import com.sgsavch.model.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    UserService userService;

    public LoginCommand(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        if( name == null || name.equals("") || pass == null || pass.equals("")  ){
            return "/login.jsp";
        }
        if(CommandUtility.checkUserIsLogged(request, name)){
            return "/WEB-INF/error.jsp";
        }
        System.out.println("(loginCommand)name+pass: " + name + " " + pass);
        User user = userService.getUserByUsername(name);
        User userAuth = null;
        String message;
        if(BCrypt.checkpw(pass,user.getPassword())) {
            user.setRoles(userService.getUserRoles(user.getId()));
            userAuth = user;
            CommandUtility.setUserRole(request, userAuth.getRoles(), userAuth.getEmail(),userAuth.getId());
            message = "Welcome, " + userAuth.getFirstName() + "! You have successfully logged in!";
        }else{
            message = userAuth.getFirstName() + "! Your password incorrect! Try again.";
        }
        request.setAttribute("message", message);

        return "/login.jsp";
    }

}
