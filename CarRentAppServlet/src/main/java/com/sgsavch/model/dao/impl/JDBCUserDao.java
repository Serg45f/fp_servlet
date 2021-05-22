package com.sgsavch.model.dao.impl;

import com.sgsavch.model.dao.SQLConstants.SQLConstant;
import com.sgsavch.model.dao.UserDao;
import com.sgsavch.model.dao.mapper.UserMapper;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusUser;
import com.sgsavch.utils.BCrypt;

import java.sql.*;
import java.util.*;

public class JDBCUserDao implements UserDao {

    private Connection connection;


    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Long create(User entity) {
            Long res = 0L;

            ResultSet rs = null;

            try(PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_ADD_NEW_USER, Statement.RETURN_GENERATED_KEYS)) {

                int k = 1;
                pstmt.setString(k++, entity.getEmail());
                pstmt.setString(k++, entity.getPassword());
                pstmt.setString(k++, entity.getFirstName());
                pstmt.setString(k++, entity.getLastName());
                pstmt.setString(k++, entity.getStatus().toString());
                pstmt.setString(k++, entity.getActivationCode());

                if (pstmt.executeUpdate() > 0) {
                    rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        entity.setId(rs.getLong(1));

                    }
                    res = rs.getLong(1);
                }
            } catch (SQLException e) {
//                logger.log(Level.WARNING,e.toString(),e);
//                logger.log(Level.INFO,"Cannot insert user ",e);
            } finally {
                close(rs);
                close();
            }
            return res;

    }

    @Override
    public User findById(long id) throws SQLException {
        ResultSet rs = null;
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_FIND_USER_BY_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            rs = prst.executeQuery();

            User user = new User();
            UserMapper userMapper = new UserMapper();
            if (rs.next()) {
                user = userMapper
                        .extractFromResultSet(rs);
            }
            return user;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally {
            rs.close();
            close();
        }
    }


    @Override
    public User getUserByUsername(String username) throws SQLException {
        User user = new User();
        ResultSet rs = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_FIND_USER_BY_LOGIN)) {

            int k = 1;
            pstmt.setString(k++, username);
            rs = pstmt.executeQuery();

            UserMapper userMapper = new UserMapper();
            if (rs.next()) {
                user = userMapper
                        .extractFromResultSet(rs);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            rs.close();
            close();
        }
    }

    @Override
    public List<User> getUsersByRole(String role) throws SQLException {
        Map<Long, User> users = new HashMap<>();

        ResultSet rs = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_FIND_USER_BY_ROLE)) {

            int k = 1;
            pstmt.setString(k++, role);
            rs = pstmt.executeQuery();

            UserMapper userMapper = new UserMapper();
       while (rs.next()) {
                User user = userMapper
                        .extractFromResultSet(rs);

                user = userMapper
                        .makeUnique(users, user);
            }
            return new ArrayList<>(users.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            rs.close();
            close();
        }
    }

    @Override
    public boolean setUserRoles(User user, Set<Role> roles) throws SQLException {
        boolean res = false;

        try {
            Statement st = connection.createStatement();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            for (Role r : roles) {
                addUserRole(connection, user.getId(), r);
            }
            connection.commit();

        } catch (SQLException e) {
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot set teams for user ",e);
            if(connection!=null)connection.rollback();
        } finally {
            close();
//            if(connection!=null)close(connection);
//            logger.log(Level.INFO,"Connection is closed");
        }
        return res;
    }

    @Override
    public User getUserByActivationCode(String code) throws SQLException {
        User user = new User();

        ResultSet rs = null;
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_FIND_USER_BY_ACTIVATION_CODE)) {

            int k = 1;
            pstmt.setString(k++, code);

//            rs = pstmt.executeQuery(String.valueOf(pstmt));
            rs = pstmt.executeQuery();
            UserMapper userMapper = new UserMapper();
            if (rs.next()) {
                user = userMapper
                        .extractFromResultSet(rs);
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            rs.close();
            close();
        }
    }

    private void addUserRole(Connection con, long id, Role role) throws SQLException {

        ResultSet rs = null;
        try (PreparedStatement pstmt = con.prepareStatement(SQLConstant.SQL_ADD_ROLE_FOR_USER)){

            int k = 1;
            pstmt.setLong(k++, id);
            pstmt.setString(k++, role.getRole());

            pstmt.executeUpdate();
        } finally {
            close(rs);
//            logger.log(Level.INFO,"ResultSet and PreparedStatement are closed");
        }
    }



    @Override
    public List<User> findAll() throws SQLException {
        Map<Long, User> users = new HashMap<>();

        ResultSet rs = null;
        final String query = "select * from users";
        try (Statement st = connection.createStatement()) {
            rs = st.executeQuery(query);

            UserMapper userMapper = new UserMapper();
            while (rs.next()) {
                User user = userMapper
                        .extractFromResultSet(rs);

                user = userMapper
                        .makeUnique(users, user);
            }
            return new ArrayList<>(users.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            rs.close();
            close();
        }
    }

    @Override
    public void update(User entity) {
        try (PreparedStatement pstmt = connection.prepareStatement(SQLConstant.SQL_ACTIVATION_UPDATE_USER)) {

            int k = 1;
            pstmt.setString(k++, entity.getActivationCode());
            pstmt.setString(k++, entity.getStatus().name());
            pstmt.setLong(k++,entity.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
//            logger.log(Level.WARNING,e.toString(),e);
//            logger.log(Level.INFO,"Cannot update team ",e);
        }finally {
            close();
        }
    }

    public void deleteUserRoles(Long id){
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_DELETE_USER_ROLES_BY_USER_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            prst.executeUpdate();

        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public boolean delete(Long id) {

        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_DELETE_USER_BY_USER_ID);) {

            int k = 1;
            prst.setLong(k++,id);
            prst.executeUpdate();

        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getUsersPaginated(int currentPage, int recordsPerPage) {
        Map<Long, User> users = new HashMap<>();

        int start = currentPage * recordsPerPage - recordsPerPage;
        String sql_users = String.format("SELECT * FROM users LIMIT %d, %d",start,recordsPerPage);
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql_users);

            UserMapper userMapper = new UserMapper();
            while (rs.next()) {
                User user = userMapper
                        .extractFromResultSet(rs);
                user = userMapper
                        .makeUnique(users, user);
                user.setRoles(getUserRoles(user.getId()));
            }
            return new ArrayList<>(users.values());
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public Integer getNumberOfRaws() {
        Integer numOfRaws = 0;
        String sql = "SELECT COUNT(id) as count FROM users";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                numOfRaws = rs.getInt("count");
            }
            return numOfRaws;

        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


    }

    @Override
    public Set<Role> getUserRoles(Long id) {
        Set<Role> roles = new HashSet<>();

        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_GET_USER_ROLES_BY_USER_ID)) {

            int k = 1;
            prst.setLong(k++,id);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                roles.add(Role.valueOf(rs.getString("roles")));
            }
            return roles;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean activateUser(String code) {
        User user = new User();
        try (PreparedStatement prst = connection.prepareStatement(SQLConstant.SQL_FIND_USER_BY_ACTIVATION_CODE)) {

            int k = 1;
            prst.setString(k++,code);
            ResultSet rs = prst.executeQuery();
            UserMapper userMapper = new UserMapper();
            if (rs.next()) {
                user = userMapper
                        .extractFromResultSet(rs);
            }
            user.setActivationCode(null);
            user.getRoles().clear();
            user.getRoles().add(Role.USER);
            user.setStatus(StatusUser.ACTIVE);

            deleteUserRoles(user.getId());
            update(user);
            setUserRoles(user,user.getRoles());
            return true;
        } catch (SQLException ex) {
//            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    private void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception e) {
//                log/*ger.log(Level.WARNING,e.toString(),e);
//                log*/ger.log(Level.INFO,"Cannot close ",e);
            }
        }
    }

    static String escapeForLike(String param) {
        return param
                .replace("!", "!!")
                .replace("%", "!%")
                .replace("_", "!_")
                .replace("[", "![");
    }

    public static void main(String[] args) {
        System.out.println(BCrypt.hashpw("1",BCrypt.gensalt(12)));
    }
}
