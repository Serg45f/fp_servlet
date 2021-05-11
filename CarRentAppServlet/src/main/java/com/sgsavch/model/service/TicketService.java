package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.TicketDao;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.Ticket;
import com.sgsavch.model.entity.agregates.TicketsCountAndTotalSum;
import com.sgsavch.model.entity.User;

import java.util.List;

public class TicketService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Ticket> getAllTickets(){
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.findAll();
        }
    }

    public List<Ticket> getTicketPaginated(int currentPage, int recordsPerPage) {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.getTicketsPaginated(currentPage,recordsPerPage);
        }
    }

    public List<Ticket> getTicketsPaginatedByUserId(Long userId, int currentPage, int recordsPerPage) {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.getTicketsPaginatedByUserId(userId,currentPage,recordsPerPage);
        }
    }

    public int getNumberOfRaws() {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.getNumberOfRaws();
        }
    }


//    public List<Ticket> getTicketsByUsername(String username) {
//        try (TicketDao dao = daoFactory.createTicketDao()) {
//            return dao.getTicketsByUsername(username);
//        }
//    }

    public List<TicketsCountAndTotalSum> countTicketsByUserGroupByEvent(Long userId) {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.countTicketsByUserGroupByEvent(userId);
        }
    }

    public List<TicketsCountAndTotalSum> countTicketsByEventGroupByUser(Long eventId) {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.countTicketsByEventGroupUser(eventId);
        }
    }


    public Long create(Ticket ticket) {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.create(ticket);
        }
    }

    public boolean deleteTicketsByUser(Long userId) {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.delete(userId);
        }
    }


    public Long getTicketsQuantityByEventId(Long eventId) {
        try (TicketDao dao = daoFactory.createTicketDao()) {
            return dao.getTicketsQuantityByEventId(eventId);
        }
    }
}
