package com.sgsavch.controller.Command.TicketCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.Ticket;
import com.sgsavch.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TicketListCommand implements Command {
    private static final Integer DEFAULT_CURRENT_PAGE = 1;
    private static final Integer DEFAULT_RECORDS_PER_PAGE = 3;

    public TicketListCommand(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    TicketService ticketService;

    public TicketListCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        int currentPage = DEFAULT_CURRENT_PAGE;
        int recordsPerPage = DEFAULT_RECORDS_PER_PAGE;

        if(request.getParameter("tPage")!=null){
            currentPage = Integer.parseInt(request.getParameter("tPage"));
        }

        if(request.getParameter("recordsPerPage")!=null){
            recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
        }

        List<Ticket> tickets = ticketService.getTicketPaginated(currentPage, recordsPerPage);
        Event event = new Event();

        int rows = ticketService.getNumberOfRaws();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);


        request.setAttribute("ticket", event);
        request.setAttribute("tickets" , tickets);




        return "/tickets.jsp";
    }
}
