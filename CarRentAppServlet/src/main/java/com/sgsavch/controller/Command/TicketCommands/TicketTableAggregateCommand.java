package com.sgsavch.controller.Command.TicketCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.Ticket;
import com.sgsavch.model.entity.agregates.TicketsCountAndTotalSum;
import com.sgsavch.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TicketTableAggregateCommand implements Command {
    TicketService ticketService;
    public TicketTableAggregateCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getServletContext().getAttribute("userId");
        System.out.println("(TicketTableAggregateCommand).userId= "+userId);
        List<TicketsCountAndTotalSum> ticketsCounts = ticketService.countTicketsByUserGroupByEvent(userId);
        request.setAttribute("ticketsCounts", ticketsCounts);

        return "/tickets_table.jsp";
    }
}
