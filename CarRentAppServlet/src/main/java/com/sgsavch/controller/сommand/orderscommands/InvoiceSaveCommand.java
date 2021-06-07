package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Invoice;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.service.InvoiceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

public class InvoiceSaveCommand implements Command {
InvoiceService invoiceService;

public InvoiceSaveCommand(InvoiceService invoiceService){
    this.invoiceService = invoiceService;
}

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("currentOrder");
        Invoice invoice = new Invoice.Builder()
                .setNumber(order.getId())
                .setPaymentDate(LocalDateTime.now())
                .setIsPayed(true)
                .setOrder(order)
                .build();
        Long res = invoiceService.newInvoice(invoice);
        session.setAttribute("orderStage", 0);
        session.removeAttribute("currentOrder");
        return Path.PAGE__SUCCESS;
    }
}
