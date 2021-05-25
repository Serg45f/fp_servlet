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
        CarModel carModel = new CarModel();
         //Long id;
         carModel.setName(request.getParameter("name"));
         carModel.setSeatsNumb(Integer.valueOf(request.getParameter("seatsNumb")));
         carModel.setDoorsNumb(Integer.valueOf(request.getParameter("doorsNumb")));
         carModel.setPicture(request.getParameter("picture"));
         carModel.setType(TypeCar.valueOf(request.getParameter("type")));
         carModel.setStatus(StatusCar.valueOf(request.getParameter("status")));
         carModel.setPrice(Double.valueOf(request.getParameter("price")));
         carModel.setDeposit(Double.valueOf(request.getParameter("deposit")));

//         Long res = carModelService.create(carModel);
//         carModel.setId(res);

        return "/carmodels";
    }
}
