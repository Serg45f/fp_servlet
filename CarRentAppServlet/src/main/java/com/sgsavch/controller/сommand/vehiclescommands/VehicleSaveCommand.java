package com.sgsavch.controller.сommand.vehiclescommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.Color;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
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
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {
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
        Command command = CommandContainer.get("vehicles");
        String page = command.execute(request);

        return page;
    }
}
