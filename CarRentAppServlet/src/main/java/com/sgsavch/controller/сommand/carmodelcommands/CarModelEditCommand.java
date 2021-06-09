package com.sgsavch.controller.сommand.carmodelcommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Arrays;

public class CarModelEditCommand implements Command {

    private static final Logger log = Logger.getLogger(CarModelEditCommand.class);

    CarModelService carModelService;

    public CarModelEditCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long id = Long.valueOf(request.getParameter("carmodelId"));

        request.setAttribute("carModel", carModelService.getCarModel(id));
        request.setAttribute("carTypes" , Arrays.asList(TypeCar.values()));
        request.setAttribute("carStatuses" , Arrays.asList(StatusCar.values()));

        return Path.PAGE__CARMODEL_EDIT;
    }
}
