package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;

import java.util.List;


public interface OptionDao extends GenericDao<Option> {

    List<Option> getOptionsByOrderId(Long orderId);

}

