package com.sgsavch.model.dto;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.entity.Option;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OptionDTO {

    public Option extractFromRequest(HttpServletRequest request) throws SQLException {
//        Option option = new Option();
//
//        option.setId(Long.valueOf(request.getParameter("id")));
//        option.setDescription(request.getParameter("description"));
//        option.setName(request.getParameter("name"));
//        //option.setPicture(request.getString(SQLConstant.OPTION_PICTURE));
//        option.setPrice(Double.valueOf(request.getParameter("price")));

        return null;
    }
}
