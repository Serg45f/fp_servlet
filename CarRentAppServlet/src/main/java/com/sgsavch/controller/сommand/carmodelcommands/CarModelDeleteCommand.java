package com.sgsavch.controller.сommand.carmodelcommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class CarModelDeleteCommand implements Command {

    public CarModelDeleteCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    public CarModelDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, SQLException, IOException {
        Long id = Long.valueOf(request.getParameter("carmodelId"));
        carModelService.deleteCarModel(id);

        Command command = CommandContainer.get("carModels");
        String page = command.execute(request);
        return page;
    }
}
