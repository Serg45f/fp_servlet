package com.sgsavch.controller.сommand;

import com.sgsavch.Path;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class StartCommand implements Command {
    private static final Logger log = Logger.getLogger(StartCommand.class);

    @Override
    public String execute(HttpServletRequest request) {

        return Path.PAGE__INDEX;
    }
}
