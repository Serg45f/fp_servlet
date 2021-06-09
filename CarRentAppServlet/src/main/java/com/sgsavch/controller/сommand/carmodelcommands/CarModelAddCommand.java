package com.sgsavch.controller.сommand.carmodelcommands;

import com.sgsavch.Path;
import com.sgsavch.controller.filters.SessionStartFilter;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class CarModelAddCommand implements Command {
    private static final Logger log = Logger.getLogger(CarModelAddCommand.class);

    CarModelService carModelService;

    public CarModelAddCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        request.setAttribute("carModel", new CarModel.Builder().build());
        request.setAttribute("carTypes" , Arrays.asList(TypeCar.values()));
        request.setAttribute("carStatuses" , Arrays.asList(StatusCar.values()));
        return Path.PAGE__CARMODEL_EDIT;
    }
}
