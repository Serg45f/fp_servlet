package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.StatusUser;
import com.sgsavch.model.entity.enums.TypeCar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User {
    private final Long id;
    private final String email;
    private final String phone;
    private final String activationCode;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final Set<Role> roles;
    private final StatusUser statusUser;
    private final String passportNumb;
    private final LocalDate passDateExp;
    private final String country;
    private final String licenseNumb;
    private final String cardNumb;
    private final List<Order> orders;
    private final List<Vehicle> vehicles;

    public Boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }
    public Boolean isSpeaker(){
        return roles.contains(Role.SPEAKER);
    }
    public Boolean isUser(){
        return roles.contains(Role.USER);
    }
    public Boolean isRole(Role role) { return roles.contains(role); }

    public User(final Long id,
                final String email,
                final String phone,
                final String activationCode,
                final String password,
                final String firstName,
                final String lastName,
                final Set<Role> roles,
                final StatusUser status,
                final String passportNumb,
                final LocalDate passDateExp,
                final String country,
                final String licenseNumb,
                final String cardNumb,
                final List<Order> orders,
                final List<Vehicle> vehicles) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.activationCode = activationCode;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.statusUser = status;
        this.passportNumb = passportNumb;
        this.passDateExp = passDateExp;
        this.country = country;
        this.licenseNumb = licenseNumb;
        this.cardNumb = cardNumb;
        this.orders = orders;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public StatusUser getStatusUser() {
        return statusUser;
    }

    public String getPassportNumb() {
        return passportNumb;
    }

    public LocalDate getPassDateExp() {
        return passDateExp;
    }

    public String getCountry() {
        return country;
    }

    public String getLicenseNumb() {
        return licenseNumb;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public static class Builder {
        private Long id;
        private String email;
        private String phone;
        private String activationCode;
        private String password;
        private String firstName;
        private String lastName;
        private Set<Role> roles;
        private StatusUser statusUser;
        private String passportNumb;
        private LocalDate passDateExp;
        private String country;
        private String licenseNumb;
        private String cardNumb;
        private List<Order> orders;
        private List<Vehicle> vehicles;

        public Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;

            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;

            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;

            return this;
        }

        public Builder setActivationCode(String activationCode) {
            this.activationCode = activationCode;

            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;

            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;

            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;

            return this;
        }

        public Builder setRoles(Set<Role> roles) {
            this.roles = roles;

            return this;
        }

        public Builder setUserStatus(StatusUser status) {
            this.statusUser = status;

            return this;
        }

        public Builder setPassportNumb(String passportNumb) {
            this.passportNumb = passportNumb;

            return this;
        }

        public Builder setPassDateExp(LocalDate passDateExp) {
            this.passDateExp = passDateExp;

            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;

            return this;
        }

        public Builder setLicenseNumb(String licenseNumb) {
            this.licenseNumb = licenseNumb;

            return this;
        }

        public Builder setCardNumber(String cardNumb) {
            this.cardNumb = cardNumb;

            return this;
        }

        public Builder setOrders(List<Order> orders) {
            this.orders = orders;

            return this;
        }

        public Builder setVehicles(List<Vehicle> vehicles) {
            this.vehicles = vehicles;

            return this;
        }

        public User build() {
            return new User(
                    id,
                    email,
                    phone,
                    activationCode,
                    password,
                    firstName,
                    lastName,
                    roles,
                    statusUser,
                    passportNumb,
                    passDateExp,
                    country,
                    licenseNumb,
                    cardNumb,
                    orders,
                    vehicles);
        }

    }

    public User valueOf(String user){
        String lexems[] = user.split(",");
        User newUser = new User.Builder().build();
        User.Builder builder = new User.Builder();
        for(String s:lexems) {
            if (s.contains("id"))
                newUser = builder.setId(Long.valueOf(s.replaceAll(".*=|\\)", ""))).build();
            if (s.contains("email"))
                newUser = builder.setEmail(s.replaceAll(".*=|\\)", "")).build();
            if (s.contains("phone"))
                newUser = builder.setPhone(s.replaceAll(".*=|\\)", "")).build();
            if (s.contains("activationCode"))
                newUser = builder.setActivationCode(s.replaceAll(".*=|\\)", "")).build();
            if (s.contains("password"))
                newUser = builder.setPassword(s.replaceAll(".*=|\\)", "")).build();
            if (s.contains("firstName"))
                newUser = builder.setFirstName(s.replaceAll(".*=|\\)", "")).build();
            if (s.contains("lastName"))
                newUser = builder.setLastName(s.replaceAll(".*=|\\)", "")).build();
//                if (s.contains("roles"))
//                    newUser = builder.setRoles(Set<Role>.valueOf(s.replaceAll(".*=", ""))).build();
            if (s.contains("status"))
                newUser = builder.setUserStatus(StatusUser.valueOf(s.replaceAll(".*=|\\)", ""))).build();
            if (s.contains("passportNumb"))
                newUser = builder.setPassportNumb(s.replaceAll(".*=|\\)", "")).build();
            if (s.contains("passDateExp"))
                newUser = builder.setPassDateExp(LocalDate.parse(s.replaceAll(".*=|\\)", ""))).build();
            if (s.contains("country"))
                newUser = builder.setCountry(s.replaceAll(".*=|\\)", "")).build();
            if (s.contains("licenseNumb"))
                newUser = builder.setLicenseNumb(s.replaceAll(".*=|\\)", "")).build();
            if (s.contains("cardNumb"))
                newUser = builder.setCardNumber(s.replaceAll(".*=|\\)", "")).build();
        }

        return newUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email=" + email +
                ", phone=" + phone +
                ", activationCode=" + activationCode +
                ", password=" + password +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", roles=" + roles +
                ", status=" + statusUser +
                ", passportNumb=" + passportNumb +
                ", passDateExp=" + passDateExp +
                ", country=" + country +
                ", licenseNumb=" + licenseNumb +
                ", cardNumb=" + cardNumb +
                ", orders=" + orders +

                '}';
    }
}
