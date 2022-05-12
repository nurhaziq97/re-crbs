package com.haziq.crbs.repositories;

import com.haziq.crbs.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    public Optional<Booking> findById(Long id);

}
