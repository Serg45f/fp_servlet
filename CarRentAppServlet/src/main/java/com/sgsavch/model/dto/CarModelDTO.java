package com.sgsavch.model.dto;

import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class CarModelDTO  extends AbstractDto{
    private Long id;
    private String name;
    private Integer seatsNumb;
    private Integer doorsNumb;
    private String picture;
    private TypeCar type;
    private StatusCar status;
    private Double price;
    private Double deposit;
    private List<Vehicle> vehicles;



    public Option extractFromRequest(HttpServletRequest request) throws SQLException {
//        Option option = new Option();
//
//        option.setId(Long.valueOf(request.getParameter("id")));
//        option.setDescription(request.getParameter("description"));
//        option.setName(request.getParameter("name"));
//        //option.setPicture(request.getString(SQLConstant.OPTION_PICTURE));
//        option.setPrice(Double.valueOf(request.getParameter("price")));

        return null;
    }
}
