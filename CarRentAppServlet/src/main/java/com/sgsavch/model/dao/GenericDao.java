package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Lecture;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    Long create (T entity);
    T findById(long id);
    List<T> findAll();
    void update(T entity);
    boolean delete(Long id);
    void close();
}
