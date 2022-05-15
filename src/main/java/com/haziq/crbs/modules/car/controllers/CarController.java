package com.haziq.crbs.modules.car.controllers;

import com.haziq.crbs.modules.car.entities.Car;
import com.haziq.crbs.modules.accounts.carOwner.entities.CarOwner;
import com.haziq.crbs.modules.car.payloads.CarType;
import com.haziq.crbs.modules.car.entities.ECarStatus;
import com.haziq.crbs.modules.car.payloads.AddCarRequest;
import com.haziq.crbs.common.MessageResponse;
import com.haziq.crbs.modules.accounts.carOwner.repositories.CarOwnerRepository;
import com.haziq.crbs.modules.car.repositories.CarRepository;
import com.haziq.crbs.modules.car.repositories.CarStatusRepository;
import com.haziq.crbs.modules.car.repositories.CarTypeRepository;
import com.haziq.crbs.config.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins="*", maxAge = 3600)
@RequestMapping("/api/car/")
public class CarController {
    final
    CarOwnerRepository carOwnerRepository;

    final
    CarRepository carRepository;

    final
    CarStatusRepository carStatusRepository;

    final
    CarTypeRepository carTypeRepository;

    public CarController(CarOwnerRepository carOwnerRepository, CarRepository carRepository, CarStatusRepository carStatusRepository, CarTypeRepository carTypeRepository) {
        this.carOwnerRepository = carOwnerRepository;
        this.carRepository = carRepository;
        this.carStatusRepository = carStatusRepository;
        this.carTypeRepository = carTypeRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCar(@Valid @RequestBody AddCarRequest request) {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth.getPrincipal() instanceof UserDetailsImpl)) {
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Must Login First"));
        }
        UserDetailsImpl userDetails= (UserDetailsImpl) auth.getPrincipal();
        CarOwner carOwner = carOwnerRepository.findById(userDetails.getId())
                .orElseThrow(() -> new IllegalArgumentException("Car Owner Not Found"));
        Car car = new Car();
        car.setCarName(request.getCarName());
        car.setCarBrand(request.getCarBrand());
        car.setCarSeats(request.getCarSeats());
        car.setCarColor(request.getCarColor());
        car.setCarTransmission(request.getCarTransmission());
        car.setCarDescription(request.getCarDesc());
        CarType carType = carTypeRepository.findByCarTypeName(request.getCarTypeName());
        car.setCarType(carType);
        car.setCarOwner(carOwner);
        car.setCarStatus(carStatusRepository.findByCarStatusName(ECarStatus.AVAILABLE));
        carRepository.save(car);
        return ResponseEntity.ok(car);
    }
}
