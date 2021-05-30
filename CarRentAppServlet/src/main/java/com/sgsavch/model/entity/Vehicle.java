package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Color;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


public class Vehicle {
    private final Long id;
    private final CarModel carModel;
    private final String regNumber;
    private final LocalDate yearIssue;
    private final List<Order> orders;
    private final Color color;
    private final String transmission;
    private final Double discount;
    private final User manager;

    public Vehicle(final Long id,
                   final CarModel carModel,
                   final String regNumber,
                   final LocalDate yearIssue,
                   final List<Order> orders,
                   final Color color,
                   final String transmission,
                   final Double discount,
                   final User manager) {
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

    public CarModel getCarModel() {
        return carModel;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public LocalDate getYearIssue() {
        return yearIssue;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Color getColor() {
        return color;
    }

    public String getTransmission() {
        return transmission;
    }

    public Double getDiscount() {
        return discount;
    }

    public User getManager() {
        return manager;
    }

    public static class Builder {

        private Long id;
        private CarModel carModel;
        private String regNumber;
        private LocalDate yearIssue;
        private List<Order> orders;
        private Color color;
        private String transmission;
        private Double discount = 0D;
        private User manager;

        public Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;

            return this;
        }

        public Builder setCarModel(CarModel carModel) {
            this.carModel = carModel;

            return this;
        }

        public Builder setRegNumber(String regNumber) {
            this.regNumber = regNumber;

            return this;
        }

        public Builder setYearIssue(LocalDate yearIssue) {
            this.yearIssue = yearIssue;

            return this;
        }

        public Builder setOrders(List<Order> orders) {
            this.orders = orders;

            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;

            return this;
        }

        public Builder setTransmission(String transmission) {
            this.transmission = transmission;

            return this;
        }

        public Builder setDiscount(Double discount) {
            this.discount = discount;

            return this;
        }

        public Builder setManager(User manager) {
            this.manager = manager;

            return this;
        }

        public Vehicle build() {
            return new Vehicle(
                    id,
                    carModel,
                    regNumber,
                    yearIssue,
                    orders,
                    color,
                    transmission,
                    discount,
                    manager);
        }

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