package com.haziq.crbs.modules.car.repositories;

import com.haziq.crbs.modules.car.payloads.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType, Long> {
    public CarType findByCarTypeName(String carTypeName);
}
