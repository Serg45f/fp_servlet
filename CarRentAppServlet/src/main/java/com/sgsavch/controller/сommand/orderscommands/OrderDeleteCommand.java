package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class OrderDeleteCommand implements Command {

    private static final Logger log = Logger.getLogger(OrderDeleteCommand.class);

    public OrderDeleteCommand(CarModelService carModelService) {
        this.orderService = orderService;
    }

    OrderService orderService;

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long id = Long.valueOf(request.getParameter("orderId"));
        orderService.deleteOrder(id);

        return Path.COMMAND__ORDERS;
    }
}
