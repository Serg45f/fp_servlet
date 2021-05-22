package com.sgsavch.controller.Command.OrdersCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;

public class OrderDeleteCommand implements Command {

    public OrderDeleteCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    public OrderDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("carmodelId"));
        carModelService.deleteCarModel(id);

        return "/carmodels";
    }
}
