package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.Color;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class VehicleMapper {

    public Vehicle extractFromResultSet(ResultSet rs) throws SQLException {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(rs.getLong(SQLConstant.VEHICLE_ID));
        vehicle.setColor(Color.values()[rs.getInt(SQLConstant.VEHICLE_COLOR)]);
        vehicle.setRegNumber(rs.getString(SQLConstant.VEHICLE_REG_NUMBER));
        vehicle.setTransmission(rs.getString(SQLConstant.VEHICLE_TRANSMISSION));
        vehicle.setCarModel(new CarModelService().getCarModel(rs.getLong(SQLConstant.VEHICLE_CARMODEL_ID)));
        vehicle.setYearIssue(rs.getDate(SQLConstant.VEHICLE_YEAR_ISSUE).toLocalDate());
        vehicle.setDiscount(rs.getDouble(SQLConstant.VEHICLE_DISCOUNT));
        vehicle.setManager(new UserService().getUser(rs.getLong(SQLConstant.VEHICLE_USER_ID)));

        return vehicle;
    }

    public Vehicle makeUnique(Map<Long, Vehicle> cache,
                              Vehicle vehicle) {
        cache.putIfAbsent(vehicle.getId(), vehicle);
        return cache.get(vehicle.getId());
    }
}
