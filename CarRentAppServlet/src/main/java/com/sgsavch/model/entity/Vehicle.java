package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Color;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


public class Vehicle {
    private Long id;
    private CarModel carModel;
    private String regNumber;
    private LocalDate yearIssue;
    private List<Order> orders;
    private Color color;
    private String transmission;
    private Double discount = 0D;
    private User manager;

    public Vehicle() {
    }

    public Vehicle(Long id,
                   CarModel carModel,
                   String regNumber,
                   LocalDate yearIssue,
                   List<Order> orders,
                   Color color,
                   String transmission,
                   Double discount,
                   User manager) {

        this.id = id;
        this.carModel = carModel;
        this.regNumber = regNumber;
        this.yearIssue = yearIssue;
        this.orders = orders;
        this.color = color;
        this.transmission = transmission;
        this.discount = discount;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getYearIssue() {
        return yearIssue;
    }

    public void setYearIssue(LocalDate yearIssue) {
        this.yearIssue = yearIssue;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public String toString(){
        return new StringBuilder().append("Vehicle(")
                .append("id=")
                .append(id)
                .append(", ")
                .append("carmodel=")
                .append(carModel.toString())
                .append(", ")
                .append("regNumber=")
                .append(regNumber)
                .append(", ")
                .append("yearIssue=")
                .append(yearIssue)
                .append(", ")
                .append("color=")
                .append(color)
                .append(", ")
                .append("transmission=")
                .append(transmission)
                .append(", ")
                .append("discount=")
                .append(discount)
                .append("manager=")
                .append(manager)
                .append(")").toString();

    }
}