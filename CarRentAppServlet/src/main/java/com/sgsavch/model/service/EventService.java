package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.EventDao;

import com.sgsavch.model.entity.Event;


import java.util.List;

public class EventService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Event> getAllEvents(){
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.findAll();
        }
    }

    public List<Event> getEvents(int currentPage, int recordsPerPage) {
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.getEvents(currentPage,recordsPerPage);
        }
    }

    public int getNumberOfCards() {
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.getNumberOfCards();
        }
    }

    public Event getEvent(Long eventId) {
        try (EventDao dao = daoFactory.createEventDao()) {
            return dao.findById(eventId);
        }
    }
}
