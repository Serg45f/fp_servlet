package com.sgsavch.controller.Command.EventCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.Lecture;
import com.sgsavch.model.service.EventService;
import com.sgsavch.model.service.LectureService;
import com.sgsavch.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EventCommand implements Command {
    public EventCommand(EventService eventService, TicketService ticketService, LectureService lectureService)
    {
        this.eventService = eventService;
        this.ticketService = ticketService;
        this.lectureService = lectureService;
    }

    EventService eventService;
    TicketService ticketService;
    LectureService lectureService;

    @Override
    public String execute(HttpServletRequest request) {
        Long eventId = Long.valueOf(request.getParameter("eventId"));
        Event event = eventService.getEvent(eventId);
        Long ticketsSold = ticketService.getTicketsQuantityByEventId(eventId);
        List<Lecture> lectures = lectureService.getLecturesByEventId(eventId);
       // Integer ticketsLeft = event.getPlace().placesLeft(Math.toIntExact(ticketsSold));

        request.setAttribute("event", event);
       // request.setAttribute("ticketsLeft", ticketsLeft);


        return "/event.jsp";
    }
}
