package com.sgsavch.controller.сommand.vehiclescommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class VehicleAddCommand implements Command {

    public VehicleAddCommand(CarModelService carModelService, UserService userService) {
        this.carModelService = carModelService;
        this.userService = userService;
    }

    CarModelService carModelService;
    UserService userService;

    public VehicleAddCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        request.setAttribute("vehicle", new Vehicle());
        request.setAttribute("carModels" , carModelService.getAllCarModels());
        request.setAttribute("managers" , userService.getAllManagers());
        return "/carmodelEdit.jsp";
    }
}
