package com.haziq.crbs.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="rental_prices")
public class RentalPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rental_price_id")
    private Long rentalPriceId;

    @Column(name="price_hour")
    private double priceHour;

    @Column(name="price_day")
    private double priceDay;

    @Column(name="price_start_date")
    private Date priceStartDate;

    @ManyToOne
    @JoinColumn(name="car_id", nullable = false)
    private Car car;

    public Long getRentalPriceId() {
        return rentalPriceId;
    }

    public void setRentalPriceId(Long rentalPriceId) {
        this.rentalPriceId = rentalPriceId;
    }

    public double getPriceHour() {
        return priceHour;
    }

    public void setPriceHour(double priceHour) {
        this.priceHour = priceHour;
    }

    public double getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(double priceDay) {
        this.priceDay = priceDay;
    }

    public Date getPriceStartDate() {
        return priceStartDate;
    }

    public void setPriceStartDate(Date priceStartDate) {
        this.priceStartDate = priceStartDate;
    }
}
