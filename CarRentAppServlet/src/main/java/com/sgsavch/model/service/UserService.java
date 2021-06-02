package com.sgsavch.model.service;

import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.UserDao;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class UserService {

    DaoFactory daoFactory = DaoFactory.getInstance();

    public List<User> getAllUsers(){
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<User> getUsersPaginated(int currentPage, int recordsPerPage) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getUsersPaginated(currentPage,recordsPerPage);
        }
    }

    public int getNumberOfRaws() {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getNumberOfRaws();
        }
    }

    public Set<Role> getUserRoles(Long id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getUserRoles(id);
        }
    }

    public User getUserByUsername(String username) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getUserByUsername(username);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public Long create(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.create(user);
        }
    }

    public Long deleteUserRoles(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.create(user);
        }
    }

    public boolean setUserRoles(User user,Set<Role> roles) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.setUserRoles(user,roles);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public boolean activateUser(String code) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.activateUser(code);
        }
    }

    public User getUser(Long id) {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.findById(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public List<User> getAllManagers() {
        try (UserDao dao = daoFactory.createUserDao()) {
            return dao.getUsersByRole("MANAGER");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    public void update(User user) {
        try (UserDao dao = daoFactory.createUserDao()) {
            dao.update(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }
}
