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
        Order order = new Order();
        TypeCar[] types = TypeCar.values();
        StatusCar[] statuses = StatusCar.values();



        String ORDER_TOTAL_PRICE = "orders.total_price";
        String ORDER_DAMAGE_DESCRIPTION = "orders.damage_description";
        String ORDER_DAMAGE_PRICE = "orders.damage_price";
        String ORDER_DAMAGE_PAYED= "orders.damage_is_payed";

        order.setId(rs.getLong(SQLConstant.ORDER_ID));
        order.setCode(rs.getString(SQLConstant.ORDER_CODE));
        order.setQrcode(rs.getString(SQLConstant.ORDER_CODE));
        order.setStart(LocalDateTime.parse(rs.getDate(SQLConstant.ORDER_START).toString()));
        order.setEnd(LocalDateTime.parse(rs.getDate(SQLConstant.ORDER_START).toString()));
        order.setRealEnd(LocalDateTime.parse(rs.getDate(SQLConstant.ORDER_REAL_END).toString()));
        order.setUser(new UserService().getUser(rs.getLong(SQLConstant.ORDER_USER_ID)));
        order.setLocation(Location.values()[rs.getInt(SQLConstant.ORDER_CODE)]);
        order.setVehicle(new VehicleService().getVehicleById(rs.getLong(SQLConstant.ORDER_VEHICLE_ID)));
        order.setDays(Period.between(order.getStart().toLocalDate(),order.getEnd().toLocalDate()).getDays());
        order.setStatus(StatusOrder.values()[rs.getInt(SQLConstant.ORDER_STATUS_ORDER)]);
        order.setPricePeriod(order.getDays()*order.getVehicle().getCarModel().getPrice());
        order.setOptions(new OptionService().getOptionsByOrderId(order.getId()));
        order.setPriceOptions(rs.getDouble(SQLConstant.ORDER_PRICE_OPTIONS));
        order.setTotalPrice(rs.getDouble(SQLConstant.ORDER_TOTAL_PRICE));
        order.setDamageDescript(rs.getString(SQLConstant.ORDER_DAMAGE_DESCRIPTION));
        order.setDamagePrice(rs.getDouble(SQLConstant.ORDER_DAMAGE_PRICE));
        order.setDamageIsPayed(rs.getBoolean(SQLConstant.ORDER_DAMAGE_PAYED));


        return order;
    }

    public Order makeUnique(Map<Long, Order> cache, Order order) {
        cache.putIfAbsent(order.getId(), order);
        return cache.get(order.getId());
    }
}
