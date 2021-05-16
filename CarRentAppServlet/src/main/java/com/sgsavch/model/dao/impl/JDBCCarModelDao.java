package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.CarModelDao;
import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.mapper.CarModelMapper;
import com.sgsavch.model.entity.CarModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCCarModelDao implements CarModelDao {
    private Connection connection;

    public JDBCCarModelDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(CarModel entity) {

        return null;
    }

    @Override
    public CarModel findById(long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_CARMODEL_BY_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            ResultSet rs = prst.executeQuery();

            CarModel carModel = new CarModel();
            CarModelMapper carmodelMapper = new CarModelMapper();
            if (rs.next()) {
                carModel = carmodelMapper
                        .extractFromResultSet(rs);
            }
            return carModel;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<CarModel> findAll() {
        Map<Long, CarModel> carModels = new HashMap<>();

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SQLConstant.SQL_GET_ALL_CARMODELS);
            CarModelMapper carModelMapper = new CarModelMapper();
            while (rs.next()) {
                CarModel carModel = carModelMapper
                        .extractFromResultSet(rs);
                carModel = carModelMapper
                        .makeUnique(carModels, carModel);
            }
            return new ArrayList<>(carModels.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(CarModel entity) {
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
    public List<CarModel> getCarModels(int currentPage, int recordsPerPage) {
        Map<Long, CarModel> carModels = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_CARMODELS_PAGINATED)) {
            int k = 1;
            prst.setInt(k++,start);
            prst.setInt(k++,recordsPerPage);
            ResultSet rs = prst.executeQuery();
            CarModelMapper carModelMapper = new CarModelMapper();
            while (rs.next()) {
                CarModel carModel = carModelMapper
                        .extractFromResultSet(rs);
                carModel = carModelMapper
                        .makeUnique(carModels, carModel);
            }
            return new ArrayList<>(carModels.values());
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Integer getNumberOfCards() {
        Integer numOfCards = 0;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SQLConstant.SQL_GET_NUMBER_OF_CARDS_CARMODELS);
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
