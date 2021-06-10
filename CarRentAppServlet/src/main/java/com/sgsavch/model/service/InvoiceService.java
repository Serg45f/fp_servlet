package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.InvoiceDao;
import com.sgsavch.model.dao.OrderDao;
import com.sgsavch.model.entity.Invoice;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class InvoiceService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Invoice> getAllInvoices() throws SQLException {
        try (InvoiceDao dao = daoFactory.createInvoiceDao()) {
            return dao.findAll();
        }
    }

    public List<Invoice> getInvoicesPaginated(int currentPage, int recordsPerPage) {
        try (InvoiceDao dao = daoFactory.createInvoiceDao()) {
            return dao.getInvoices(currentPage,recordsPerPage);
        }
    }

    public int getNumberOfCards() {
        try (InvoiceDao dao = daoFactory.createInvoiceDao()) {
            return dao.getNumberOfCards();
        }
    }

    public Invoice getInvoice(Long invoiceId) throws SQLException {
        try (InvoiceDao dao = daoFactory.createInvoiceDao()) {
            return dao.findById(invoiceId);
        }
    }

    public Long newInvoice(Invoice invoice) throws SQLException {
        try (InvoiceDao dao = daoFactory.createInvoiceDao()) {
            return dao.create(invoice);
        }
    }

}
