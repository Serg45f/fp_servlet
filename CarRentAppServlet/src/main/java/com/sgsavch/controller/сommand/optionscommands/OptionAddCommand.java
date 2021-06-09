package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.carmodelcommands.CarModelSaveCommand;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.service.OptionService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class OptionAddCommand implements Command {

    private static final Logger log = Logger.getLogger(OptionAddCommand.class);

    OptionService optionService ;

    public OptionAddCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        request.setAttribute("option", new Option.Builder().build());

        return Path.PAGE__OPTION_EDIT;
    }
}
