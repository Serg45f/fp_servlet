package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InvoiceSaveCommand implements Command {


    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("Hello from InvoiceCommand");
        HttpSession session = request.getSession();

        session.setAttribute("orderStage", -1);

        return Path.PAGE__SUCCESS;
    }
}
