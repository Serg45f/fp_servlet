package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.LectureDao;
import com.sgsavch.model.dao.SQLConstant;
import com.sgsavch.model.dao.mapper.LectureMapper;
import com.sgsavch.model.entity.Lecture;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCLectureDao implements LectureDao {
    private Connection connection;


    public JDBCLectureDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Lecture entity) {

        return null;
    }

    @Override
    public Lecture findById(long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_EVENT_BY_ID)) {

            int k = 1;
            prst.setLong(k++, id);
            ResultSet rs = prst.executeQuery();

            Lecture lecture = new Lecture();
            LectureMapper lectureMapper = new LectureMapper();
            if (rs.next()) {
                lecture = lectureMapper
                        .extractFromResultSet(rs);
            }
            return lecture;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }



    @Override
    public List<Lecture> findAll() {
        Map<Long, Lecture> lectures = new HashMap<>();

        final String query = "select * from lecture";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            LectureMapper lectureMapper = new LectureMapper();
            while (rs.next()) {
                Lecture lecture = lectureMapper
                        .extractFromResultSet(rs);
                lecture = lectureMapper
                        .makeUnique(lectures, lecture);
            }
            return new ArrayList<>(lectures.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Lecture> getLecturesByEventId(Long eventId) {
        Map<Long, Lecture> lectures = new HashMap<>();


        String sql = String.format("SELECT * FROM lectures WHERE event_id = ?");
        try (PreparedStatement prst = connection.prepareStatement(sql)) {
            int k = 1;
            prst.setLong(k++, eventId);
            ResultSet rs = prst.executeQuery();

            LectureMapper lectureMapper = new LectureMapper();
            while (rs.next()) {
                Lecture lecture = lectureMapper
                        .extractFromResultSet(rs);
                lecture = lectureMapper
                        .makeUnique(lectures, lecture);
            }
            return new ArrayList<>(lectures.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

        @Override
    public void update(Lecture entity) {

    }


    @Override
    public boolean delete(Long id) {

        return false;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lecture> getLecturesPaginated(int currentPage, int recordsPerPage) {
        Map<Long, Lecture> lectures = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        String sql = String.format("SELECT * FROM lecture LIMIT %d, %d", start, recordsPerPage);
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);

            LectureMapper lectureMapper = new LectureMapper();
            while (rs.next()) {
                Lecture lecture = lectureMapper
                        .extractFromResultSet(rs);
                lecture = lectureMapper
                        .makeUnique(lectures, lecture);
            }
            return new ArrayList<>(lectures.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Integer getNumberOfRaws() {
        Integer numOfCards = 0;
        String sql = "SELECT COUNT(id) as count FROM lecture";
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

