package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class OrderDeleteCommand implements Command {

    public OrderDeleteCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    public OrderDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long id = Long.valueOf(request.getParameter("carmodelId"));
        carModelService.deleteCarModel(id);

        return Path.PAGE__CARMODELS;
    }
}
