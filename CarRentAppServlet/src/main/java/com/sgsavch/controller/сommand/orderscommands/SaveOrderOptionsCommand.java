package com.sgsavch.controller.сommand.orderscommands;

import com.sgsavch.Path;
import com.sgsavch.controller.сommand.Command;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.StatusOrder;
import com.sgsavch.model.service.OptionService;
import com.sgsavch.model.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SaveOrderOptionsCommand implements Command {
    private static final Logger log = Logger.getLogger(SaveOrderOptionsCommand.class);

    OptionService optionService;

    public SaveOrderOptionsCommand(OptionService optionService){
        this.optionService = optionService;
    }

    @Override
    public String execute(HttpServletRequest request) throws SQLException {
        HttpSession session = request.getSession();

        Order newOrder = (Order) session.getAttribute("currentOrder");
        List<Option> options = optionService.getAllOptions();
        String[] checkedOptionsStr = request.getParameterValues("checkedOptions");
        Double optionsTotalPrice=0D;
        if(checkedOptionsStr != null) {
            List<Long> checkedOptions = Arrays.stream(checkedOptionsStr).map(e->Long.valueOf(e)).collect(Collectors.toList());
            newOrder.getOptions().clear();
            for (int i = 0; i < options.size(); i++) {
                if(checkedOptions.contains(options.get(i).getId())) {
                    Option option = options.get(i);
                    newOrder.getOptions().add(option);
                    optionsTotalPrice += option.getPrice();
                }
            }
        }
         newOrder = new Order.Builder(newOrder)
                .setPriceOptions(optionsTotalPrice)
                .build();
        session.setAttribute("orderStage",4);
        session.setAttribute("currentOrder",newOrder);
        return Path.PAGE__LOGIN ;
    }
}
