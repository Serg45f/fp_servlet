package com.sgsavch.controller.Command.OptionsCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;

public class OptionListCommand implements Command {

    public OptionListCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    OptionService optionService ;

    public OptionListCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        request.setAttribute("options" , optionService.getAllOptions());

        return "/options.jsp";
    }
}
