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
import java.util.Arrays;

public class VehicleAddCommand implements Command {

    public VehicleAddCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;
    VehicleService vehicleService;
    UserService userService;

    public VehicleAddCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {

        request.setAttribute("carModel", new CarModel());
        request.setAttribute("carTypes" , Arrays.asList(TypeCar.values()));
        request.setAttribute("carStatuses" , Arrays.asList(StatusCar.values()));
        return "/carmodelEdit.jsp";
    }
}
