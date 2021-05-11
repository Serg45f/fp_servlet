package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.entity.Ticket;
import com.sgsavch.model.entity.agregates.TicketsCountAndTotalSum;
import com.sgsavch.model.entity.enums.Hall;
import com.sgsavch.model.entity.enums.Language;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;

public class TicketsCountMapper implements ObjectMapper<TicketsCountAndTotalSum> {

    @Override
    public TicketsCountAndTotalSum extractFromResultSet(ResultSet rs) throws SQLException {
        Language[] languages=Language.values();
        Hall[] places = Hall.values();
        TicketsCountAndTotalSum ticketsCountAndTotalSum = new TicketsCountAndTotalSum();
        ticketsCountAndTotalSum.setEventId(rs.getLong("event.id"));
        ticketsCountAndTotalSum.setEventDate(rs.getDate("event.date").toLocalDate());
        ticketsCountAndTotalSum.setEventTime(rs.getTime("event.time").toLocalTime());
        ticketsCountAndTotalSum.setEventLanguage(languages[rs.getInt("event.language")]);
        ticketsCountAndTotalSum.setEventPlace(places[rs.getInt("event.place")]);
        ticketsCountAndTotalSum.setEventName(rs.getString("event.name"));
        ticketsCountAndTotalSum.setUserFirstName(rs.getString("users.first_name"));
        ticketsCountAndTotalSum.setUsersLastName(rs.getString("users.last_name"));
        ticketsCountAndTotalSum.setUserId(rs.getLong("users.id"));
        ticketsCountAndTotalSum.setUserEmail(rs.getString("users.Email"));
        ticketsCountAndTotalSum.setTicketCode(rs.getString("ticket.code"));
        ticketsCountAndTotalSum.setEventPrice(rs.getDouble("event.price"));
        ticketsCountAndTotalSum.settQuantity(rs.getLong("tcount"));
        ticketsCountAndTotalSum.seteSum(rs.getDouble("esum"));

        return ticketsCountAndTotalSum;
    }

    @Override
    public TicketsCountAndTotalSum makeUnique(
            Map<Long,
            TicketsCountAndTotalSum> cache,
            TicketsCountAndTotalSum ticketsCountAndTotalSum) {
        cache.putIfAbsent(ticketsCountAndTotalSum.getEventId(), ticketsCountAndTotalSum);
        return cache.get(ticketsCountAndTotalSum.getEventId());
    }


}
