package com.sgsavch.controller.Command.OptionsCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;

public class OptionDeleteCommand implements Command {

    public OptionDeleteCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    OptionService optionService ;

    public OptionDeleteCommand() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("optionId"));
        optionService.deleteOption(id);

        return "/options";
    }
}
