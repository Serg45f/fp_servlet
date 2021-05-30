package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;

import java.util.List;

public class CarModel {
    private final Long id;
    private final String name;
    private final Integer seatsNumb;
    private final Integer doorsNumb;
    private final String picture;
    private final TypeCar type;
    private final StatusCar status;
    private final Double price;
    private final Double deposit;
    private final List<Vehicle> vehicles;


    public CarModel(final Long id,
                    final String name,
                    final Integer seatsNumb,
                    final Integer doorsNumb,
                    final String picture,
                    final TypeCar type,
                    final StatusCar status,
                    final Double price,
                    final Double deposit,
                    final List<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.seatsNumb = seatsNumb;
        this.doorsNumb = doorsNumb;
        this.picture = picture;
        this.type = type;
        this.status = status;
        this.price = price;
        this.deposit = deposit;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSeatsNumb() {
        return seatsNumb;
    }

    public Integer getDoorsNumb() {
        return doorsNumb;
    }

    public String getPicture() {
        return picture;
    }

    public TypeCar getType() {
        return type;
    }

    public StatusCar getStatus() {
        return status;
    }

    public Double getPrice() {
        return price;
    }

    public Double getDeposit() {
        return deposit;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Integer seatsNumb;
        private Integer doorsNumb;
        private String picture;
        private TypeCar type;
        private StatusCar status;
        private Double price;
        private Double deposit;
        private List<Vehicle> vehicles;

        public Builder() {
            // private constructor
        }

        public Builder setId(Long id) {
            this.id = id;

            return this;
        }

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setSeatsNumb(Integer seatsNumb) {
            this.seatsNumb = seatsNumb;

            return this;
        }

        public Builder setDoorsNumb(Integer doorsNumb) {
            this.doorsNumb = doorsNumb;

            return this;
        }

        public Builder setPicture(String picture) {
            this.picture = picture;

            return this;
        }

        public Builder setType(TypeCar type) {
            this.type = type;

            return this;
        }

        public Builder setStatus(StatusCar status) {
            this.status = status;

            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;

            return this;
        }

        public Builder setDeposit(Double deposit) {
            this.deposit = deposit;

            return this;
        }

        public Builder setVehicles(List<Vehicle> vehicles) {
            this.vehicles = vehicles;

            return this;
        }

        public CarModel build() {
            return new CarModel(id,
                    name,
                    seatsNumb,
                    doorsNumb,
                    picture,
                    type,
                    status,
                    price,
                    deposit,
                    vehicles);
        }

    }

    public CarModel valueOf(String carModel){
        String lexems[] = carModel.split(",");
        CarModel newCarModel = new CarModel.Builder().build();
        CarModel.Builder builder = new CarModel.Builder();
        for(String s:lexems) {
            if (s.contains("id"))
                newCarModel = builder.setId(Long.valueOf(s.replaceAll(".*=", ""))).build();
            if (s.contains("name"))
                newCarModel = builder.setName(s.replaceAll(".*=", "")).build();
            if (s.contains("seatsNumb"))
                newCarModel = builder.setSeatsNumb(Integer.valueOf(s.replaceAll(".*=", ""))).build();
            if (s.contains("doorsNumb"))
                newCarModel = builder.setDoorsNumb(Integer.valueOf(s.replaceAll(".*=", ""))).build();
            if (s.contains("picture"))
                newCarModel = builder.setPicture(s.replaceAll(".*=", "")).build();
            if (s.contains("type"))
                newCarModel = builder.setType(TypeCar.valueOf(s.replaceAll(".*=", ""))).build();
            if (s.contains("status"))
                newCarModel = builder.setStatus(StatusCar.valueOf(s.replaceAll(".*=", ""))).build();
            if (s.contains("price"))
                newCarModel = builder.setPrice(Double.valueOf(s.replaceAll(".*=", ""))).build();
            if (s.contains("deposit"))
                newCarModel = builder.setDeposit(Double.valueOf(s.replaceAll(".*=", "").replace(")",""))).build();
        }
        return newCarModel;
    }

    public String toString(){
        return new StringBuilder("CarModel(")
                .append("id=")
                .append(id)
                .append(", ")
                .append("name=")
                .append(name)
                .append(", ")
                .append("seatsNumb=")
                .append(seatsNumb)
                .append(", ")
                .append("doorsNumb=")
                .append(doorsNumb)
                .append(", ")
                .append("picture=")
                .append(picture)
                .append(", ")
                .append("type=")
                .append(type)
                .append(", ")
                .append("status=")
                .append(status)
                .append(", ")
                .append("price=")
                .append(price)
                .append(", ")
                .append("deposit=")
                .append(deposit)
                .append(")")
                .toString();
    }

}