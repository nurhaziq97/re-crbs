package com.haziq.crbs.modules.booking.entities;

import com.haziq.crbs.common.GenericEntity;
import com.haziq.crbs.modules.booking.repositories.EBookingStatus;
import com.haziq.crbs.modules.accounts.customer.entities.Customer;
import com.haziq.crbs.modules.car.entities.Car;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="bookings")
@Data
public class Booking implements Serializable, GenericEntity<Booking> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="booking_id")
    private Long id;

    @Column(name="book_start")
    @NotBlank
    private Date bookingStart;

    @NotBlank
    @Column(name="book_end")
    private Date bookingEnd;

    @NotBlank
    @Column(name="booking_status")
    @Enumerated(EnumType.STRING)
    private EBookingStatus bookingStatus;

    @Column(name="book_score")
    private int bookScore;

    @ManyToOne
    @JoinColumn(name="car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    @Column(name="book_price_rate", nullable = true)
    private Double bookRate;

    public Booking() {
    }

    @Override
    public void update(Booking source) {
        this.bookingStart = source.getBookingStart();
        this.bookingEnd = source.getBookingEnd();
        this.bookingStatus = source.getBookingStatus();
        this.bookScore = source.getBookScore();
        this.car = source.getCar();
        this.customer = source.getCustomer();
        this.bookRate = source.getBookRate();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Booking createNewInstance() {
        Booking newInstance = new Booking();
        newInstance.update(this);

        return newInstance;
    }
}
