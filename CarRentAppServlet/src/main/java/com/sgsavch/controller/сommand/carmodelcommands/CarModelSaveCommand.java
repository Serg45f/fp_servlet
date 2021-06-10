package com.sgsavch.controller.сommand.carmodelcommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CarModelSaveCommand implements Command {
    private static final Logger log = Logger.getLogger(CarModelSaveCommand.class);

    CarModelService carModelService;

    public CarModelSaveCommand(CarModelService carModelService)
    {
        this.carModelService = carModelService;
    }

    ResourceBundle bundle = ResourceBundle.getBundle("application");

    @Override
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {
        Part filePart = request.getPart("file");
        CarModel carModel =  new CarModel.Builder()
                .setName(request.getParameter("name"))
                .setSeatsNumb(Integer.valueOf(request.getParameter("seatsNumb")))
                .setDoorsNumb(Integer.valueOf(request.getParameter("doorsNumb")))
                .setPicture(Paths.get(filePart.getSubmittedFileName()).getFileName().toString())
                .setType(TypeCar.valueOf(request.getParameter("type")))
                .setStatus(StatusCar.valueOf(request.getParameter("status")))
                .setPrice(Double.valueOf(request.getParameter("price")))
                .setDeposit(Double.valueOf(request.getParameter("deposit")))
                .build();

        InputStream fileContent = filePart.getInputStream();
        File targetFile = new File(bundle.getString("upload.path")+carModel.getPicture());
        FileUtils.copyInputStreamToFile(fileContent, targetFile);

        if(request.getParameter("id")!=null) {
            carModel = new CarModel.Builder(carModel).setId(Long.valueOf(request.getParameter("id"))).build();
            carModelService.editCarModel(carModel);
        }else{
            Long res = carModelService.addCarModel(carModel);
        }

        return Path.COMMAND__CARMODELS;
    }
}
