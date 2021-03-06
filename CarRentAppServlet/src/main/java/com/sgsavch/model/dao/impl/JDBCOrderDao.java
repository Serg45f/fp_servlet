package com.sgsavch.model.dao.impl;


import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.mapper.OrderMapper;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.StatusOrder;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class JDBCOrderDao implements OrderDao {


    private Connection connection;


    public JDBCOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Order entity) {
        Long res = 0L;

        ResultSet rs = null;

        try(PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_ADD_NEW_ORDER, Statement.RETURN_GENERATED_KEYS)) {

            int k = 1;
            pstmt.setString(k++, entity.getCode());
            pstmt.setString(k++, entity.getQrcode());
            pstmt.setDate(k++,Date.valueOf(entity.getStart().toLocalDate()));
            pstmt.setDate(k++, Date.valueOf(entity.getEnd().toLocalDate()));
            pstmt.setLong(k++, entity.getUser().getId());
            pstmt.setInt(k++, entity.getLocation().ordinal());
            pstmt.setLong(k++, entity.getVehicle().getId());
            pstmt.setInt(k++, entity.getStatus().ordinal());
            pstmt.setInt(k++, entity.getDays());
            pstmt.setDouble(k++, entity.getPricePeriod());
            pstmt.setDouble(k++, entity.getPriceOptions());
            pstmt.setDouble(k++, entity.getTotalPrice());

            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    entity = new Order.Builder().setId(rs.getLong(1)).build();
                }
                res = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
//                logger.log(Level.WARNING,e.toString(),e);
//                logger.log(Level.INFO,"Cannot insert user ",e);
        } finally {
            if(connection!=null)close();
        }
        return res;
    }

    @Override
    public boolean setOrderOptions(Order order, List<Option> options)  {
        boolean res = false;

        try {
            Statement st = connection.createStatement();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            for (Option option : options) {
                addOrderOption(connection, order.getId(), option);
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot set teams for user ",e);
            if(connection!=null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            if(connection!=null)close();
//            logger.log(Level.INFO,"Connection is closed");
        }
        return res;
    }

    @Override
    public boolean resetOrderOptions(Order order, List<Option> options) throws SQLException {
        boolean res = false;

        try {
            Statement st = connection.createStatement();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            delete(order.getId());

            for (Option option : options) {
                addOrderOption(connection, order.getId(), option);
                System.out.println(connection.toString());
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot set teams for user ",e);
            if(connection!=null)connection.rollback();
        } finally {
            if(connection!=null)close();
//            logger.log(Level.INFO,"Connection is closed");
        }
        return res;
    }

    private void addOrderOption(Connection con, long id, Option option) throws SQLException {


        try (PreparedStatement pstmt = con.prepareStatement(SQLConstant.SQL_ADD_OPTION_TO_ORDER)){

            int k = 1;
            pstmt.setLong(k++, id);
            pstmt.setLong(k++, option.getId());

            pstmt.executeUpdate();
        }

    }

    public void deleteOrderOptions(Long id){
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_DELETE_OPTIONS_BY_ORDER_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            prst.executeUpdate();

        } catch (SQLException ex) {

//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void update(Order entity) throws SQLException{
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_UPDATE_ORDER)) {

            int k = 1;
            if(entity.getRealEnd() != null){
                pstmt.setDate(k++,Date.valueOf(entity.getRealEnd().toLocalDate()));
            }else{
                pstmt.setObject(k++,null);
            }
            pstmt.setString(k++, entity.getDamageDescript());
            pstmt.setDouble(k++, entity.getDamagePrice());
            pstmt.setBoolean(k++, entity.getDamageIsPayed());
            if(entity.getStatus() != null){
                pstmt.setInt(k++, entity.getStatus().ordinal());
            }else{
                pstmt.setObject(k++,null);
            }

            pstmt.setLong(k++,entity.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot update team ",e);
        }finally {
            if (connection != null) close();
        }

    }

    @Override
    public boolean setToArcive(Long id) throws SQLException{
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_SET_TO_ARCHIVE_ORDER_BY_ID)) {

            int k = 1;
            prst.setInt(k++, StatusOrder.ARCHIVE.ordinal());
            prst.setLong(k++,id);

            prst.executeUpdate();
            return true;
        } catch (SQLException ex) {
           // log.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
            if (connection != null) close();
            return false;

    }

    @Override
    public boolean delete(Long id) throws SQLException{
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
    public List<Order> getOrdersByManager(Long userId, int currentPage, int recordsPerPage) {
        Map<Long, Order> orders = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_ORDERS_BY_MANAGER_PAGINATED)) {
            int k = 1;
            prst.setLong(k++,userId);
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

    @Override
    public Integer getNumberOfRowsByManager(Long userId) {
        Integer numOfCards = 0;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_NUMBER_OF_CARDS_ORDERS_BY_MANAGER)) {
            int k = 1;
            prst.setLong(k++,userId);
            ResultSet rs = prst.executeQuery();
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
