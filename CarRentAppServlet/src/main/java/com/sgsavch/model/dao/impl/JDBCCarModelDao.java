package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.CarModelDao;
import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.mapper.CarModelMapper;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.CarModel.Builder;
import com.sgsavch.model.entity.enums.StatusCar;

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
        Long res = 0L;

        ResultSet rs = null;

        try(PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_ADD_NEW_CARMODEL, Statement.RETURN_GENERATED_KEYS)) {

            int k = 1;
            pstmt.setString(k++, entity.getName());
            pstmt.setInt(k++, entity.getSeatsNumb());
            pstmt.setInt(k++, entity.getDoorsNumb());
            pstmt.setString(k++, entity.getPicture());
            pstmt.setInt(k++, entity.getStatus().ordinal());
            pstmt.setInt(k++, entity.getType().ordinal());
            pstmt.setDouble(k++, entity.getPrice());
            pstmt.setDouble(k++, entity.getDeposit());

            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    entity = new Builder().setId(rs.getLong(1)).build();
                }
                res = rs.getLong(1);
            }
        } catch (SQLException e) {
//                logger.log(Level.WARNING,e.toString(),e);
//                logger.log(Level.INFO,"Cannot insert user ",e);
        } finally {
            //close(rs);
            close();
        }
        return res;

    }

    @Override
    public CarModel findById(long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_CARMODEL_BY_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            ResultSet rs = prst.executeQuery();

            CarModel carModel = new CarModel.Builder().build();
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
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_UPDATE_CARMODEL)) {

            int k = 1;
            pstmt.setString(k++, entity.getName());
            pstmt.setInt(k++, entity.getDoorsNumb());
            pstmt.setInt(k++, entity.getSeatsNumb());
            pstmt.setString(k++, entity.getPicture());
            pstmt.setString(k++, entity.getStatus().name());
            pstmt.setString(k++, entity.getType().name());
            pstmt.setDouble(k++, entity.getPrice());
            pstmt.setDouble(k++, entity.getDeposit());
            pstmt.setLong(k++,entity.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot update team ",e);
        }

    }

    @Override
    public boolean delete(Long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_DELETE_CARMODEL_BY_ID);) {

            int k = 1;
            prst.setLong(k++,id);
            prst.executeUpdate();

        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    static String escapeForLike(String param) {
        return param
                .replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");
    }
}
