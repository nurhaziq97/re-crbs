package com.haziq.crbs.modules.booking.repositories;

import com.haziq.crbs.common.GenericRepository;
import com.haziq.crbs.modules.booking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends GenericRepository<Booking> {
    public Optional<Booking> findById(Long id);

}
