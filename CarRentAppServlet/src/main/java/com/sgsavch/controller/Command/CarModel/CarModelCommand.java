package com.sgsavch.controller.Command.CarModel;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.Lecture;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.EventService;
import com.sgsavch.model.service.LectureService;
import com.sgsavch.model.service.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CarModelCommand implements Command {
    public CarModelCommand(CarModelService carModelService)
    {
        this.carModelService = carModelService;
    }

    CarModelService carModelService;

    @Override
    public String execute(HttpServletRequest request) {
        Long carmodelId = Long.valueOf(request.getParameter("carmodelId"));
        CarModel carModel = carModelService.getCarmodel(carmodelId);
//       carModel.setStatusCar(StatusCar.BUDGET);
//        carModel.setThemes(new HashSet<>());
//        request.setAttribute("event", event);
//        request.setAttribute("events" , events);
//        request.setAttribute("themes", Arrays.asList(Theme.values()));
//        request.setAttribute("languages", Arrays.asList(Language.values()));
//        request.setAttribute("places", Arrays.asList(Hall.values()));
//        Long ticketsSold = ticketService.getTicketsQuantityByEventId(eventId);
//        List<Lecture> lectures = lectureService.getLecturesByEventId(eventId);
//        Integer ticketsLeft = event.getPlace().placesLeft(Math.toIntExact(ticketsSold));

//        request.setAttribute("event", event);
//        request.setAttribute("ticketsLeft", ticketsLeft);


        return "/carmodel_edit.jsp";
    }
}
