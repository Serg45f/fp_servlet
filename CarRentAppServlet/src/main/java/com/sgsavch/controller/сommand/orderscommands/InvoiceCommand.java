package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Invoice;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.Location;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Arrays;

public class InvoiceCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Hello from InvoiceCommand");
        HttpSession session = request.getSession();

        session.setAttribute("orderStage", -1);

        return Path.PAGE__INVOICE;
    }
}
