package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Role;
import com.sgsavch.model.entity.enums.StatusUser;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class User {
    private Long id;
    private String email;
    private String phone;
    private String activationCode;
    private String password;
    private String firstName;
    private String lastName;
    private Set<Role> roles = new HashSet<>();
    private StatusUser status;
    private String passportNumb;
    private LocalDate passDateExp;
    private String country;
    private String licenseNumb;
    private String cardNumb;
    private String resume;
    private List<Order> orders = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

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

    public User() {
    }

    public User(Long id,
                String email,
                String phone,
                String activationCode,
                String password,
                String firstName,
                String lastName,
                Set<Role> roles,
                StatusUser status,
                String passportNumb,
                LocalDate passDateExp,
                String country,
                String licenseNumb,
                String cardNumb,
                String resume,
                List<Order> orders,
                List<Vehicle> vehicles) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.activationCode = activationCode;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.status = status;
        this.passportNumb = passportNumb;
        this.passDateExp = passDateExp;
        this.country = country;
        this.licenseNumb = licenseNumb;
        this.cardNumb = cardNumb;
        this.resume = resume;
        this.orders = orders;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public StatusUser getStatus() {
        return status;
    }

    public void setStatus(StatusUser status) {
        this.status = status;
    }

    public String getPassportNumb() {
        return passportNumb;
    }

    public void setPassportNumb(String passportNumb) {
        this.passportNumb = passportNumb;
    }

    public LocalDate getPassDateExp() {
        return passDateExp;
    }

    public void setPassDateExp(LocalDate passDateExp) {
        this.passDateExp = passDateExp;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLicenseNumb() {
        return licenseNumb;
    }

    public void setLicenseNumb(String licenseNumb) {
        this.licenseNumb = licenseNumb;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public void setCardNumb(String cardNumb) {
        this.cardNumb = cardNumb;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roles=" + roles +
                ", status=" + status +
                ", passportNumb='" + passportNumb + '\'' +
                ", passDateExp=" + passDateExp +
                ", country='" + country + '\'' +
                ", licenseNumb='" + licenseNumb + '\'' +
                ", cardNumb='" + cardNumb + '\'' +
                ", resume='" + resume + '\'' +
                ", orders=" + orders +
                ", vehicles=" + vehicles +
                '}';
    }
}
