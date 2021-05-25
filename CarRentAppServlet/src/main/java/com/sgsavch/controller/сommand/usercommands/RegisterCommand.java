package com.sgsavch.controller.сommand.usercommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusUser;
import com.sgsavch.utils.BCrypt;
import com.sgsavch.utils.MailSender;
import com.sgsavch.model.service.UserService;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class RegisterCommand implements Command {

    UserService userService;

    public RegisterCommand(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("(RegisterCommand.execute");
        User user = new User();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("email");
        String pass = request.getParameter("password");

        if( userName == null || userName.equals("") || pass == null || pass.equals("") ||
        lastName == null || lastName.equals("") || firstName == null || firstName.equals("")){
            //System.out.println("Not");
            return "/registration.jsp";
        }
//        if(CommandUtility.checkUserIsRegistered(name,pass)){

//            return "/WEB-INF/error.jsp";
//        }



        user.setEmail(userName);
        user.setPassword(BCrypt.hashpw(pass,BCrypt.gensalt()));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setStatus(StatusUser.CANDIDATE);
        user.getRoles().add(Role.UNCONFIRMED);
        user.setActivationCode(UUID.randomUUID().toString());

        Long res = userService.create(user);
        user.setId(res);
        userService.setUserRoles(user,user.getRoles());

        if(!StringUtils.isEmpty(user.getEmail())){
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to ConferenceHub#1!" +
                            "Please, visit next link: http://localhost:8888/carrent/activate?code=%s",
                    user.getEmail(),
                    user.getActivationCode()
            );
            String subject = "Registration on ConferenceHub";
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
            message="Welcome, "+ user.getFirstName() + "! Result is success!";
        }else{
            message="Result is NOT success!";
        }

        request.setAttribute("message", message);

        return "/login.jsp";
    }

}
