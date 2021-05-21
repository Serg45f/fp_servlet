package com.sgsavch.controller.Command.VehiclesCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;

public class VehicleDeleteCommand implements Command {

    public VehicleDeleteCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    public VehicleDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("carmodelId"));
        carModelService.deleteCarModel(id);

        return "/carmodels";
    }
}
