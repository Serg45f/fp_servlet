package com.sgsavch.controller.сommand.usercommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandUtility;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusUser;
import com.sgsavch.utils.BCrypt;
import com.sgsavch.utils.MailSender;
import com.sgsavch.model.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.UUID;

public class RegistrationCommand implements Command {
    private static final Logger log = Logger.getLogger(RegistrationCommand.class);

    UserService userService;

    public RegistrationCommand(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        System.out.println("(RegisterCommand.execute");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("email");
        String pass = request.getParameter("password");

        if( userName == null || userName.equals("") || pass == null || pass.equals("") ||
        lastName == null || lastName.equals("") || firstName == null || firstName.equals("")){

            return "/registration.jsp";
        }
        if(CommandUtility.checkUserIsRegistered(userName,pass)){

            return "/WEB-INF/error.jsp";
        }

        User user = new User.Builder()
        .setEmail(userName)
        .setPassword(BCrypt.hashpw(pass,BCrypt.gensalt()))
        .setFirstName(firstName)
        .setLastName(lastName)
        .setUserStatus(StatusUser.CANDIDATE)
        .setActivationCode(UUID.randomUUID().toString())
        .build();
        user.getRoles().add(Role.UNCONFIRMED);

        Long res = userService.create(user);
        user = new User.Builder(user).setId(res).build();
        userService.setUserRoles(user,user.getRoles());

        if(!StringUtils.isEmpty(user.getEmail())){
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to C-RENT-C!" +
                            "Please, visit next link: http://localhost:8888/carrent/controller?command=activate&code=%s",
                    user.getEmail(),
                    user.getActivationCode()
            );
            String subject = "Registration on C-RENT-C";
//
            MailSender mailSender = null;
            try {
                mailSender = new MailSender(user.getEmail(),subject,message);
                mailSender.sendMail();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }

        String message = null;

        if(res>0){
            message="Welcome, "+ user.getFirstName() + "! Result is success! Reference has been sent to Your email "+
            user.getEmail() + "To continue, please go there and click on it.";
        }else{
            message="Result is NOT success! Try again";
        }

        request.setAttribute("message", message);

        return Path.PAGE__LOGIN;
    }

}
