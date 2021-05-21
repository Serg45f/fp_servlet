package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.entity.Order;

import java.util.List;

public class OrderService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Order> getAllOrders(){
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findAll();
        }
    }

    public List<Order> getOrders(int currentPage, int recordsPerPage) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getOrders(currentPage,recordsPerPage);
        }
    }

    public int getNumberOfCards() {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.getNumberOfCards();
        }
    }

    public Order getOrder(Long orderId) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findById(orderId);
        }
    }
}
