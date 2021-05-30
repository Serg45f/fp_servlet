package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.StatusUser;
import com.sgsavch.model.service.UserService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class UserMapper implements ObjectMapper<User> {


    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User.Builder()
                .setId(rs.getLong("id"))
                .setPhone(rs.getString("phone"))
                .setEmail(rs.getString("email"))
                .setPassword(rs.getString("password"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"))
                .setRoles(new UserService().getUserRoles(rs.getLong("id")))
                .setUserStatus(rs.getString("status")!=null?StatusUser.valueOf(rs.getString("status")):null)
                .setPassportNumb(rs.getString("passport_numb"))
                .setPassDateExp(rs.getDate("passport_date_exp")!=null?(rs.getDate("passport_date_exp")).toLocalDate():null)
                .setCountry(rs.getString("country"))
                .setLicenseNumb(rs.getString("license"))
                .setCardNumber(rs.getString("card"))
                .build();


//        private Set<Role> roles;
//        private List<Order> orders;
//        private List<Lecture> lectures;
//        private List<Vehicle> vehicles;

        return user;
    }

    @Override
    public User makeUnique(Map<Long, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }


}
