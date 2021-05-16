package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.enums.Language;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.StatusEvent;
import com.sgsavch.model.entity.enums.TypeCar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CarModelMapper {

    public CarModel extractFromResultSet(ResultSet rs) throws SQLException {
        CarModel carModel = new CarModel();
        TypeCar[] types = TypeCar.values();
        StatusCar[] statuses = StatusCar.values();

        carModel.setId(rs.getLong("id"));
        carModel.setName(rs.getString("name"));
        carModel.setSeatsNumb(rs.getInt("numb_of_seats"));
        carModel.setDoorsNumb(rs.getInt("numb_of_doors"));
        carModel.setPicture(rs.getString("picture"));
        carModel.setType(types[rs.getInt("type")]);
        carModel.setStatus(statuses[rs.getInt("status")]);
        carModel.setPrice(rs.getDouble("price"));
        carModel.setDeposit(rs.getDouble("deposit"));

        return carModel;
    }


    public CarModel makeUnique(Map<Long, CarModel> cache,
                              CarModel carModel) {
        cache.putIfAbsent(carModel.getId(), carModel);
        return cache.get(carModel.getId());
    }
}
