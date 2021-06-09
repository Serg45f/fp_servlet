package com.sgsavch.controller.сommand.carmodelcommands;

import com.sgsavch.Path;
import com.sgsavch.controller.listener.SessionListener;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.service.CarModelService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class CarModelDeleteCommand implements Command {

    private static final Logger log = Logger.getLogger(CarModelDeleteCommand.class);

    CarModelService carModelService;

    public CarModelDeleteCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @Override
    public String execute(HttpServletRequest request) throws ServletException, SQLException, IOException {

        Long id = Long.valueOf(request.getParameter("carmodelId"));
        carModelService.deleteCarModel(id);

        return Path.COMMAND__CARMODELS;
    }
}
