package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.VehicleDao;
import com.sgsavch.model.entity.Vehicle;

import java.util.List;

public class VehicleService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Vehicle> getVehicles(){
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.findAll();
        }
    }

    public List<Vehicle> getCarModelsPaginated(int currentPage, int recordsPerPage) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.getVehicles(currentPage,recordsPerPage);
        }
    }

    public int getNumberOfCards() {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.getNumberOfCards();
        }
    }

    public Vehicle getVehicleById(Long vehicleId) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.findById(vehicleId);
        }
    }

    public Long addVehicle(Vehicle vehicleId) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.create(vehicleId);
        }
    }

    public void editVehicle(Vehicle vehicleId) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            dao.update(vehicleId);
        }
    }

    public boolean deleteVehicle(Long vehicleId) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.delete(vehicleId);
        }
    }
}
