package com.sgsavch.model.dao.mapper;

import com.sgsavch.model.entity.Lecture;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.Vehicle;
import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserMapper implements ObjectMapper<User> {


    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setPhone(rs.getString("phone"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setStatus(rs.getString("status")!=null?StatusUser.valueOf(rs.getString("status")):null);
        user.setPassportNumb(rs.getString("passport_numb"));
        user.setPassDateExp(rs.getDate("passport_date_exp")!=null?(rs.getDate("passport_date_exp")).toLocalDate():null);
        user.setCountry(rs.getString("country"));
        user.setLicenseNumb(rs.getString("license"));
        user.setCardNumb(rs.getString("card"));


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
