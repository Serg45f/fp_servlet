package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class OrderSaveCommand implements Command {

    OrderService orderService;

    public OrderSaveCommand(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("currentOrder");

        Long res = orderService.newOrder(order);
        order = new Order.Builder(order).setId(res).build();
        if(!order.getOptions().isEmpty())orderService.setOrderOptions(order,order.getOptions());


        order= new Order.Builder(order).setId(res).build();
        session.setAttribute("currentOrder", order);
        return Path.COMMAND__INVOICE;
    }
}
