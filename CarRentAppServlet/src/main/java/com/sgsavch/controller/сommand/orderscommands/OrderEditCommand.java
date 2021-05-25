package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Arrays;

public class OrderEditCommand implements Command {

    public OrderEditCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    public OrderEditCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long id = Long.valueOf(request.getParameter("carmodelId"));

        request.setAttribute("carModel", carModelService.getCarModel(id));
        request.setAttribute("carTypes" , Arrays.asList(TypeCar.values()));
        request.setAttribute("carStatuses" , Arrays.asList(StatusCar.values()));
        return "/carmodelEdit.jsp";
    }
}
