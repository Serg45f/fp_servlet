package com.sgsavch.controller.Command.CarModel;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.enums.Hall;
import com.sgsavch.model.entity.enums.Language;
import com.sgsavch.model.entity.enums.StatusEvent;
import com.sgsavch.model.entity.enums.Theme;
import com.sgsavch.model.service.EventService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarmodelListCommand implements Command {
    private static final Integer DEFAULT_CURRENT_PAGE = 1;
    private static final Integer DEFAULT_RECORDS_PER_PAGE = 3;

    public CarmodelListCommand(EventService eventService) {
        this.eventService = eventService;
    }

    EventService eventService;

    public CarmodelListCommand() {
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

        List<Event> events = eventService.getEvents(currentPage, recordsPerPage);
        Event event = new Event();

        int rows = eventService.getNumberOfCards();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {

            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);

        event.setStatusEvent(StatusEvent.NEW);
        event.setThemes(new HashSet<>());
        request.setAttribute("event", event);
        request.setAttribute("events" , events);
        request.setAttribute("themes", Arrays.asList(Theme.values()));
        request.setAttribute("languages", Arrays.asList(Language.values()));
        request.setAttribute("places", Arrays.asList(Hall.values()));
//        request.setAttribute("roleAdmin", Role.ADMIN);


        return "/events.jsp";
    }
}
