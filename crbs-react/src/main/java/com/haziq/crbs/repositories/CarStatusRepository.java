package com.haziq.crbs.repositories;

import com.haziq.crbs.models.CarStatus;
import com.haziq.crbs.models.ECarStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarStatusRepository extends JpaRepository<CarStatus,Long> {
    public CarStatus findByCarStatusName(ECarStatus eCarStatus);
}
