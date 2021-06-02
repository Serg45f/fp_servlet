package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.Color;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.Map;

public class VehicleMapper {

    public Vehicle extractFromResultSet(ResultSet rs) throws SQLException {
        Vehicle vehicle = new Vehicle.Builder()
                .setId(rs.getLong(SQLConstant.VEHICLE_ID))
                .setCarModel(new CarModelService().getCarModel(rs.getLong(SQLConstant.VEHICLE_CARMODEL_ID)))
                .setColor(Color.values()[rs.getInt(SQLConstant.VEHICLE_COLOR)])
                .setRegNumber(rs.getString(SQLConstant.VEHICLE_REG_NUMBER))
                .setTransmission(rs.getString(SQLConstant.VEHICLE_TRANSMISSION))
                .setYearIssue(rs.getDate(SQLConstant.VEHICLE_YEAR_ISSUE).toLocalDate().atTime(LocalTime.ofSecondOfDay(00)))
                .setDiscount(rs.getDouble(SQLConstant.VEHICLE_DISCOUNT))
                .setManager(new UserService().getUser(rs.getLong(SQLConstant.VEHICLE_USER_ID)))
                .build();
        if(rs.getDate(SQLConstant.VEHICLE_YEAR_ISSUE)!=null)
                 vehicle = new Vehicle.Builder(vehicle).build();


        return vehicle;
    }

    public Vehicle makeUnique(Map<Long, Vehicle> cache,
                              Vehicle vehicle) {
        cache.putIfAbsent(vehicle.getId(), vehicle);
        return cache.get(vehicle.getId());
    }
}
