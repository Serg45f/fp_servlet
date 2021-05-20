package com.sgsavch.model.service;

import com.sgsavch.model.dao.CarModelDao;
import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.entity.CarModel;

import java.util.List;

public class CarModelService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<CarModel> getAllCarModels(){
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

    public CarModel getCarModel(Long carModelId) {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.findById(carModelId);
        }
    }

    public Long addCarModel(CarModel carModelId) {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.create(carModelId);
        }
    }

    public void editCarModel(CarModel carModelId) {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            dao.update(carModelId);
        }
    }

    public boolean deleteCarModel(Long carModelId) {
        try (CarModelDao dao = daoFactory.createCarModelDao()) {
            return dao.delete(carModelId);
        }
    }
}
