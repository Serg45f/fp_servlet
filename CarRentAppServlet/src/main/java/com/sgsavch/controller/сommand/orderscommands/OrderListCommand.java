package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OrderService;
import com.sgsavch.model.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

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
        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        Long userId =  (Long) context.getAttribute("loggedUserId");
        Set<Role> userRoles =  ((Set<Role>) session.getAttribute("loggedUserRoles"));

        if(request.getParameter("tPage")!=null){
            currentPage = Integer.parseInt(request.getParameter("tPage"));
        }

        if(request.getParameter("recordsPerPage")!=null){
            recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        }

        List<Order> orders = null;
        if(userRoles.contains(Role.MANAGER)) {
                orders = orderService.getOrdersByManager(userId, currentPage, recordsPerPage);
        }
        else{
                orders = orderService.getOrders(currentPage, recordsPerPage);
            }

        int rows = orderService.getNumberOfRowsByManager(userId);
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
