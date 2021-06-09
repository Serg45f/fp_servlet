package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.service.OptionService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class OptionListCommand implements Command {

    private static final Logger log = Logger.getLogger(OptionListCommand.class);

    OptionService optionService ;

    public OptionListCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {

        request.setAttribute("options" , optionService.getAllOptions());

        return Path.PAGE__OPTIONS;
    }
}
