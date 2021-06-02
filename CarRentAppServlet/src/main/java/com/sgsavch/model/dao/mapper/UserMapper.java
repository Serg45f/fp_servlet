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
                .setPassportNumb(rs.getString("passport_numb"))
                .setCountry(rs.getString("country"))
                .setLicenseNumb(rs.getString("license"))
                .setCardNumber(rs.getString("card"))
                .build();
        if(rs.getDate("passport_date_exp") != null)
            user = new User.Builder(user).setPassDateExp(rs.getDate("passport_date_exp").toLocalDate()).build();
        if(rs.getString("status") != null)
            user = new User.Builder(user).setUserStatus(StatusUser.valueOf(rs.getString("status"))).build();
        System.out.println(user);
        return user;
    }

    @Override
    public User makeUnique(Map<Long, User> cache, User user) {
        cache.putIfAbsent(user.getId(), user);
        return cache.get(user.getId());
    }


}
