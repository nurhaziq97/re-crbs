package com.haziq.crbs.payload.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class BookingRequest {
    @NotBlank
    private Date bookStart;

    @NotBlank
    private Date bookEnd;

    @NotBlank
    private Long carId;

    private Long bookingId;

    public Date getBookStart() {
        return bookStart;
    }

    public void setBookStart(Date bookStart) {
        this.bookStart = bookStart;
    }

    public Date getBookEnd() {
        return bookEnd;
    }

    public void setBookEnd(Date bookEnd) {
        this.bookEnd = bookEnd;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
}
