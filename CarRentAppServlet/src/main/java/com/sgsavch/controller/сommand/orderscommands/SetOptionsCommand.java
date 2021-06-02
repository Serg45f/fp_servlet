package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.Location;
import com.sgsavch.model.service.OptionService;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class SetOptionsCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("currentOrder");
        order= new Order.Builder(order).setVehicle(new VehicleService().getVehicleById(Long.valueOf(request.getParameter("vehicleId")))).build();
        session.setAttribute("currentOrder", order);
        session.setAttribute("orderStage",3);

        Command command = CommandContainer.get("options");
        String page = command.execute(request);
        return page;
    }
}
