package com.haziq.crbs.modules.car.entities;

import com.haziq.crbs.common.GenericEntity;
import com.haziq.crbs.modules.booking.entities.Booking;
import com.haziq.crbs.modules.car.payloads.CarStatus;
import com.haziq.crbs.modules.car.payloads.CarType;
import com.haziq.crbs.modules.booking.repositories.RentalPrice;
import com.haziq.crbs.modules.accounts.carOwner.entities.CarOwner;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="Cars")
@Data
public class Car implements Serializable, GenericEntity<Car> {
    @Id
    @Column(name="car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="car_name")
    @NotBlank
    private String carName;

    @NotBlank
    @Column(name="car_brand")
    private String carBrand;

    @NotBlank
    @Column(name="car_seats")
    private int carSeats;

    @NotBlank
    @Column(name="car_color")
    private String carColor;

    @NotBlank
    @Column(name="car_transmission")
    private String carTransmission;

    @Column(name="car_description")
    private String carDescription;

    @OneToMany(mappedBy = "car")
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "car")
    private Set<RentalPrice> rentalPrices;

    @ManyToOne
    @JoinColumn(name = "car_type_id", nullable = false)
    private CarType carType;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private CarOwner carOwner;

    @ManyToOne
    @JoinColumn(name="car_status_id", nullable = false)
    private CarStatus carStatus;

    public Car() {
    }


    @Override
    public void update(Car source) {
        this.carName  = source.getCarName();
        this.carBrand = source.getCarBrand();
        this.carSeats = source.getCarSeats();
        this.carColor = source.getCarColor();
        this.carTransmission = source.getCarTransmission();
    }

    public Long getId() {
        return id;
    }

    @Override
    public Car createNewInstance() {
        Car newInstance = new Car();
        newInstance.update(this);

        return newInstance;
    }
}
