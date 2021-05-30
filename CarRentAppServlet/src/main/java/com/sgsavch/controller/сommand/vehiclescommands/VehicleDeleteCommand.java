package com.sgsavch.controller.сommand.vehiclescommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class VehicleDeleteCommand implements Command {

    public VehicleDeleteCommand(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    VehicleService vehicleService;

    public VehicleDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, SQLException, IOException {
        Long id = Long.valueOf(request.getParameter("vehicleId"));
        vehicleService.deleteVehicle(id);

        Command command = CommandContainer.get("vehicles");
        String page = command.execute(request);

        return "redirect:" + page;
    }
}
