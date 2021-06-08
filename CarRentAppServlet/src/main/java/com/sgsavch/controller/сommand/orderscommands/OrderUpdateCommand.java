package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.StatusOrder;
import com.sgsavch.model.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderUpdateCommand implements Command {
    OrderService orderService;

    public OrderUpdateCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {

        LocalDateTime realEnd =  null;
        StatusOrder statusOrder =  null;
        String damageDescript =  null;
        Double damagePrice =  null;
        boolean damageIsPayed = false;
        Order order = null;
        if(request.getParameter("realEnd")!=null) {
            realEnd = LocalDateTime.parse(request.getParameter("realEnd"));
        }
        if(request.getParameter("statusOrder")!=null) {
            statusOrder = StatusOrder.valueOf(request.getParameter("statusOrder"));
        }
        if(request.getParameter("statusOrder")!=null) {
            damageDescript = request.getParameter("damageDescript");
        }
        if(request.getParameter("statusOrder")!=null) {
            damagePrice = Double.valueOf(request.getParameter("statusOrder"));
        }
        if(request.getParameter("damageIsPayed")!=null) {
            damageIsPayed = Boolean.getBoolean(request.getParameter("damageIsPayed"));
        }
        if(request.getParameter("orderId")!=null) {
            order = orderService.getOrder(Long.valueOf(request.getParameter("orderId")));
        }

        order = new Order.Builder(order)
                .setRealEnd(realEnd)
                .setStatusOrder(statusOrder)
                .setDamageDescript(damageDescript)
                .setDamagePrice(damagePrice)
                .setDamageIsPayed(damageIsPayed)
                .build();

        orderService.updateOrder(order);

        return Path.COMMAND__ORDERS;

    }
}
