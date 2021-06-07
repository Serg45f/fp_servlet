package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class InvoiceService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Order> getAllInvoices() throws SQLException {
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

    public Order getOrder(Long orderId) throws SQLException {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.findById(orderId);
        }
    }

    public Long newOrder(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.create(order);
        }
    }

    public boolean setOrderOptions(Order order, List<Option> options) throws SQLException {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.setOrderOptions(order,options);
        }
    }

    public boolean resetOrderOptions(Order order, List<Option> options) throws SQLException {
        try (OrderDao dao = daoFactory.createOrderDao()) {
            return dao.resetOrderOptions(order,options);
        }
    }
}
