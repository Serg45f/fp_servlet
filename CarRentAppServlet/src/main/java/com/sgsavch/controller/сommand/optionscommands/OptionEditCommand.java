package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

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
