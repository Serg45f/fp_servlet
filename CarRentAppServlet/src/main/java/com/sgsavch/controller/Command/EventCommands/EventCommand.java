package com.sgsavch.controller.Command.EventCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.service.EventService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class EventCommand implements Command {
    public EventCommand(EventService eventService) {
        this.eventService = eventService;
    }

    EventService eventService;

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long eventId = Long.valueOf(request.getParameter("eventId"));
        Event event = eventService.getEvent(eventId);

        request.setAttribute("event", event);


        return "/event.jsp";
    }
}
