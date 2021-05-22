package com.sgsavch.controller.Command.VehiclesCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.http.HttpServletRequest;

public class VehicleDeleteCommand implements Command {

    public VehicleDeleteCommand(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    VehicleService vehicleService;

    public VehicleDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("vehicleId"));
        vehicleService.deleteVehicle(id);

        return "/servlet/vehicles";
    }
}
