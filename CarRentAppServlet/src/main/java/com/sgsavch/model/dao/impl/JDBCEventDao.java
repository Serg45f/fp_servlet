package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.EventDao;
import com.sgsavch.model.dao.SQLConstant;
import com.sgsavch.model.dao.mapper.EventMapper;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.Lecture;

import java.sql.*;
import java.util.*;

public class JDBCEventDao implements EventDao {
    private Connection connection;


    public JDBCEventDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Event entity) {

        return null;
    }


    @Override
    public Event findById(long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_EVENT_BY_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            ResultSet rs = prst.executeQuery();

            Event event = new Event();
            EventMapper eventMapper = new EventMapper();
            if (rs.next()) {
                event = eventMapper
                        .extractFromResultSet(rs);
            }
            return event;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Event> findAll() {
        Map<Long, Event> events = new HashMap<>();


        final String query = "select * from event";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            EventMapper eventMapper = new EventMapper();


            while (rs.next()) {
                Event event = eventMapper
                        .extractFromResultSet(rs);

                event = eventMapper
                        .makeUnique(events, event);

            }
            return new ArrayList<>(events.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Event entity) {

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
    public List<Event> getEvents(int currentPage, int recordsPerPage) {
        Map<Long, Event> events = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        String sql = String.format("SELECT * FROM event LIMIT %d, %d",start,recordsPerPage);
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);

            EventMapper eventMapper = new EventMapper();
            while (rs.next()) {
                Event event = eventMapper
                        .extractFromResultSet(rs);
                event = eventMapper
                        .makeUnique(events, event);
            }
            return new ArrayList<>(events.values());
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Integer getNumberOfCards() {
        Integer numOfCards = 0;
        String sql = "SELECT COUNT(id) as count FROM event";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                numOfCards = rs.getInt("count");
            }
            return numOfCards;

        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


    }
}
