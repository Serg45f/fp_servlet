package com.sgsavch.model.service;


import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.VehicleDao;


public class CarModelServiceTest {
    DaoFactory daoFactory = DaoFactory.getInstance();
    VehicleDao dao = daoFactory.createVehicleDao();


}