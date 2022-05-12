package com.haziq.crbs.repositories;

import com.haziq.crbs.models.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType, Long> {
    public CarType findByCarTypeName(String carTypeName);
}
