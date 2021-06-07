package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Invoice;

import java.util.List;


public interface InvoiceDao extends GenericDao<Invoice> {
    List<Invoice> getInvoices(int currentPage, int numOfRecords);
    Integer getNumberOfCards();


}

