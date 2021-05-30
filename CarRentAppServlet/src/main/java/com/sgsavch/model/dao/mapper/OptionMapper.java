package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.Color;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OptionMapper {

    public Option extractFromResultSet(ResultSet rs) throws SQLException {
        Option option = new Option.Builder()
            .setId(rs.getLong(SQLConstant.OPTION_ID))
            .setDescription(rs.getString(SQLConstant.OPTION_DESCRIPTION))
            .setName(rs.getString(SQLConstant.OPTION_NAME))
            .setPicture(rs.getString(SQLConstant.OPTION_PICTURE))
            .setPrice(rs.getDouble(SQLConstant.OPTION_PRICE))
            .build();

        return option;
    }

    public Option makeUnique(Map<Long, Option> cache,
                              Option option) {
        cache.putIfAbsent(option.getId(), option);
        return cache.get(option.getId());
    }

    public Option extractFromRequest(HttpServletRequest request) throws SQLException {
        Option option = new Option.Builder()
        .setId(Long.valueOf(request.getParameter("id")))
        .setDescription(request.getParameter("description"))
        .setName(request.getParameter("name"))
        .setPrice(Double.valueOf(request.getParameter("price")))
        .build();

        return option;
    }
}
