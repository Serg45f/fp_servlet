package com.sgsavch.controller.Command.CarModelCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.StatusUser;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.utils.BCrypt;
import com.sgsavch.utils.MailSender;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class CarModelSaveCommand implements Command {
    public CarModelSaveCommand(CarModelService carModelService)
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
