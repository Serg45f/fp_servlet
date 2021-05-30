package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class CarModelMapper {

    public CarModel extractFromResultSet(ResultSet rs) throws SQLException {
        TypeCar[] types = TypeCar.values();
        StatusCar[] statuses = StatusCar.values();
        CarModel carModel = new CarModel.Builder()
        .setId(rs.getLong("id"))
        .setName(rs.getString("name"))
        .setSeatsNumb(rs.getInt("numb_of_seats"))
        .setDoorsNumb(rs.getInt("numb_of_doors"))
        .setPicture(rs.getString("picture"))
        .setType(types[rs.getInt("type")])
        .setStatus(statuses[rs.getInt("status")])
        .setPrice(rs.getDouble("price"))
        .setDeposit(rs.getDouble("deposit"))
        .build();

        return carModel;
    }


    public CarModel makeUnique(Map<Long, CarModel> cache,
                              CarModel carModel) {
        cache.putIfAbsent(carModel.getId(), carModel);
        return cache.get(carModel.getId());
    }
}
