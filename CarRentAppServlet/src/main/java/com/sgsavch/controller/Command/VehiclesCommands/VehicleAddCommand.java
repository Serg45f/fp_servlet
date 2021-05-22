package com.sgsavch.controller.Command.VehiclesCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.UserService;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Arrays;

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
