package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.entity.Invoice;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.Location;
import com.sgsavch.model.entity.enums.StatusOrder;
import com.sgsavch.model.service.OptionService;
import com.sgsavch.model.service.OrderService;
import com.sgsavch.model.service.UserService;
import com.sgsavch.model.service.VehicleService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Map;

public class InvoiceMapper {

    public Invoice extractFromResultSet(ResultSet rs) throws SQLException {
        return new Invoice.Builder()
            .setId(rs.getLong(SQLConstant.INVOICE_ID))
            .setNumber(rs.getLong(SQLConstant.INVOICE_NUMBER))
            .setOrder(new OrderService().getOrder(rs.getLong(SQLConstant.INVOICE_ORDER_ID)))
            .setIsPayed(rs.getBoolean(SQLConstant.INVOICE_IS_PAYED))
            .setPaymentDate(LocalDateTime.parse(SQLConstant.INVOICE_PAYMENT_DATE_TIME))
            .build();
    }

    public Invoice makeUnique(Map<Long, Invoice> cache, Invoice invoice) {
        cache.putIfAbsent(invoice.getId(), invoice);
        return cache.get(invoice.getId());
    }
}
