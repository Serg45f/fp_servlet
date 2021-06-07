package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Location;
import com.sgsavch.model.entity.enums.StatusOrder;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private final Long id;
    private final String code;
    private final LocalDateTime start;
    private final LocalDateTime end;
    private final LocalDateTime realEnd;
    private final Integer days;
    private final Vehicle vehicle;
    private final User user;
    private final StatusOrder status;
    private final Location location;
    private final String qrcode;
    private final Double pricePeriod;
    private final Double totalPrice;
    private final Double priceOptions;
    private final List<Option> options;
    private final String damageDescript;
    private final Double damagePrice;
    private final Boolean damageIsPayed;

    public Order(final Long id,
                 final String code,
                 final LocalDateTime start,
                 final LocalDateTime end,
                 final LocalDateTime realEnd,
                 final Integer days,
                 final Vehicle vehicle,
                 final User user,
                 final StatusOrder status,
                 final Location location,
                 final String qrcode,
                 final Double pricePeriod,
                 final Double totalPrice,
                 final Double priceOptions,
                 final List<Option> options,
                 final String damageDescript,
                 final Double damagePrice,
                 final Boolean damageIsPayed) {

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

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public LocalDateTime getRealEnd() {
        return realEnd;
    }

    public Integer getDays() {
        return days;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User getUser() {
        return user;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public Location getLocation() {
        return location;
    }

    public String getQrcode() {
        return qrcode;
    }

    public Double getPricePeriod() {
        return pricePeriod;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double getPriceOptions() {
        return priceOptions;
    }

    public List<Option> getOptions() {
        return options;
    }

    public String getDamageDescript() {
        return damageDescript;
    }

    public Double getDamagePrice() {
        return damagePrice;
    }

    public Boolean getDamageIsPayed() {
        return damageIsPayed;
    }

    public static class Builder {
        private Long id;
        private String code;
        private LocalDateTime start;
        private LocalDateTime end;
        private LocalDateTime realEnd;
        private Integer days;
        private Vehicle vehicle;
        private User user;
        private StatusOrder status;
        private Location location;
        private String qrcode;
        private Double pricePeriod;
        private Double totalPrice;
        private Double priceOptions;
        private List<Option> options= new ArrayList<>();
        private String damageDescript;
        private Double damagePrice;
        private Boolean damageIsPayed;

        public Builder() {
        }

        public Builder(Order order) {

            this.id = order.id;
            this.code = order.code;
            this.start = order.start;
            this.end = order.end;
            this.realEnd = order.realEnd;
            this.days = order.days;
            this.vehicle = order.vehicle;
            this.user = order.user;
            this.status = order.status;
            this.location = order.location;
            this.qrcode = order.qrcode;
            this.pricePeriod = order.pricePeriod;
            this.totalPrice = order.totalPrice;
            this.priceOptions = order.priceOptions;
            this.options = order.options;
            this.damageDescript = order.damageDescript;
            this.damagePrice = order.damagePrice;
            this.damageIsPayed = order.damageIsPayed;
        }

        public Builder setId(Long id) {
            this.id = id;

            return this;
        }

        public Builder setCode(String code) {
            this.code = code;

            return this;
        }

        public Builder setStart(LocalDateTime start) {
            this.start = start;

            return this;
        }

        public Builder setEnd(LocalDateTime end) {
            this.end = end;

            return this;
        }
        public Builder setRealEnd(LocalDateTime realEnd) {
            this.realEnd = realEnd;

            return this;
        }

        public Builder setDays(Integer days) {
            this.days = days;

            return this;
        }
        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;

            return this;
        }

        public Builder setUser(User user) {
            this.user = user;

            return this;
        }
        public Builder setStatusOrder(StatusOrder status) {
            this.status = status;

            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;

            return this;
        }
        public Builder setQRCode(String qrcode) {
            this.qrcode = qrcode;

            return this;
        }

        public Builder setPricePeriod(Double pricePeriod) {
            this.pricePeriod = pricePeriod;

            return this;
        }
        public Builder setTotalPrice(Double totalPrice) {
            this.totalPrice = totalPrice;

            return this;
        }

        public Builder setPriceOptions(Double priceOptions) {
            this.priceOptions = priceOptions;

            return this;
        }
        public Builder setOptions(List<Option> options) {
            this.options = options;

            return this;
        }

        public Builder setDamageDescript(String damageDescript) {
            this.damageDescript = damageDescript;

            return this;
        }
        public Builder setDamagePrice(Double damagePrice) {
            this.damagePrice = damagePrice;

            return this;
        }

        public Builder setDamageIsPayed(Boolean damageIsPayed) {
            this.damageIsPayed = damageIsPayed;

            return this;
        }

        public Order build() {
            return new Order(
                    id,
                    code,
                    start,
                    end,
                    realEnd,
                    days,
                    vehicle,
                    user,
                    status,
                    location,
                    qrcode,
                    pricePeriod,
                    totalPrice,
                    priceOptions,
                    options,
                    damageDescript,
                    damagePrice,
                    damageIsPayed);
        }

    }

    public String toString(){
        return new StringBuilder()
                .append("Order(")
                .append("id=")
                .append(id)
                .append(", ")
                .append("code=")
                .append(code)
                .append(", ")
                .append("start=")
                .append(start)
                .append(", ")
                .append("end=")
                .append(end)
                .append(", ")
                .append("realEnd=")
                .append(realEnd)
                .append(", ")
                .append("days=")
                .append(days)
                .append(", ")
                .append("vehicle=")
                .append(vehicle.toString())
                .append(", ")
                .append("user=")
                .append(user.toString())
                .append(", ")
                .append("status=")
                .append(status)
                .append(", ")
                .append("location=")
                .append(location)
                .append(", ")
                .append("qrcode=")
                .append(qrcode)
                .append(", ")
                .append("pricePeriod=")
                .append(pricePeriod)
                .append(", ")
                .append("totalPrice=")
                .append(totalPrice)
                .append(", ")
                .append("priceOptions=")
                .append(priceOptions)
                .append(", ")
                .append("options=")
                .append(options.toString())
                .append(", ")
                .append("damageDescript=")
                .append(damageDescript)
                .append(", ")
                .append("damagePrice=")
                .append(damagePrice)
                .append(", ")
                .append("damageIsPayed=")
                .append(damageIsPayed)
                .append(")")
                .toString();
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