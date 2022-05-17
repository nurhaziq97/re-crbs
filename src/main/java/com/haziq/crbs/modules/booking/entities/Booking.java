package com.haziq.crbs.modules.booking.entities;

import com.haziq.crbs.modules.booking.repositories.EBookingStatus;
import com.haziq.crbs.modules.accounts.customer.entities.Customer;
import com.haziq.crbs.modules.car.entities.Car;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="bookings")
@Data
public class Booking {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBookingStart() {
        return bookingStart;
    }

    public void setBookingStart(Date bookingStart) {
        this.bookingStart = bookingStart;
    }

    public Date getBookingEnd() {
        return bookingEnd;
    }

    public void setBookingEnd(Date bookingEnd) {
        this.bookingEnd = bookingEnd;
    }

    public EBookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(EBookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getBookScore() {
        return bookScore;
    }

    public void setBookScore(int bookScore) {
        this.bookScore = bookScore;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getBookRate() {
        return bookRate;
    }

    public void setBookRate(Double bookRate) {
        this.bookRate = bookRate;
    }
}
