package com.sgsavch.controller.сommand.vehiclescommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class VehicleListCommand implements Command {
    private static final Integer DEFAULT_CURRENT_PAGE = 1;
    private static final Integer DEFAULT_RECORDS_PER_PAGE = 3;

    public VehicleListCommand(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    VehicleService vehicleService;

    public VehicleListCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        int currentPage = DEFAULT_CURRENT_PAGE;
        int recordsPerPage = DEFAULT_RECORDS_PER_PAGE;

        HttpSession session = request.getSession();
        List<Vehicle> vehicles = null;

        Order order = session.getAttribute("currentOrder")!=null ? (Order) session.getAttribute("currentOrder") : new Order.Builder().build();
        LocalDateTime start  = order.getStart();
        LocalDateTime end = order.getEnd();

        if(request.getParameter("tPage")!=null){
            currentPage = Integer.parseInt(request.getParameter("tPage"));
        }
        if(request.getParameter("recordsPerPage")!=null){
            recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        }

        int rows;

        if (start!=null && end!=null) {
            vehicles = vehicleService.getVehiclesPaginatedFilteredByPeriod(start, end, currentPage, recordsPerPage);
            rows = vehicleService.getNumberOfCardsPeriod(start, end);
        } else {
            vehicles = vehicleService.getVehiclesPaginated(currentPage, recordsPerPage);
            rows = vehicleService.getNumberOfCards();
        }

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("start", start);
        request.setAttribute("end", end);
        request.setAttribute("vehicles" , vehicles);


        return Path.PAGE__VEHICLES;
    }
}
