package com.sgsavch.controller.сommand.carmodelcommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import org.apache.commons.io.FileUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;

public class CarModelSaveCommand implements Command {
    public CarModelSaveCommand(CarModelService carModelService)
    {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    @Override
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {
        Part filePart = request.getPart("file");
        System.out.println("CarModelSaveCommand.execute");
        System.out.println(request.getParameter("name"));
        System.out.println(request.getParameter("seatsNumb"));
        System.out.println(request.getParameter("doorsNumb"));
        System.out.println(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
        System.out.println(request.getParameter("type"));
        System.out.println(request.getParameter("status"));
        System.out.println(request.getParameter("price"));
        System.out.println(request.getParameter("deposit"));

        CarModel carModel = new CarModel();
         //Long id;
         carModel.setName(request.getParameter("name"));
         carModel.setSeatsNumb(Integer.valueOf(request.getParameter("seatsNumb")));
         carModel.setDoorsNumb(Integer.valueOf(request.getParameter("doorsNumb")));
         carModel.setPicture(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
         InputStream fileContent = filePart.getInputStream();
         File targetFile = new File("src/main/webapp/resources/img/"+carModel.getPicture());
         FileUtils.copyInputStreamToFile(fileContent, targetFile);
         carModel.setType(TypeCar.valueOf(request.getParameter("type")));
         carModel.setStatus(StatusCar.valueOf(request.getParameter("status")));
         carModel.setPrice(Double.valueOf(request.getParameter("price")));
         carModel.setDeposit(Double.valueOf(request.getParameter("deposit")));

         Long res = carModelService.addCarModel(carModel);
         carModel.setId(res);

        Command command = CommandContainer.get("carModels");
        String page = command.execute(request);

        return page;
    }
}
