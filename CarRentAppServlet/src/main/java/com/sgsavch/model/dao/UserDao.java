package com.sgsavch.model.dao;

import com.sgsavch.model.entity.Event;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;


public interface UserDao extends GenericDao<User> {
    User getUserByActivationCode(String code) throws SQLException;

    List<User> getUsersPaginated(int currentPage, int numOfRecords);
    Integer getNumberOfRaws();

    Set<Role> getUserRoles(Long id);

    boolean setUserRoles(User user, Set<Role> roles) throws SQLException;

    User getUserByUsername(String username) throws SQLException;

    boolean activateUser(String code);


}

