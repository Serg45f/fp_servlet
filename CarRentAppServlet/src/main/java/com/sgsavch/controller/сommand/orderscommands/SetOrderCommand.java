package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Location;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

public class SetOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Order newOrder = (Order) session.getAttribute("currentOrder");
        User user = (User) session.getAttribute("currentUser");
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = userService.findUserByEmail(userDetails.getUsername());
//      List<Option> options = (List<Option>)session.getAttribute("options");
        System.out.println(request.getParameter("checkedOptions"));

//        Double optionsTotalPrice=0D;
//        if(checkedOptions != null) {
//            newOrder.getOptions().clear();
//            for (int i = 0; i < checkedOptions.length; i++) {
//                Option option=options.get(i);
//                newOrder.getOptions().add(option);
//                optionsTotalPrice+=option.getPrice();
//            }
//        }
        newOrder.setUser(user);
        newOrder.setDays(Period.between(newOrder.getStart().toLocalDate(),newOrder.getEnd().toLocalDate()).getDays());
        newOrder.setPricePeriod(newOrder.getDays()*newOrder.getVehicle().getCarModel().getPrice());
        //newOrder.setPriceOptions(optionsTotalPrice);
        //newOrder.setTotalPrice(newOrder.getPricePeriod()+optionsTotalPrice);
        //newOrder.setStatus(StatusOrder.RESERVED);
        session.setAttribute("currentOrder",newOrder);
        session.setAttribute("orderStage",4);
        return "/order.jsp";
    }
}
