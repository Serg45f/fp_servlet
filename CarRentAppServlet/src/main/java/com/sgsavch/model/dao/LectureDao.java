package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.Lecture;

import java.util.List;


public interface LectureDao extends GenericDao<Lecture> {
    List<Lecture> getLecturesPaginated(int currentPage, int numOfRecords);
    Integer getNumberOfRaws();
    List<Lecture> getLecturesByEventId(Long eventId);


}

