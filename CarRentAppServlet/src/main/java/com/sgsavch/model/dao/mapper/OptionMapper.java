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
        Option option = new Option();

        option.setId(rs.getLong(SQLConstant.OPTION_ID));
        option.setDescription(rs.getString(SQLConstant.OPTION_DESCRIPTION));
        option.setName(rs.getString(SQLConstant.OPTION_NAME));
        option.setPicture(rs.getString(SQLConstant.OPTION_PICTURE));
        option.setPrice(rs.getDouble(SQLConstant.OPTION_PRICE));

        return option;
    }

    public Option makeUnique(Map<Long, Option> cache,
                              Option option) {
        cache.putIfAbsent(option.getId(), option);
        return cache.get(option.getId());
    }

    public Option extractFromRequest(HttpServletRequest request) throws SQLException {
        Option option = new Option();

        option.setId(Long.valueOf(request.getParameter("id")));
        option.setDescription(request.getParameter("description"));
        option.setName(request.getParameter("name"));
        //option.setPicture(request.getString(SQLConstant.OPTION_PICTURE));
        option.setPrice(Double.valueOf(request.getParameter("price")));

        return option;
    }
}
