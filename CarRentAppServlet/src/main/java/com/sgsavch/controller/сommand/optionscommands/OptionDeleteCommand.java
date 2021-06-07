package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class OptionDeleteCommand implements Command {

    public OptionDeleteCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    OptionService optionService ;

    public OptionDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        Long id = Long.valueOf(request.getParameter("optionId"));
        optionService.deleteOption(id);

        return Path.PAGE__OPTIONS;
    }
}
