package com.sgsavch.model.dao;

import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Vehicle;

import java.util.List;


public interface VehicleDao extends GenericDao<Vehicle> {
    List<Vehicle> getVehicles(int currentPage, int numOfRecords);
    Integer getNumberOfCards();


}

