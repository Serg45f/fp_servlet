package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.Location;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class SetPeriodCommand implements Command {
    private static final Logger log = Logger.getLogger(SetPeriodCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        Order order = new Order.Builder().build();
        HttpSession session = request.getSession();
        if((Integer) session.getAttribute("orderStage")==0)session.setAttribute("orderStage", 1);
        if(session.getAttribute("currentOrder")!=null) {
            order = (Order) session.getAttribute("currentOrder");
        }
        session.setAttribute("currentOrder", order);

        request.setAttribute("locations", Arrays.asList(Location.values()));
        request.setAttribute("order", order);

        return Path.PAGE__PERIOD;
    }
}
