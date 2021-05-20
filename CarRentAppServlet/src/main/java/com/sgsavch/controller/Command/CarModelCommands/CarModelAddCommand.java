package com.sgsavch.controller.Command.CarModelCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class CarModelAddCommand implements Command {

    public CarModelAddCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    public CarModelAddCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {

        request.setAttribute("carModel", new CarModel());
        request.setAttribute("carTypes" , Arrays.asList(TypeCar.values()));
        request.setAttribute("carStatuses" , Arrays.asList(StatusCar.values()));
        return "/carmodelEdit.jsp";
    }
}
