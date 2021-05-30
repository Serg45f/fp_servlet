package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.OptionDao;
import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.mapper.CarModelMapper;
import com.sgsavch.model.dao.mapper.OptionMapper;
import com.sgsavch.model.dao.mapper.OrderMapper;
import com.sgsavch.model.dao.mapper.VehicleMapper;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCOptionDao implements OptionDao {
    private Connection connection;


    public JDBCOptionDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Option entity) {
        Long res = 0L;
        ResultSet rs = null;
        try(PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_ADD_NEW_OPTION, Statement.RETURN_GENERATED_KEYS)) {
            int k = 1;
            pstmt.setString(k++, entity.getDescription());
            pstmt.setString(k++, entity.getName());
            pstmt.setString(k++, entity.getPicture());
            pstmt.setDouble(k++, entity.getPrice());

            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    entity = new Option.Builder().setId(rs.getLong(1)).build();
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
    public Option findById(long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_OPTION_BY_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            ResultSet rs = prst.executeQuery();

            Option option = new Option.Builder().build();
            OptionMapper optionMapper = new OptionMapper();
            if (rs.next()) {
                option = optionMapper
                        .extractFromResultSet(rs);
            }
            return option;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Option> findAll() {
        Map<Long, Option> options = new HashMap<>();

        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SQLConstant.SQL_GET_ALL_OPTIONS);
            OptionMapper optionMapper = new OptionMapper();
            while (rs.next()) {
                Option option = optionMapper
                        .extractFromResultSet(rs);
                option = optionMapper
                        .makeUnique(options, option);
            }
            return new ArrayList<>(options.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Option entity) {
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_UPDATE_OPTION)) {

            int k = 1;
            pstmt.setString(k++, entity.getDescription());
            pstmt.setString(k++, entity.getName());
            pstmt.setString(k++, entity.getPicture());
            pstmt.setDouble(k++, entity.getPrice());
            pstmt.setLong(k++,entity.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot update team ",e);
        }
    }

    @Override
    public boolean delete(Long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_DELETE_OPTION_BY_ID);) {

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
    public List<Option> getOptionsByOrderId(Long orderId) {
        Map<Long, Option> options = new HashMap<>();
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_OPTIONS_BY_ORDER_ID)) {

            int k = 1;
            prst.setLong(k++,orderId);
            ResultSet rs = prst.executeQuery();

            OptionMapper optionMapper = new OptionMapper();
            while (rs.next()) {
                Option option = optionMapper
                        .extractFromResultSet(rs);
                option = optionMapper
                        .makeUnique(options, option);
            }
            return new ArrayList<>(options.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
