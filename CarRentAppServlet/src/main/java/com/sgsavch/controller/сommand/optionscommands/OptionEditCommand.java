package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.OptionService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class OptionEditCommand implements Command {

    private static final Logger log = Logger.getLogger(OptionEditCommand.class);

    OptionService optionService ;

    public OptionEditCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        Long id = Long.valueOf(request.getParameter("optionId"));
        request.setAttribute("option", optionService.getOption(id));

        return Path.PAGE__OPTION_EDIT;
    }
}
