package com.haziq.crbs.repositories;

import com.haziq.crbs.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    public Optional<Car> findById(Long id);
}
