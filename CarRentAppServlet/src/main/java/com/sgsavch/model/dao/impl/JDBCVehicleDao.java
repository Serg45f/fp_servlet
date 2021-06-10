package com.sgsavch.model.dao.impl;


import com.sgsavch.controller.сommand.orderscommands.InvoiceCommand;
import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.VehicleDao;
import com.sgsavch.model.dao.mapper.VehicleMapper;
import com.sgsavch.model.entity.Vehicle;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCVehicleDao implements VehicleDao {
    private static final Logger log = Logger.getLogger(JDBCVehicleDao.class);
    private Connection connection;

    public JDBCVehicleDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Vehicle entity) throws SQLException{
        Long res = 0L;

        ResultSet rs = null;

        try(PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_ADD_NEW_VEHICLE, Statement.RETURN_GENERATED_KEYS)) {

            int k = 1;
            pstmt.setInt(k++, entity.getColor().ordinal());
            pstmt.setString(k++, entity.getRegNumber());
            pstmt.setString(k++, entity.getTransmission());
            pstmt.setDate(k++, Date.valueOf(entity.getYearIssue().toLocalDate()));
            pstmt.setDouble(k++, entity.getDiscount());
            pstmt.setLong(k++, entity.getCarModel().getId());
            pstmt.setLong(k++, entity.getManager().getId());
            pstmt.setBoolean(k++, entity.isNew());


            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    entity = new Vehicle.Builder().setId(rs.getLong(1)).build();
                }
                res = rs.getLong(1);
            }
        } catch (SQLException e) {
            log.warn(e.toString(),e);
            log.debug("Cannot insert vehicle ",e);
        } finally {
            //close(rs);
            close();
        }
        return res;
    }

    @Override
    public Vehicle findById(long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_VEHICLE_BY_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            ResultSet rs = prst.executeQuery();

            Vehicle vehicle = new Vehicle.Builder().build();
            VehicleMapper vehicleMapper = new VehicleMapper();
            if (rs.next()) {
                vehicle = vehicleMapper
                        .extractFromResultSet(rs);
            }
            return vehicle;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Vehicle> findAll() {
        Map<Long, Vehicle> vehicles = new HashMap<>();

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SQLConstant.SQL_GET_ALL_VEHICLES);
            VehicleMapper vehicleMapper = new VehicleMapper();
            while (rs.next()) {
                Vehicle vehicle = vehicleMapper
                        .extractFromResultSet(rs);
                vehicle = vehicleMapper
                        .makeUnique(vehicles, vehicle);
            }
            return new ArrayList<>(vehicles.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Vehicle entity) throws SQLException{
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_UPDATE_VEHICLE)) {

            int k = 1;
            pstmt.setString(k++, entity.getColor().name());
            pstmt.setString(k++, entity.getRegNumber());
            pstmt.setString(k++, entity.getTransmission());
            pstmt.setLong(k++, entity.getCarModel().getId());
            pstmt.setDate(k++, Date.valueOf(entity.getYearIssue().toLocalDate()));
            pstmt.setDouble(k++, entity.getDiscount());
            pstmt.setLong(k++, entity.getManager().getId());
            pstmt.setBoolean(k++, entity.isNew());
            pstmt.setLong(k++,entity.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.warn(e.toString(),e);
            log.debug("Cannot update vehicle ",e);
        }

    }

    @Override
    public boolean delete(Long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_DELETE_VEHICLE_BY_ID);) {

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
    public List<Vehicle> getVehicles(int currentPage, int recordsPerPage) {
        Map<Long, Vehicle> vehicles = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_VEHICLES_PAGINATED)) {
            int k = 1;
            prst.setInt(k++,start);
            prst.setInt(k++,recordsPerPage);
            ResultSet rs = prst.executeQuery();
            VehicleMapper vehicleMapper = new VehicleMapper();
            while (rs.next()) {
                Vehicle vehicle = vehicleMapper
                        .extractFromResultSet(rs);
                vehicle = vehicleMapper
                        .makeUnique(vehicles, vehicle);
            }
            return new ArrayList<>(vehicles.values());
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Vehicle> getVehiclesByPeriod(LocalDateTime startPeriod, LocalDateTime endPeriod, int currentPage, int recordsPerPage) {
        Map<Long, Vehicle> vehicles = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_VEHICLES_PAGINATED_BY_PERIOD)) {
            int k = 1;
            prst.setDate(k++,Date.valueOf(startPeriod.toLocalDate()));
            prst.setDate(k++,Date.valueOf(endPeriod.toLocalDate()));
            prst.setInt(k++,start);
            prst.setInt(k++,recordsPerPage);
            ResultSet rs = prst.executeQuery();
            VehicleMapper vehicleMapper = new VehicleMapper();
            while (rs.next()) {
                Vehicle vehicle = vehicleMapper
                        .extractFromResultSet(rs);
                vehicle = vehicleMapper
                        .makeUnique(vehicles, vehicle);
            }
            return new ArrayList<>(vehicles.values());
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Integer getNumberOfCards() {
        Integer numOfCards = 0;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SQLConstant.SQL_GET_NUMBER_OF_CARDS_VEHICLES);

            while (rs.next()) {
                numOfCards = rs.getInt("count");
            }
            return numOfCards;

        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


    }

    @Override
    public Integer getNumberOfCardsPeriod(LocalDateTime startPeriod, LocalDateTime endPeriod) {
        Integer numOfCards = 0;
        ResultSet rs = null;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_NUMBER_OF_CARDS_VEHICLES_PERIOD)) {
            int k = 1;
            prst.setDate(k++,Date.valueOf(startPeriod.toLocalDate()));
            prst.setDate(k++,Date.valueOf(endPeriod.toLocalDate()));
            rs = prst.executeQuery();
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
