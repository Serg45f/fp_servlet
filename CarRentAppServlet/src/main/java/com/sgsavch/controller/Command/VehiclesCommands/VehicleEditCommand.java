package com.sgsavch.controller.Command.VehiclesCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class VehicleEditCommand implements Command {

    public VehicleEditCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    public VehicleEditCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("carmodelId"));

        request.setAttribute("carModel", carModelService.getCarModel(id));
        request.setAttribute("carTypes" , Arrays.asList(TypeCar.values()));
        request.setAttribute("carStatuses" , Arrays.asList(StatusCar.values()));
        return "/carmodelEdit.jsp";
    }
}
