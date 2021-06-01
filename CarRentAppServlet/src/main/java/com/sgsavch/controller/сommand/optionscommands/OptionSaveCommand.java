package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.controller.сommand.Command;
import com.sgsavch.controller.сommand.CommandContainer;
import com.sgsavch.model.dao.mapper.OptionMapper;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.service.OptionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class OptionSaveCommand implements Command {
    public OptionSaveCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    OptionService optionService ;


    @Override
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {
        Option.Builder optionBuilder = new Option.Builder();
        System.out.println("(OptionSaveCommand.execute");

        Long res = optionService.addOption(new OptionMapper().extractFromRequest(request));

        Command command = CommandContainer.get("options");
        String page = command.execute(request);

        return "redirect:" + page;
    }
}
