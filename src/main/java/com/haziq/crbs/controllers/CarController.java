package com.haziq.crbs.controllers;

import com.haziq.crbs.models.Car;
import com.haziq.crbs.models.CarOwner;
import com.haziq.crbs.models.CarType;
import com.haziq.crbs.models.ECarStatus;
import com.haziq.crbs.payload.request.AddCarRequest;
import com.haziq.crbs.payload.response.MessageResponse;
import com.haziq.crbs.repositories.CarOwnerRepository;
import com.haziq.crbs.repositories.CarRepository;
import com.haziq.crbs.repositories.CarStatusRepository;
import com.haziq.crbs.repositories.CarTypeRepository;
import com.haziq.crbs.security.services.UserDetailsImpl;
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
    @Autowired
    CarOwnerRepository carOwnerRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarStatusRepository carStatusRepository;

    @Autowired
    CarTypeRepository carTypeRepository;

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
