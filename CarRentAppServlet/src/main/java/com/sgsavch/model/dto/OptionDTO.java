package com.sgsavch.model.dto;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.entity.Option;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class OptionDTO {

    public Option extractFromRequest(HttpServletRequest request) throws SQLException {
        Option option = new Option.Builder()
                .setDescription(request.getParameter("description"))
                .setName(request.getParameter("name"))
                .setPrice(Double.valueOf(request.getParameter("price")))
                .build();
        if(request.getParameter("id")!=null)
            option = new Option.Builder(option).setId(Long.valueOf(request.getParameter("id"))).build();

        return option;
    }
}
