package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.enums.Hall;
import com.sgsavch.model.entity.enums.Language;
import com.sgsavch.model.entity.enums.StatusEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EventMapper {

    public Event extractFromResultSet(ResultSet rs) throws SQLException {
        Event event = new Event();
        Hall[] halls = Hall.values();
        StatusEvent[] statusEvents = StatusEvent.values();
        Language[] languages = Language.values();

        event.setId(rs.getLong("id"));
        event.setName(rs.getString("name"));
        event.setDescription(rs.getString("description"));
        event.setStatusEvent(StatusEvent.valueOf(rs.getString("status")));
        event.setDate(rs.getDate("date").toLocalDate());
        event.setTime(rs.getTime("time").toLocalTime());
        event.setPrice(rs.getDouble("price"));
        event.setPicture(rs.getString("picture"));
        event.setLanguage(languages[rs.getInt("language")]);
        event.setPlace(halls[rs.getInt("place")]);

        return event;
    }


    public Event makeUnique(Map<Long, Event> cache,
                              Event event) {
        cache.putIfAbsent(event.getId(), event);
        return cache.get(event.getId());
    }
}
