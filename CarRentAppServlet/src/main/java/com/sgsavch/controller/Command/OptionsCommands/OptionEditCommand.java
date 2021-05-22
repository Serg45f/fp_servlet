package com.sgsavch.controller.Command.OptionsCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Arrays;

public class OptionEditCommand implements Command {

    public OptionEditCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    OptionService optionService ;

    public OptionEditCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long id = Long.valueOf(request.getParameter("optionId"));
        request.setAttribute("option", optionService.getOption(id));

        return "/optionEdit.jsp";
    }
}
