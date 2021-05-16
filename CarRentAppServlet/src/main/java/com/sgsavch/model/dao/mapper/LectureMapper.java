package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.EventLecture;
import com.sgsavch.model.entity.Lecture;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.*;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class LectureMapper {

    public Lecture extractFromResultSet(ResultSet rs) throws SQLException {
        Lecture lecture = new Lecture();
        //Hall[] halls = Hall.values();
        Theme[] themes = Theme.values();
        StatusLecture[] statusLecture = StatusLecture.values();
        Language[] languages = Language.values();

        lecture.setId(rs.getLong("id"));
        lecture.setName(rs.getString("name"));
        lecture.setDescription(rs.getString("description"));
        lecture.setStatus(statusLecture[rs.getInt("status_lecture")]);
        lecture.setTheme(themes[rs.getInt("themes")]);
        lecture.setLectureFileName(rs.getString("filename"));
        lecture.setDuration(rs.getLong("duration"));
        lecture.setShortDescription(rs.getString("short_description"));
        //lecture.setCurrentEventLecture();
        lecture.setLanguage(languages[rs.getInt("language")]);
        //lecture.setLector();

        return lecture;
    }


    public Lecture makeUnique(Map<Long, Lecture> cache,
                              Lecture lecture) {
        cache.putIfAbsent(lecture.getId(), lecture);
        return cache.get(lecture.getId());
    }
}
