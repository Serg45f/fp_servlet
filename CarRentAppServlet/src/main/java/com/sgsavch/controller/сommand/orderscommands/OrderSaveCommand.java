package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OrderService;
import com.sgsavch.model.service.VehicleService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class OrderSaveCommand implements Command {
    private static final Logger log = Logger.getLogger(OrderSaveCommand.class);

    OrderService orderService;
    VehicleService vehicleService;

    public OrderSaveCommand(OrderService orderService, VehicleService vehicleService) {
        this.orderService = orderService;
        this.vehicleService = vehicleService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("currentOrder");

        Vehicle vehicle = order.getVehicle();
        vehicle = new Vehicle.Builder(vehicle).setIsNew(false).build();

        Long res = orderService.newOrder(order);
        vehicleService.updateVehicle(vehicle);
        order = new Order.Builder(order).setId(res).build();
        if(!order.getOptions().isEmpty())orderService.setOrderOptions(order,order.getOptions());


        order= new Order.Builder(order).setId(res).build();
        session.setAttribute("currentOrder", order);
        return Path.COMMAND__INVOICE;
    }
}
