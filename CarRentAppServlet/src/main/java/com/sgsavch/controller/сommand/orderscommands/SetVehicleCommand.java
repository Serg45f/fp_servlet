package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.Location;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Arrays;

public class SetVehicleCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {
        Order order = new Order();
        order.setLocation(Location.valueOf(request.getParameter("location")));
        order.setStart(LocalDateTime.parse(request.getParameter("start")));
        order.setEnd(LocalDateTime.parse(request.getParameter("end")));
        HttpSession session = request.getSession();
        session.setAttribute("currentOrder", order);
        session.setAttribute("orderStage",2);
        Command command = CommandContainer.get("vehicles");
        String page = command.execute(request);
        return page;
    }
}
