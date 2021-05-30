package com.sgsavch.controller.сommand.vehiclescommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.enums.Color;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.UserService;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Arrays;

public class VehicleEditCommand implements Command {

    public VehicleEditCommand(VehicleService vehicleService, CarModelService carModelService, UserService userService) {
        this.vehicleService = vehicleService;
        this.carModelService = carModelService;
        this.userService = userService;
    }

    VehicleService vehicleService;
    CarModelService carModelService;
    UserService userService;

    public VehicleEditCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long id = Long.valueOf(request.getParameter("vehicleId"));

        request.setAttribute("vehicle", vehicleService.getVehicleById(id));
        request.setAttribute("colors", Arrays.asList(Color.values()));
        request.setAttribute("carModels" , carModelService.getAllCarModels());
        request.setAttribute("managers" , userService.getAllManagers());
        return Path.PAGE__VEHICLE_EDIT;
    }
}
