package com.sgsavch.model.dao.impl;


import com.sgsavch.model.dao.InvoiceDao;
import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.mapper.InvoiceMapper;
import com.sgsavch.model.dao.mapper.OrderMapper;
import com.sgsavch.model.entity.Invoice;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCInvoiceDao implements InvoiceDao {
    private Connection connection;


    public JDBCInvoiceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Invoice entity) {
        Long res = 0L;

        ResultSet rs = null;

        try(PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_ADD_NEW_INVOICE, Statement.RETURN_GENERATED_KEYS)) {

            int k = 1;
            pstmt.setLong(k++, entity.getOrder().getId());
            pstmt.setBoolean(k++, entity.isPayed());
            pstmt.setDate(k++,Date.valueOf(entity.getPaymentDate().toLocalDate()));
            pstmt.setLong(k++, entity.getNumber());

            if (pstmt.executeUpdate() > 0) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    entity = new Invoice.Builder().setId(rs.getLong(1)).build();
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
    public Invoice findById(long id) {
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_INVOICES_BY_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            ResultSet rs = prst.executeQuery();

            Invoice invoice = new Invoice.Builder().build();
            InvoiceMapper invoiceMapper = new InvoiceMapper();
            if (rs.next()) {
                invoice = invoiceMapper
                        .extractFromResultSet(rs);
            }
            return invoice;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Invoice> findAll() {
        Map<Long, Invoice> invoices = new HashMap<>();

        final String GET_ALL_INVOICES = "select * from invoice";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(GET_ALL_INVOICES);

            InvoiceMapper invoiceMapper = new InvoiceMapper();
            while (rs.next()) {
                Invoice invoice = invoiceMapper
                        .extractFromResultSet(rs);

                invoice = invoiceMapper
                        .makeUnique(invoices, invoice);

            }
            return new ArrayList<>(invoices.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Invoice entity) {
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_UPDATE_INVOICE)) {

            int k = 1;
            pstmt.setLong(k++, entity.getOrder().getId());
            pstmt.setBoolean(k++, entity.isPayed());
            pstmt.setDate(k++,Date.valueOf(entity.getPaymentDate().toLocalDate()));
            pstmt.setLong(k++, entity.getNumber());
            pstmt.setLong(k++,entity.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot update team ",e);
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException{
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_DELETE_INVOICE_BY_ID);) {

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
    public List<Invoice> getInvoices(int currentPage, int recordsPerPage) {
        Map<Long, Invoice> invoices = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_INVOICES_PAGINATED)) {
            int k = 1;
            prst.setInt(k++,start);
            prst.setInt(k++,recordsPerPage);
            ResultSet rs = prst.executeQuery();
            InvoiceMapper invoiceMapper = new InvoiceMapper();
            while (rs.next()) {
                Invoice invoice = invoiceMapper
                        .extractFromResultSet(rs);
                invoice = invoiceMapper
                        .makeUnique(invoices, invoice);
            }
            return new ArrayList<>(invoices.values());
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
