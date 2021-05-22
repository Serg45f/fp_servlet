package com.sgsavch.controller.Command.OrdersCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.Location;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

public class SetPeriodCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        Order order = new Order();
        HttpSession session = request.getSession();
        session.setAttribute("orderStage", 1);
        if(session.getAttribute("currentOrder")!=null) {
            order = (Order) session.getAttribute("currentOrder");
        }
        session.setAttribute("currentOrder", order);

        request.setAttribute("locations", Arrays.asList(Location.values()));
        request.setAttribute("order", order);

        return "/period.jsp";
    }
}
