package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Color;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public class Vehicle {
    private final Long id;
    private final CarModel carModel;
    private final String regNumber;
    private final LocalDateTime yearIssue;
    private final List<Order> orders;
    private final Color color;
    private final String transmission;
    private final Double discount;
    private final User manager;
    private final boolean isNew;

    public Vehicle(final Long id,
                   final CarModel carModel,
                   final String regNumber,
                   final LocalDateTime yearIssue,
                   final List<Order> orders,
                   final Color color,
                   final String transmission,
                   final Double discount,
                   final User manager,
                   final boolean isNew) {
        this.id = id;
        this.carModel = carModel;
        this.regNumber = regNumber;
        this.yearIssue = yearIssue;
        this.orders = orders;
        this.color = color;
        this.transmission = transmission;
        this.discount = discount;
        this.manager = manager;
        this.isNew = isNew;
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

    public LocalDateTime getYearIssue() {
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

    public boolean isNew() {
        return isNew;
    }

    public static class Builder {

        private Long id;
        private CarModel carModel;
        private String regNumber;
        private LocalDateTime yearIssue;
        private List<Order> orders;
        private Color color;
        private String transmission;
        private Double discount = 0D;
        private User manager;
        private boolean isNew;

        public Builder() {
        }

        public Builder(Vehicle vehicle) {
            this.id = vehicle.id;
            this.carModel = vehicle.carModel;
            this.regNumber = vehicle.regNumber;
            this.yearIssue = vehicle.yearIssue;
            this.orders = vehicle.orders;
            this.color = vehicle.color;
            this.transmission = vehicle.transmission;
            this.discount = vehicle.discount;
            this.manager = vehicle.manager;
            this.isNew = vehicle.isNew;
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

        public Builder setYearIssue(LocalDateTime yearIssue) {
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

        public Builder setIsNew(boolean isNew) {
            this.isNew = isNew;

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
                    manager,
                    isNew);
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
                .append(", ")
                .append("manager=")
                .append(manager)
                .append(", ")
                .append("isNew=")
                .append(isNew)
                .append(")").toString();

    }
}