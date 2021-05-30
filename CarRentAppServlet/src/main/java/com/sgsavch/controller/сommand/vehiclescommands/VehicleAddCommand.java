package com.sgsavch.controller.сommand.vehiclescommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.Color;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Array;
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

        request.setAttribute("vehicle", new Vehicle.Builder().build());
        request.setAttribute("colors" , Arrays.asList(Color.values()));
        request.setAttribute("carModels" , carModelService.getAllCarModels());
        request.setAttribute("managers" , userService.getAllManagers());

        return Path.PAGE__VEHICLE_EDIT;
    }
}
