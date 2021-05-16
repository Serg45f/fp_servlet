package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.TicketDao;
import com.sgsavch.model.dao.mapper.TicketMapper;
import com.sgsavch.model.dao.mapper.TicketsCountMapper;
import com.sgsavch.model.entity.Ticket;
import com.sgsavch.model.entity.agregates.TicketsCountAndTotalSum;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTicketDao implements TicketDao {
    private Connection connection;


    public JDBCTicketDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Ticket entity) {

        return null;
    }


    @Override
    public Ticket findById(long id) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        Map<Long, Ticket> tickets = new HashMap<>();


        final String query = "select * from ticket";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            TicketMapper ticketMapper = new TicketMapper();


            while (rs.next()) {
                Ticket ticket = ticketMapper
                        .extractFromResultSet(rs);

                ticket = ticketMapper
                        .makeUnique(tickets, ticket);

            }
            return new ArrayList<>(tickets.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Ticket entity) {

    }


    @Override
    public boolean delete(Long id) {

        return false;
    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ticket> getTicketsPaginated(int currentPage, int recordsPerPage) {
        Map<Long, Ticket> tickets = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        String sql = String.format("SELECT * FROM tickets LIMIT %d, %d",start,recordsPerPage);
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);

            TicketMapper ticketMapper = new TicketMapper();
            while (rs.next()) {
                Ticket ticket = ticketMapper
                        .extractFromResultSet(rs);
                ticket = ticketMapper
                        .makeUnique(tickets, ticket);
            }
            return new ArrayList<>(tickets.values());
        } catch (SQLException ex) {
//            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Integer getNumberOfRaws() {
        Integer numOfRaws = 0;
        String sql = "SELECT COUNT(id) as count FROM tickets";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                numOfRaws = rs.getInt("count");
            }
            return numOfRaws;

        } catch (SQLException ex) {
//            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


    }

    @Override
    public List<Ticket> getTicketsPaginatedByUserId(Long userId, int currentPage, int recordsPerPage) {
        Map<Long, Ticket> tickets = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        String sql = String.format("SELECT * FROM tickets WHERE user_id = userId  LIMIT %d, %d",start,recordsPerPage);
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);

            TicketMapper ticketMapper = new TicketMapper();
            while (rs.next()) {
                Ticket ticket = ticketMapper
                        .extractFromResultSet(rs);
                ticket = ticketMapper
                        .makeUnique(tickets, ticket);
            }
            return new ArrayList<>(tickets.values());
        } catch (SQLException ex) {
//            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<TicketsCountAndTotalSum> countTicketsByUserGroupByEvent(Long userId){
        Map<Long, TicketsCountAndTotalSum> ticketsCounts = new HashMap<>();
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_COUNT_TICKETS_BY_USER_GROUP_BY_EVENT)) {
            int k=1;
            prst.setLong(k++, userId);
            ResultSet rs = prst.executeQuery();

            TicketsCountMapper ticketsCountMapper = new TicketsCountMapper();
            while (rs.next()) {
                TicketsCountAndTotalSum ticketsCount = ticketsCountMapper
                        .extractFromResultSet(rs);
                ticketsCount = ticketsCountMapper
                        .makeUnique(ticketsCounts, ticketsCount);
            }
            return new ArrayList<>(ticketsCounts.values());
        } catch (SQLException ex) {
//            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    };
    @Override
    public List<TicketsCountAndTotalSum> countTicketsByEventGroupUser(Long eventId){
        Map<Long, TicketsCountAndTotalSum> ticketsCounts = new HashMap<>();
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_COUNT_TICKETS_BY_EVENT_GROUP_BY_USER)) {
            int k=1;
            prst.setLong(k++, eventId);
            ResultSet rs = prst.executeQuery();

            TicketsCountMapper ticketsCountMapper = new TicketsCountMapper();
            while (rs.next()) {
                TicketsCountAndTotalSum ticketsCount = ticketsCountMapper
                        .extractFromResultSet(rs);
                ticketsCount = ticketsCountMapper
                        .makeUnique(ticketsCounts, ticketsCount);
            }
            return new ArrayList<>(ticketsCounts.values());
        } catch (SQLException ex) {
//            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    };
    @Override
    public List<TicketsCountAndTotalSum> finAllTicketsGroupByUser() throws SQLException {
        Map<Long, TicketsCountAndTotalSum> ticketsCounts = new HashMap<>();
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLConstant.SQL_FIND_ALL_TICKETS_GROUP_BY_USER);

            TicketsCountMapper ticketsCountMapper = new TicketsCountMapper();
            while (rs.next()) {
                TicketsCountAndTotalSum ticketsCount = ticketsCountMapper
                        .extractFromResultSet(rs);
                ticketsCount = ticketsCountMapper
                        .makeUnique(ticketsCounts, ticketsCount);
            }
            return new ArrayList<>(ticketsCounts.values());
        } catch (SQLException ex) {
//            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    };
    @Override
    public List<TicketsCountAndTotalSum> finAllTicketsGroupByEvent(){
        Map<Long, TicketsCountAndTotalSum> ticketsCounts = new HashMap<>();
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLConstant.SQL_FIND_ALL_TICKETS_GROUP_BY_EVENT);

            TicketsCountMapper ticketsCountMapper = new TicketsCountMapper();
            while (rs.next()) {
                TicketsCountAndTotalSum ticketsCount = ticketsCountMapper
                        .extractFromResultSet(rs);
                ticketsCount = ticketsCountMapper
                        .makeUnique(ticketsCounts, ticketsCount);
            }
            return new ArrayList<>(ticketsCounts.values());
        } catch (SQLException ex) {
//            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    };

    public Long getTicketsQuantityByEventId(Long eventId){
        Long ticketsQuantity=0L;

        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_QUANTITY_TICKETS_BY_EVENT_ID)){
            int k=1;
            prst.setLong(k++,eventId);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                ticketsQuantity = rs.getLong("quantity");

            }
            return ticketsQuantity;
        } catch (SQLException ex) {
//            Logger.getLogger(TicketService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally {

        }

    };
}
