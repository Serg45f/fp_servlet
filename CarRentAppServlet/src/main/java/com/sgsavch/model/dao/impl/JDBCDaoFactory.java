package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();


    @Override
    public EventDao createEventDao() {
        return new JDBCEventDao(getConnection());
    }

    public CarModelDao createCarModelDao() { return new JDBCCarModelDao(getConnection());}

    @Override
    public UserDao createUserDao() { return new JDBCUserDao(getConnection());}

    @Override
    public TicketDao createTicketDao() {return new JDBCTicketDao(getConnection());}

    @Override
    public LectureDao createLectureDao() {return new JDBCLectureDao(getConnection());}

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
