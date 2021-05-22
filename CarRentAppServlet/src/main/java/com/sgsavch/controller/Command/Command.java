package com.sgsavch.controller.Command;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface Command {
    String execute(HttpServletRequest request) throws SQLException;
}
