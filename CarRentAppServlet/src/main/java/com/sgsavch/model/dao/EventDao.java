package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Event;

import java.util.List;


public interface EventDao extends GenericDao<Event> {
    List<Event> getEvents(int currentPage, int numOfRecords);
    Integer getNumberOfCards();


}

