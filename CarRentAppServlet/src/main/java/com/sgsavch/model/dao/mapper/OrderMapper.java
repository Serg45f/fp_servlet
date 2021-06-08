package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.entity.*;
import com.sgsavch.model.entity.enums.*;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OptionService;
import com.sgsavch.model.service.UserService;
import com.sgsavch.model.service.VehicleService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderMapper {

    public Order extractFromResultSet(ResultSet rs) throws SQLException {

        String ORDER_TOTAL_PRICE = "orders.total_price";
        String ORDER_DAMAGE_DESCRIPTION = "orders.damage_description";
        String ORDER_DAMAGE_PRICE = "orders.damage_price";
        String ORDER_DAMAGE_PAYED= "orders.damage_is_payed";
        Vehicle vehicle = new VehicleService().getVehicleById(rs.getLong(SQLConstant.ORDER_VEHICLE_ID));
        User user = new UserService().getUser(rs.getLong(SQLConstant.ORDER_USER_ID));
        List<Option> options = new OptionService().getOptionsByOrderId(rs.getLong(SQLConstant.ORDER_ID));

        Order order = new Order.Builder()
            .setId(rs.getLong(SQLConstant.ORDER_ID))
            .setCode(rs.getString(SQLConstant.ORDER_CODE))
            .setQRCode(rs.getString(SQLConstant.ORDER_QR))
            .setStart(rs.getDate(SQLConstant.ORDER_START).toLocalDate().atTime(LocalTime.ofSecondOfDay(00)))
            .setEnd(rs.getDate(SQLConstant.ORDER_START).toLocalDate().atTime(LocalTime.ofSecondOfDay(00)))
            .setUser(user)
            .setLocation(Location.values()[rs.getInt(SQLConstant.ORDER_LOCATION)])
            .setVehicle(vehicle)
            .setStatusOrder(StatusOrder.values()[rs.getInt(SQLConstant.ORDER_STATUS_ORDER)])
            .setPriceOptions(rs.getDouble(SQLConstant.ORDER_PRICE_OPTIONS))
            .setTotalPrice(rs.getDouble(SQLConstant.ORDER_TOTAL_PRICE))
            .setDamageDescript(rs.getString(SQLConstant.ORDER_DAMAGE_DESCRIPTION))
            .setDamagePrice(rs.getDouble(SQLConstant.ORDER_DAMAGE_PRICE))
            .setDamageIsPayed(rs.getBoolean(SQLConstant.ORDER_DAMAGE_PAYED))
            .setOptions(options)
            .setDays(rs.getInt(SQLConstant.ORDER_DAYS))
            .setPricePeriod(rs.getInt(SQLConstant.ORDER_DAYS)*vehicle.getCarModel().getPrice())
            .build();
        if(rs.getDate(SQLConstant.ORDER_REAL_END) != null)
            order = new Order.Builder(order)
                    .setRealEnd(rs.getDate(SQLConstant.ORDER_REAL_END).toLocalDate().atTime(LocalTime.ofSecondOfDay(00)))
                    .build();
        return order;
    }

    public Order makeUnique(Map<Long, Order> cache, Order order) {
        cache.putIfAbsent(order.getId(), order);
        return cache.get(order.getId());
    }
}
