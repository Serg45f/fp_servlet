package com.sgsavch.controller.Command.OptionsCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class OptionAddCommand implements Command {

    public OptionAddCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    OptionService optionService ;

    public OptionAddCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("option", new Option());
        return "/optionEdit.jsp";
    }
}
