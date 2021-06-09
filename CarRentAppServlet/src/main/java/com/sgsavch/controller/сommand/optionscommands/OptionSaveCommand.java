package com.sgsavch.controller.сommand.optionscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.dao.mapper.OptionMapper;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.service.OptionService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class OptionSaveCommand implements Command {

    private static final Logger log = Logger.getLogger(OptionSaveCommand.class);

    OptionService optionService ;

    public OptionSaveCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException, IOException, ServletException {
        Option.Builder optionBuilder = new Option.Builder();

        Long res = optionService.addOption(new OptionMapper().extractFromRequest(request));

        return Path.COMMAND__OPTIONS;
    }
}
