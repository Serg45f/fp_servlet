package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.OptionDao;
import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;

import java.util.List;

public class OptionService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Option> getAllOptions(){
        try (OptionDao dao = daoFactory.createOptionDao()) {
            return dao.findAll();
        }
    }

    public Option getOption(Long optionId) {
        try (OptionDao dao = daoFactory.createOptionDao()) {
            return dao.findById(optionId);
        }
    }

    public List<Option> getOptionsByOrderId(Long orderId) {
        try (OptionDao dao = daoFactory.createOptionDao()) {
            return dao.getOptionsByOrderId(orderId);
        }
    }
}
