package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.LectureDao;
import com.sgsavch.model.entity.Lecture;
import java.util.List;

public class LectureService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<Lecture> getAllLectures(){
        try (LectureDao dao = daoFactory.createLectureDao()) {
            return dao.findAll();
        }
    }

    public List<Lecture> getLecturesPaginated(int currentPage, int recordsPerPage) {
        try (LectureDao dao = daoFactory.createLectureDao()) {
            return dao.getLecturesPaginated(currentPage,recordsPerPage);
        }
    }

    public List<Lecture> getLecturesByEventId(Long eventId) {
        try (LectureDao dao = daoFactory.createLectureDao()) {
            return dao.getLecturesByEventId(eventId);
        }
    }

    public int getNumberOfRaws() {
        try (LectureDao dao = daoFactory.createLectureDao()) {
            return dao.getNumberOfRaws();
        }
    }

    public Lecture getLecture(Long lectureId) {
        try (LectureDao dao = daoFactory.createLectureDao()) {
            return dao.findById(lectureId);
        }
    }
}
