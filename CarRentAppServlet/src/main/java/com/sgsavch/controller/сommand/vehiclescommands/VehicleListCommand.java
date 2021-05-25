package com.sgsavch.controller.сommand.vehiclescommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
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
        List<Vehicle> vehicles = null;
        int currentPage = DEFAULT_CURRENT_PAGE;
        int recordsPerPage = DEFAULT_RECORDS_PER_PAGE;
        LocalDateTime start  = null;
        LocalDateTime end = null;

        if(request.getParameter("start")!=null){
            start = LocalDateTime.parse(request.getParameter("start"));
        }
        if(request.getParameter("end")!=null){
            end = LocalDateTime.parse(request.getParameter("end"));
        }
        if(request.getParameter("tPage")!=null){
            currentPage = Integer.parseInt(request.getParameter("tPage"));
        }
        if(request.getParameter("recordsPerPage")!=null){
            recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        }



//        if (start!=null && end!=null) {
//            vehicles = vehicleService.getVehiclesPaginatedFilteredByPeriod(start, end, currentPage, recordsPerPage);
//        } else {
//            vehicles = vehicleService.getVehiclesPaginated(currentPage, recordsPerPage);
//        }

        vehicles = vehicleService.getVehiclesPaginated(currentPage, recordsPerPage);

        int rows = vehicleService.getNumberOfCards();

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


        return "/vehicles.jsp";
    }
}
