package com.sgsavch.model.dao.impl;


import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.mapper.OrderMapper;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.Location;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCOrderDao implements OrderDao {
    private Connection connection;


    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Order entity) {
        Long res = 0L;

        ResultSet rs = null;

        try(PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_ADD_NEW_CARMODEL, Statement.RETURN_GENERATED_KEYS)) {

            int k = 1;
            pstmt.setString(k++, entity.getCode());
            pstmt.setString(k++, entity.getQrcode());
            pstmt.setDate(k++,Date.valueOf(entity.getStart().toLocalDate()));
            pstmt.setDate(k++, Date.valueOf(entity.getEnd().toLocalDate()));
            pstmt.setLong(k++, entity.getUser().getId());
            pstmt.setInt(k++, entity.getLocation().ordinal());
            pstmt.setLong(k++, entity.getVehicle().getId());
            pstmt.setInt(k++, entity.getStatus().ordinal());

            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    entity = new Order.Builder().setId(rs.getLong(1)).build();
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
    public Order findById(long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_ORDER_BY_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            ResultSet rs = prst.executeQuery();

            Order order = new Order.Builder().build();
            OrderMapper orderMapper = new OrderMapper();
            if (rs.next()) {
                order = orderMapper
                        .extractFromResultSet(rs);
            }
            return order;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public List<Order> findAll() {
        Map<Long, Order> orders = new HashMap<>();


        final String GET_ALL_ORDERS = "select * from event";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(GET_ALL_ORDERS);

            OrderMapper orderMapper = new OrderMapper();


            while (rs.next()) {
                Order order = orderMapper
                        .extractFromResultSet(rs);

                order = orderMapper
                        .makeUnique(orders, order);

            }
            return new ArrayList<>(orders.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Order entity) {
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_UPDATE_ORDER)) {

            int k = 1;
            pstmt.setDate(k++, Date.valueOf(entity.getRealEnd().toLocalDate()));
            pstmt.setString(k++, entity.getDamageDescript());
            pstmt.setDouble(k++, entity.getDamagePrice());
            pstmt.setBoolean(k++, entity.getDamageIsPayed());
            pstmt.setInt(k++, entity.getStatus().ordinal());
            pstmt.setLong(k++,entity.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot update team ",e);
        }


    }


    @Override
    public boolean delete(Long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_DELETE_ORDER_BY_ID);) {

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
    public List<Order> getOrders(int currentPage, int recordsPerPage) {
        Map<Long, Order> orders = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_ORDERS_PAGINATED)) {
            int k = 1;
            prst.setInt(k++,start);
            prst.setInt(k++,recordsPerPage);
            ResultSet rs = prst.executeQuery();
            OrderMapper orderMapper = new OrderMapper();
            while (rs.next()) {
                Order order = orderMapper
                        .extractFromResultSet(rs);
                order = orderMapper
                        .makeUnique(orders, order);
            }
            return new ArrayList<>(orders.values());
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Integer getNumberOfCards() {
        Integer numOfCards = 0;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(SQLConstant.SQL_GET_NUMBER_OF_CARDS_ORDERS);
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
