package com.haziq.crbs.repositories;

import com.haziq.crbs.models.Car;
import com.haziq.crbs.models.RentalPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalPriceRepository extends JpaRepository<RentalPrice, Long> {

    public RentalPrice findRentalPriceByCar(Car car);

}
