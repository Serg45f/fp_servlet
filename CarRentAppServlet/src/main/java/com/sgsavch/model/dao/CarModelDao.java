package com.sgsavch.model.dao;

import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Event;

import java.util.List;


public interface CarModelDao extends GenericDao<CarModel> {
    List<CarModel> getCarModels(int currentPage, int numOfRecords);
    Integer getNumberOfCards();


}

