package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;

public class OrderSaveCommand implements Command {
    public OrderSaveCommand(CarModelService carModelService)
    {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("(CarModelSaveCommand.execute");
        CarModel.Builder carModelBuilder = new CarModel.Builder();
        CarModel carModel = carModelBuilder
         .setName(request.getParameter("name"))
         .setSeatsNumb(Integer.valueOf(request.getParameter("seatsNumb")))
         .setDoorsNumb(Integer.valueOf(request.getParameter("doorsNumb")))
         .setPicture(request.getParameter("picture"))
         .setType(TypeCar.valueOf(request.getParameter("type")))
         .setStatus(StatusCar.valueOf(request.getParameter("status")))
         .setPrice(Double.valueOf(request.getParameter("price")))
         .setDeposit(Double.valueOf(request.getParameter("deposit")))
                .build();

         Long res = carModelService.addCarModel(carModel);
         carModel = carModelBuilder.setId(res).build();

        return "/carmodels";
    }
}
