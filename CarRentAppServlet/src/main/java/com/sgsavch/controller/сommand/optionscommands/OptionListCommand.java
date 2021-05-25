package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

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
