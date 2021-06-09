package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.OptionService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class OptionDeleteCommand implements Command {

    private static final Logger log = Logger.getLogger(OptionDeleteCommand.class);

    OptionService optionService ;

    public OptionDeleteCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        Long id = Long.valueOf(request.getParameter("optionId"));
        optionService.deleteOption(id);

        return Path.COMMAND__OPTIONS;
    }
}
