package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;

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
