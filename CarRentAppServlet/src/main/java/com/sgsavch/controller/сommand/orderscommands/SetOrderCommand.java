package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Location;
import com.sgsavch.model.entity.enums.StatusOrder;
import com.sgsavch.model.service.OptionService;
import com.sgsavch.model.service.UserService;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class SetOrderCommand implements Command {
    OptionService optionService;
    UserService userService;

    public  SetOrderCommand(OptionService optionService, UserService userService){
        this.optionService = optionService;
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
//        Set<String> loggedUsers = (HashSet<String>) request.getSession().getServletContext()
//                .getAttribute("loggedUsers");
//        loggedUsers.stream().forEach(e-> System.out.println("loggedUsers: " + e));
//        System.out.println(context.getAttribute("loggedUsers"));
        //loggedUsers.stream().map(userName::equals).anyMatch(userName::equals);
        //User user =  userService.getUserByUsername(loggedUsers.stream().anyMatch("userName"))

        Order newOrder = (Order) session.getAttribute("currentOrder");
//        List<Option> options = optionService.getAllOptions();
//        System.out.println(request.getParameterValues("checkedOptions"));
//        String [] checkedOptionsStr = request.getParameterValues("checkedOptions");
//        Double optionsTotalPrice=0D;
//        if(checkedOptionsStr != null) {
//            List<Long> checkedOptions = Arrays.stream(checkedOptionsStr).map(e->Long.valueOf(e)).collect(Collectors.toList());
//            newOrder.getOptions().clear();
//            for (int i = 0; i < checkedOptions.size(); i++) {
//                Option option=options.get(i);
//                newOrder.getOptions().add(option);
//                optionsTotalPrice+=option.getPrice();
//            }
//        }
         newOrder = new Order.Builder(newOrder)
                //.setUser(user)
                .setDays(Period.between(newOrder.getStart().toLocalDate(),newOrder.getEnd().toLocalDate()).getDays())
                .setPricePeriod(newOrder.getDays()*newOrder.getVehicle().getCarModel().getPrice())
               // .setPriceOptions(optionsTotalPrice)
                //.setTotalPrice(newOrder.getPricePeriod()+optionsTotalPrice)
                .setStatusOrder(StatusOrder.RESERVED)
                .build();
        session.setAttribute("currentOrder",newOrder);
        session.setAttribute("orderStage",4);
        return Path.PAGE__ORDER;
    }
}
