package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Ticket;
import com.sgsavch.model.entity.agregates.TicketsCountAndTotalSum;

import java.sql.SQLException;
import java.util.List;


public interface TicketDao extends GenericDao<Ticket> {
    List<Ticket> getTicketsPaginated(int currentPage, int numOfRecords);
    Integer getNumberOfRaws();

    List<Ticket> getTicketsPaginatedByUserId(Long userId, int currentPage, int recordsPerPage);

//    List<Ticket> getTicketsByUsername(String username);

    List<TicketsCountAndTotalSum> countTicketsByUserGroupByEvent(Long userId);

    List<TicketsCountAndTotalSum> countTicketsByEventGroupUser(Long eventId);

    List<TicketsCountAndTotalSum> finAllTicketsGroupByUser() throws SQLException;

    List<TicketsCountAndTotalSum> finAllTicketsGroupByEvent();

    Long getTicketsQuantityByEventId(Long eventId);
}

