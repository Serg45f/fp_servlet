package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class OrderAddCommand implements Command {

    CarModelService carModelService;

    public OrderAddCommand(CarModelService carModelService) {
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
