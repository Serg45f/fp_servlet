package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;

import java.sql.SQLException;
import java.util.List;


public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrders(int currentPage, int numOfRecords);
    Integer getNumberOfCards();
    boolean setOrderOptions(Order order, List<Option> options) throws SQLException;
    boolean resetOrderOptions(Order order, List<Option> options) throws SQLException;


}

