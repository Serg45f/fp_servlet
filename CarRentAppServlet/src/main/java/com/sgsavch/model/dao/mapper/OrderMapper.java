package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.*;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OptionService;
import com.sgsavch.model.service.UserService;
import com.sgsavch.model.service.VehicleService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.Map;

public class OrderMapper {

    public Order extractFromResultSet(ResultSet rs) throws SQLException {
        TypeCar[] types = TypeCar.values();
        StatusCar[] statuses = StatusCar.values();

        String ORDER_TOTAL_PRICE = "orders.total_price";
        String ORDER_DAMAGE_DESCRIPTION = "orders.damage_description";
        String ORDER_DAMAGE_PRICE = "orders.damage_price";
        String ORDER_DAMAGE_PAYED= "orders.damage_is_payed";

        Order order = new Order.Builder()
            .setId(rs.getLong(SQLConstant.ORDER_ID))
            .setCode(rs.getString(SQLConstant.ORDER_CODE))
            .setQRCode(rs.getString(SQLConstant.ORDER_CODE))
            .setStart(LocalDateTime.parse(rs.getDate(SQLConstant.ORDER_START).toString()))
            .setEnd(LocalDateTime.parse(rs.getDate(SQLConstant.ORDER_START).toString()))
            .setRealEnd(LocalDateTime.parse(rs.getDate(SQLConstant.ORDER_REAL_END).toString()))
            .setUser(new UserService().getUser(rs.getLong(SQLConstant.ORDER_USER_ID)))
            .setLocation(Location.values()[rs.getInt(SQLConstant.ORDER_CODE)])
            .setVehicle(new VehicleService().getVehicleById(rs.getLong(SQLConstant.ORDER_VEHICLE_ID)))
            .setStatusOrder(StatusOrder.values()[rs.getInt(SQLConstant.ORDER_STATUS_ORDER)])
            .setPriceOptions(rs.getDouble(SQLConstant.ORDER_PRICE_OPTIONS))
            .setTotalPrice(rs.getDouble(SQLConstant.ORDER_TOTAL_PRICE))
            .setDamageDescript(rs.getString(SQLConstant.ORDER_DAMAGE_DESCRIPTION))
            .setDamagePrice(rs.getDouble(SQLConstant.ORDER_DAMAGE_PRICE))
            .setDamageIsPayed(rs.getBoolean(SQLConstant.ORDER_DAMAGE_PAYED))
            .build();

        order = new Order.Builder()
            .setOptions(new OptionService().getOptionsByOrderId(order.getId()))
            .setDays(Period.between(order.getStart().toLocalDate(),order.getEnd().toLocalDate()).getDays())
            .setPricePeriod(order.getDays()*order.getVehicle().getCarModel().getPrice())
            .build();
        return order;
    }

    public Order makeUnique(Map<Long, Order> cache, Order order) {
        cache.putIfAbsent(order.getId(), order);
        return cache.get(order.getId());
    }
}
