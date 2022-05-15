package com.haziq.crbs.modules.booking.repositories;

import com.haziq.crbs.modules.car.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalPriceRepository extends JpaRepository<RentalPrice, Long> {

    public RentalPrice findRentalPriceByCar(Car car);

}
