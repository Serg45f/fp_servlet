package com.sgsavch.controller.сommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public interface Command {
    String execute(HttpServletRequest request) throws SQLException, IOException, ServletException;
}
