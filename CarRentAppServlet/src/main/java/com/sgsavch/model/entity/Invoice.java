package com.sgsavch.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Invoice {
    private final Long id;
    private final Long number;
    private final Order order;
    private final boolean isPayed;
    private final LocalDateTime paymentDate;

    public Invoice(final Long id,
                   final Long number,
                   final Order order,
                   final boolean isPayed,
                   final LocalDateTime paymentDate) {
        this.id = id;
        this.number = number;
        this.order = order;
        this.isPayed = isPayed;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public Long getNumber() {
        return number;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public static class Builder {
        private Long id;
        private Long number;
        private Order order;
        private boolean isPayed;
        private LocalDateTime paymentDate;

        public Builder() {
        }

        public Builder(Invoice invoice) {
            this.id = invoice.id;
            this.number = invoice.number;
            this.order = invoice.order;
            this.isPayed = invoice.isPayed;
            this.paymentDate = invoice.paymentDate;
        }

        public Builder setId(Long id) {
            this.id = id;

            return this;
        }

        public Builder setNumber(Long number) {
            this.number = number;

            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;

            return this;
        }

        public Builder setIsPayed(Boolean isPayed) {
            this.isPayed = isPayed;

            return this;
        }

        public Builder setPaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;

            return this;
        }

        public Invoice build() {
            return new Invoice(id,
                    number,
                    order,
                    isPayed,
                    paymentDate);
        }

    }
}