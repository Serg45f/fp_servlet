package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.StatusOrder;
import com.sgsavch.model.service.OrderService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public class OrderUpdateCommand implements Command {
    private static final Logger log = Logger.getLogger(OrderUpdateCommand.class);

    OrderService orderService;

    public OrderUpdateCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {

        if(request.getParameter("orderId")==null) {
            throw new NoSuchElementException("Order Id is null");
        }
        Order order = orderService.getOrder(Long.valueOf(request.getParameter("orderId")));

        LocalDateTime realEnd =  order.getRealEnd();
        StatusOrder statusOrder =  order.getStatus();
        String damageDescript =  order.getDamageDescript();
        Double damagePrice =  order.getDamagePrice();
        boolean damageIsPayed = order.getDamageIsPayed();

        if(request.getParameter("realEnd")!=null) {
            realEnd = LocalDateTime.parse(request.getParameter("realEnd"));
            log.trace("OrderUpdate parameter --> realEnd:" + realEnd);
        }
        if(request.getParameter("statusOrder")!=null) {
            statusOrder = StatusOrder.valueOf(request.getParameter("statusOrder"));
            log.trace("OrderUpdate parameter --> statusOrder:" + statusOrder);
        }
        if(request.getParameter("damageDescript")!=null) {
            damageDescript = request.getParameter("damageDescript");
            log.trace("OrderUpdate parameter --> damageDescript:" + damageDescript);
        }
        if(request.getParameter("damagePrice")!=null) {
            damagePrice = Double.valueOf(request.getParameter("damagePrice"));
            log.trace("OrderUpdate parameter --> damagePrice:" + damagePrice);
        }

            damageIsPayed = Boolean.valueOf(request.getParameter("damageIsPayed"));
            log.trace("OrderUpdate parameter --> damageIsPayed:" + damageIsPayed);


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
