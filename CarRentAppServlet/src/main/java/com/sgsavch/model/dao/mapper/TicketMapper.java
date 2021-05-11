package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.entity.Ticket;
import com.sgsavch.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TicketMapper implements ObjectMapper<Ticket> {


    @Override
    public Ticket extractFromResultSet(ResultSet rs) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getLong("id"));
//        ticket.setEmail(rs.getString("email"));
//        ticket.setPassword(rs.getString("password"));
//        ticket.setFirstName(rs.getString("first_name"));
//        ticket.setLastName(rs.getString("last_name"));

        return ticket;
    }

    @Override
    public Ticket makeUnique(Map<Long, Ticket> cache, Ticket ticket) {
        cache.putIfAbsent(ticket.getId(), ticket);
        return cache.get(ticket.getId());
    }


}
