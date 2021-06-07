package com.sgsavch.model.dao;



import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> extends AutoCloseable {
    Long create (T entity);
    T findById(long id) throws SQLException;
    List<T> findAll() throws SQLException;
    void update(T entity) throws SQLException;
    boolean delete(Long id) throws SQLException;
    void close();
}
