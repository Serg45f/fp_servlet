package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.optionscommands.OptionSaveCommand;
import com.sgsavch.model.entity.Invoice;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.enums.Location;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Arrays;

public class InvoiceCommand implements Command {
    private static final Logger log = Logger.getLogger(InvoiceCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.setAttribute("orderStage", -1);

        return Path.PAGE__INVOICE;
    }
}
