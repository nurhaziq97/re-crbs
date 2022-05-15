package com.haziq.crbs.modules.car.repositories;

import com.haziq.crbs.modules.car.payloads.CarStatus;
import com.haziq.crbs.modules.car.entities.ECarStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarStatusRepository extends JpaRepository<CarStatus,Long> {
    public CarStatus findByCarStatusName(ECarStatus eCarStatus);
}
