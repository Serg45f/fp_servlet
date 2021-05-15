package com.sgsavch.model.entity;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;


public class Order {
    private Long id;
    private String code;
    private LocalDateTime start;
    private LocalDateTime end;
    private LocalDateTime realEnd;
    private Integer days;
    private Vehicle vehicle;
    private User user;
    private StatusOrder status;
    private  Location location;
    private File qrcode;
    private Double pricePeriod;
    private Double totalPrice;
    private Double priceOptions;
    private List<Option> options;
    private String damageDescript;
    private String damagePrice;
    private Boolean damageIsPayed;

    public Order(Long id,
                 String code,
                 LocalDateTime start,
                 LocalDateTime end,
                 LocalDateTime realEnd,
                 Integer days,
                 Vehicle vehicle,
                 User user,
                 StatusOrder status,
                 Location location,
                 File qrcode,
                 Double pricePeriod,
                 Double totalPrice,
                 Double priceOptions,
                 List<Option> options,
                 String damageDescript,
                 String damagePrice,
                 Boolean damageIsPayed) {

        this.id = id;
        this.code = code;
        this.start = start;
        this.end = end;
        this.realEnd = realEnd;
        this.days = days;
        this.vehicle = vehicle;
        this.user = user;
        this.status = status;
        this.location = location;
        this.qrcode = qrcode;
        this.pricePeriod = pricePeriod;
        this.totalPrice = totalPrice;
        this.priceOptions = priceOptions;
        this.options = options;
        this.damageDescript = damageDescript;
        this.damagePrice = damagePrice;
        this.damageIsPayed = damageIsPayed;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public LocalDateTime getRealEnd() {
        return realEnd;
    }

    public void setRealEnd(LocalDateTime realEnd) {
        this.realEnd = realEnd;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public File getQrcode() {
        return qrcode;
    }

    public void setQrcode(File qrcode) {
        this.qrcode = qrcode;
    }

    public Double getPricePeriod() {
        return pricePeriod;
    }

    public void setPricePeriod(Double pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPriceOptions() {
        return priceOptions;
    }

    public void setPriceOptions(Double priceOptions) {
        this.priceOptions = priceOptions;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public String getDamageDescript() {
        return damageDescript;
    }

    public void setDamageDescript(String damageDescript) {
        this.damageDescript = damageDescript;
    }

    public String getDamagePrice() {
        return damagePrice;
    }

    public void setDamagePrice(String damagePrice) {
        this.damagePrice = damagePrice;
    }

    public Boolean getDamageIsPayed() {
        return damageIsPayed;
    }

    public void setDamageIsPayed(Boolean damageIsPayed) {
        this.damageIsPayed = damageIsPayed;
    }

    public void setQRCodeAuto(){

    }


//    public void setCode(){
//        StringBuilder codeStr = new StringBuilder();
//        codeStr
//                .append(event.getId())
//                .append(":")
//                .append(event.getDate())
//                .append(":")
//                .append(event.getTime())
//                .append(":")
//                .append(event.getPlace())
//                .append(":")
//                .append(user.getFirstName())
//                .append(":")
//                .append(user.getLastName())
//                .append(":")
//                .append(id);
//        this.code = codeStr.toString();
//    }



}