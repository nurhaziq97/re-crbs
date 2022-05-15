package com.haziq.crbs.modules.car.repositories;

import com.haziq.crbs.modules.car.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {
    public Optional<Car> findById(Long id);
}
