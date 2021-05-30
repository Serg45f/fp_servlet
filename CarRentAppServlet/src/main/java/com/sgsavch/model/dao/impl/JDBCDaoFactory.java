package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();


    @Override
    public OrderDao createOrderDao() { return new JDBCOrderDao(getConnection());}
    @Override
    public CarModelDao createCarModelDao() { return new JDBCCarModelDao(getConnection());}
    @Override
    public VehicleDao createVehicleDao() { return new JDBCVehicleDao(getConnection());}
    @Override
    public OptionDao createOptionDao() { return new JDBCOptionDao(getConnection());}
    @Override
    public UserDao createUserDao() { return new JDBCUserDao(getConnection());}

    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
