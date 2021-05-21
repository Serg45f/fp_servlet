package com.sgsavch.controller.Command.VehiclesCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.Color;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class VehicleSaveCommand implements Command {
    public VehicleSaveCommand(VehicleService vehicleService, CarModelService carModelService)
    {
        this.vehicleService = vehicleService;
        this.carModelService = carModelService;
    }

    VehicleService vehicleService;
    CarModelService carModelService;

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("(VehicleSaveCommand).execute");
        Vehicle vehicle = new Vehicle();
         //Long id;
        vehicle.setRegNumber(request.getParameter("regNumber"));
        vehicle.setYearIssue(LocalDate.parse(request.getParameter("yearIssue")));
        vehicle.setColor(Color.valueOf(request.getParameter("picture")));
        vehicle.setTransmission(request.getParameter("transmission"));
        vehicle.setDiscount(Double.valueOf(request.getParameter("discount")));

//         Long res = vehicleService.create(carModel);
//         vehicle.setId(res);

        return "/servlet?command=vehicles";
    }
}
