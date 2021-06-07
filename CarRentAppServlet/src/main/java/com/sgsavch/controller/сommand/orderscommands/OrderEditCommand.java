package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.StatusOrder;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Arrays;

public class OrderEditCommand implements Command {

    OrderService orderService;

    public OrderEditCommand(OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long id = Long.valueOf(request.getParameter("orderId"));

        request.setAttribute("order", orderService.getOrder(id));
        request.setAttribute("orderStatuses" , Arrays.asList(StatusOrder.values()));

        return Path.PAGE__ORDER_EDIT;
    }
}
