package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusOrder;
import com.sgsavch.model.service.OptionService;
import com.sgsavch.model.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.Period;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetOrderCommand implements Command {
    private static final Logger log = Logger.getLogger(SetOrderCommand.class);

    UserService userService;

    public  SetOrderCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        User user =  userService.getUserByUsername((String) context.getAttribute("loggedUserName"));

        Order newOrder = (Order) session.getAttribute("currentOrder");

         newOrder = new Order.Builder(newOrder)
                .setUser(user)
                .setDays(Period.between(newOrder.getStart().toLocalDate(),newOrder.getEnd().toLocalDate()).getDays())
                .setStatusOrder(StatusOrder.RESERVED)
                .build();
        newOrder = new Order.Builder(newOrder)
                .setPricePeriod(newOrder.getDays()*newOrder.getVehicle().getCarModel().getPrice())
                .build();
        newOrder = new Order.Builder(newOrder)
                .setTotalPrice(newOrder.getPricePeriod()+newOrder.getPriceOptions())
                .build();

        System.out.println(newOrder.toString());
        session.setAttribute("currentOrder",newOrder);

        return Path.PAGE__ORDER;
    }
}
