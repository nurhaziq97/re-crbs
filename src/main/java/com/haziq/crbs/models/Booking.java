package com.haziq.crbs.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name="book_rate")
    private int bookRate;

    @ManyToOne
    @JoinColumn(name="car_id", nullable = false)
    private Car car;

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

    public int getBookRate() {
        return bookRate;
    }

    public void setBookRate(int bookRate) {
        this.bookRate = bookRate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
