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


}
