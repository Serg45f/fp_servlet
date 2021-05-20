package com.sgsavch.controller.Command.CarModelCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;

public class CarModelDeleteCommand implements Command {

    public CarModelDeleteCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    public CarModelDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("carmodelId"));
        carModelService.deleteCarModel(id);

        return "/carmodels";
    }
}
