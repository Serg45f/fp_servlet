package com.sgsavch.controller.сommand.vehiclescommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.dto.VehicleDTO;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.Color;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.UserService;
import com.sgsavch.model.service.VehicleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class VehicleSaveCommand implements Command {

    public VehicleSaveCommand(VehicleService vehicleService, UserService userService, CarModelService carModelService) {
        this.vehicleService = vehicleService;
        this.userService = userService;
        this.carModelService = carModelService;

    }
    VehicleService vehicleService;
    UserService userService;
    CarModelService carModelService;

    @Override
    public String execute(HttpServletRequest request) throws SQLException {

            Vehicle vehicle = new Vehicle.Builder()
                    .setRegNumber(request.getParameter("regNumber"))
                    .setCarModel(new CarModel.Builder().build().valueOf(request.getParameter("carModel")))
                    .setYearIssue(LocalDateTime.parse(request.getParameter("yearIssue"),DateTimeFormatter.ofPattern("yyyy'-'MM'-'dd'T'kk':'mm", Locale.getDefault())))
                    .setColor(Color.valueOf(request.getParameter("color")))
                    .setTransmission(request.getParameter("transmission"))
                    .setDiscount(Double.valueOf(request.getParameter("discount")))
                    .setManager(new User.Builder().build().valueOf(request.getParameter("manager")))
                    .build();
            if(request.getParameter("id")!=null) {
                vehicle = new Vehicle.Builder(vehicle).setId(Long.valueOf(request.getParameter("id"))).build();
                vehicleService.updateVehicle(vehicle);
            }else{
                vehicle = new Vehicle.Builder(vehicle).setIsNew(true).build();
                Long res = vehicleService.addVehicle(vehicle);
            }



        //vehicleDTO.setId(res);
        Command command = CommandContainer.get("vehicles");
        String page = null;
        try {
            page = command.execute(request);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return page;
    }
}
