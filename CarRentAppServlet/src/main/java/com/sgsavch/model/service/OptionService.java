package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.OptionDao;
import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.dao.VehicleDao;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.Vehicle;

import java.sql.SQLException;
import java.util.List;

public class OptionService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Option> getAllOptions() throws SQLException {
        try (OptionDao dao = daoFactory.createOptionDao()) {
            return dao.findAll();
        }
    }

    public Option getOption(Long optionId) throws SQLException {
        try (OptionDao dao = daoFactory.createOptionDao()) {
            return dao.findById(optionId);
        }
    }

    public List<Option> getOptionsByOrderId(Long orderId) {
        try (OptionDao dao = daoFactory.createOptionDao()) {
            return dao.getOptionsByOrderId(orderId);
        }
    }

    public Long addOption(Option option) {
        try (OptionDao dao = daoFactory.createOptionDao()) {
            return dao.create(option);
        }
    }

    public void editOption(Option option) {
        try (OptionDao dao = daoFactory.createOptionDao()) {
            dao.update(option);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean deleteOption(Long id) {
        try (OptionDao dao = daoFactory.createOptionDao()) {
            return dao.delete(id);
        }
    }
}
