package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.VehicleDao;
import com.sgsavch.model.dto.VehicleDTO;
import com.sgsavch.model.entity.Vehicle;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class VehicleService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Vehicle> getVehicles() throws SQLException {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.findAll();
        }
    }

    public List<Vehicle> getVehiclesPaginated(int currentPage, int recordsPerPage) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.getVehicles(currentPage,recordsPerPage);
        }
    }

    public int getNumberOfCards() {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.getNumberOfCards();
        }
    }

    public Vehicle getVehicleById(Long vehicleId) throws SQLException {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.findById(vehicleId);
        }
    }

    public Long addVehicle(Vehicle vehicle) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.create(vehicle);
        }
    }

    public void editVehicle(Vehicle vehicle) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            dao.update(vehicle);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean deleteVehicle(Long vehicleId) throws SQLException {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.delete(vehicleId);
        }
    }

    public List<Vehicle> getVehiclesPaginatedFilteredByPeriod(LocalDateTime start, LocalDateTime end, int currentPage, int recordsPerPage) {
        try (VehicleDao dao = daoFactory.createVehicleDao()) {
            return dao.getVehiclesByPeriod(start, end, currentPage,recordsPerPage);
        }
    }
}
