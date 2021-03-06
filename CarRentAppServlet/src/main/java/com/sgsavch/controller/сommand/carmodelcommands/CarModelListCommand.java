package com.sgsavch.controller.сommand.carmodelcommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.service.CarModelService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CarModelListCommand implements Command {
    private static final Logger log = Logger.getLogger(CarModelListCommand.class);

    private static final Integer DEFAULT_CURRENT_PAGE = 1;
    private static final Integer DEFAULT_RECORDS_PER_PAGE = 3;

    CarModelService carModelService;

    public CarModelListCommand(CarModelService carModelService) {
        this.carModelService = carModelService;
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

        List<CarModel> carModels = carModelService.getCarModelsPaginated(currentPage, recordsPerPage);

        int rows = carModelService.getNumberOfCards();

        int nOfPages = rows / recordsPerPage;

        if (nOfPages % recordsPerPage > 0) {
            nOfPages++;
        }

        request.setAttribute("noOfPages", nOfPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("recordsPerPage", recordsPerPage);
        request.setAttribute("carmodels" , carModels);

        return Path.PAGE__CARMODELS;
    }
}
