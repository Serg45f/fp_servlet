package com.sgsavch.controller.Command.OptionsCommands;

import com.sgsavch.controller.Command.Command;
import com.sgsavch.model.dao.mapper.OptionMapper;
import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;
import com.sgsavch.model.service.CarModelService;
import com.sgsavch.model.service.OptionService;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class OptionSaveCommand implements Command {
    public OptionSaveCommand(OptionService optionService) {
        this.optionService = optionService;
    }

    OptionService optionService ;


    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        System.out.println("(OptionSaveCommand.execute");
        Option option = new Option();
        Long res = optionService.addOption(new OptionMapper().extractFromRequest(request));
        option.setId(res);

        return "/servlet/options";
    }
}
