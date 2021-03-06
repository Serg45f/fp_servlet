package com.sgsavch.model.service;

import com.sgsavch.model.dao.CarModelDao;
import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.entity.CarModel;

import java.sql.SQLException;
import java.util.List;

public class CarModelService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<CarModel> getAllCarModels() throws SQLException {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.findAll();
        }
    }

    public List<CarModel> getCarModelsPaginated(int currentPage, int recordsPerPage) {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.getCarModels(currentPage,recordsPerPage);
        }
    }

    public int getNumberOfCards() {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.getNumberOfCards();
        }
    }

    public CarModel getCarModel(Long carModelId) throws SQLException {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.findById(carModelId);
        }
    }

    public Long addCarModel(CarModel carModelId) throws SQLException {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.create(carModelId);
        }
    }

    public void editCarModel(CarModel carModelId) throws SQLException{
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            dao.update(carModelId);
        }
    }

    public boolean deleteCarModel(Long carModelId) throws SQLException {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.delete(carModelId);
        }
    }
}
