package com.haziq.crbs.modules.booking.controllers;

import com.haziq.crbs.common.GenericController;
import com.haziq.crbs.common.GenericRepository;
import com.haziq.crbs.modules.booking.entities.Booking;
import com.haziq.crbs.modules.car.entities.Car;
import com.haziq.crbs.modules.accounts.customer.entities.Customer;
import com.haziq.crbs.modules.booking.repositories.EBookingStatus;
import com.haziq.crbs.modules.booking.payloads.BookingRequest;
import com.haziq.crbs.common.MessageResponse;
import com.haziq.crbs.modules.booking.repositories.BookingRepository;
import com.haziq.crbs.modules.car.repositories.CarRepository;
import com.haziq.crbs.modules.accounts.admin.repositories.CustomerRepository;
import com.haziq.crbs.modules.booking.repositories.RentalPriceRepository;
import com.haziq.crbs.config.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin(origins="*", maxAge = 3600)
@RequestMapping(value="/api/booking/")
public class BookingController extends GenericController<Booking> {
    @Autowired
    CarRepository carRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RentalPriceRepository rentalPriceRepository;

    public BookingController(BookingRepository bookingRepository) {
        super(bookingRepository);
    }

    @PostMapping(value="book-car")
    public ResponseEntity<?> createBooking(@Valid @RequestBody BookingRequest request) {
        if(request.getBookStart().compareTo(request.getBookEnd()) < 0) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Book start greater than book end"));
        }
        final Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();
        if(!(auth.getPrincipal() instanceof UserDetailsImpl)) {
             return ResponseEntity
                     .badRequest()
                     .body("Must Logged in as Customer");
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        Customer customer = customerRepository.findById(userDetails.getId())
                .orElseThrow(()-> new IllegalArgumentException("Customer not found"));

        // get the car object
        Car car = carRepository.findById(request.getCarId()).orElseThrow(
                () -> new IllegalArgumentException("Car Not Found")
        );
        Booking booking = new Booking();
        booking.setCar(car);
        booking.setBookingStart(request.getBookStart());
        booking.setBookingEnd(request.getBookEnd());
        booking.setBookingStatus(EBookingStatus.PENDING);
        booking.setCustomer(customer);
        long diffInMillis = Math.abs(request.getBookEnd() .getTime()- request.getBookStart().getTime());
        if(request.getBookStart().toInstant().truncatedTo(ChronoUnit.DAYS)
                .equals(request.getBookEnd().toInstant().truncatedTo(ChronoUnit.DAYS))
        ) {
            // day is the same
            // calculate using the rental price for daily price
            long diff = TimeUnit.HOURS.convert(diffInMillis, TimeUnit.MILLISECONDS);
            double price = rentalPriceRepository.findRentalPriceByCar(car).getPriceHour() * diff;
            booking.setBookRate(price);
        }else {
            // get diff in  days
            long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
            double price = rentalPriceRepository.findRentalPriceByCar(car).getPriceDay() * diff;
            booking.setBookRate(price);
        }

        bookingRepository.save(booking);
        return ResponseEntity.ok("Booking Successfully Made");
    }
}
