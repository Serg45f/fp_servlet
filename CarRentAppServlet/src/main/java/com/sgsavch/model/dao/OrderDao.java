package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Order;

import java.util.List;


public interface OrderDao extends GenericDao<Order> {
    List<Order> getOrders(int currentPage, int numOfRecords);
    Integer getNumberOfCards();


}

