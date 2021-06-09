package com.sgsavch.model.dao;

import com.sgsavch.model.dto.VehicleDTO;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Vehicle;

import java.time.LocalDateTime;
import java.util.List;


public interface VehicleDao extends GenericDao<Vehicle> {
    List<Vehicle> getVehicles(int currentPage, int numOfRecords);
    Integer getNumberOfCards();
    List<Vehicle> getVehiclesByPeriod(LocalDateTime start, LocalDateTime end, int currentPage, int recordsPerPage);
    Integer getNumberOfCardsPeriod();
}

