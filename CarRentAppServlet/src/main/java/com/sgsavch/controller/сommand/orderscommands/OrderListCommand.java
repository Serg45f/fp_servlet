package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OrderListCommand implements Command {
    private static final Integer DEFAULT_CURRENT_PAGE = 1;
    private static final Integer DEFAULT_RECORDS_PER_PAGE = 9;

    OrderService orderService;

    public OrderListCommand(OrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public String execute(HttpServletRequest request) {
        int currentPage = DEFAULT_CURRENT_PAGE;
        int recordsPerPage = DEFAULT_RECORDS_PER_PAGE;

        if(request.getParameter("tPage")!=null){
            currentPage = Integer.parseInt(request.getParameter("tPage"));
        }

        if(request.getParameter("recordsPerPage")!=null){
            recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        }

        List<Order> orders = orderService.getOrders(currentPage, recordsPerPage);

        int rows = orderService.getNumberOfCards();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("orders" , orders);

        return Path.PAGE__ORDERS;
    }
}
