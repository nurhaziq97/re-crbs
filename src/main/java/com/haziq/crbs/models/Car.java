package com.haziq.crbs.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="Cars")
public class Car {
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

    public Car(Long id,
               String carName,
               String carBrand,
               int carSeats,
               String carColor,
               String carTransmission,
               String carDescription) {
        this.id = id;
        this.carName = carName;
        this.carBrand = carBrand;
        this.carSeats = carSeats;
        this.carColor = carColor;
        this.carTransmission = carTransmission;
        this.carDescription = carDescription;
    }

    public Car(Long id,
               String carName,
               String carBrand,
               int carSeats,
               String carColor,
               String carTransmission) {
        this.id = id;
        this.carName = carName;
        this.carBrand = carBrand;
        this.carSeats = carSeats;
        this.carColor = carColor;
        this.carTransmission = carTransmission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public int getCarSeats() {
        return carSeats;
    }

    public void setCarSeats(int carSeats) {
        this.carSeats = carSeats;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarTransmission() {
        return carTransmission;
    }

    public void setCarTransmission(String carTransmission) {
        this.carTransmission = carTransmission;
    }

    public String getCarDescription() {
        return carDescription;
    }

    public void setCarDescription(String carDescription) {
        this.carDescription = carDescription;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Set<RentalPrice> getRentalPrices() {
        return rentalPrices;
    }

    public void setRentalPrices(Set<RentalPrice> rentalPrices) {
        this.rentalPrices = rentalPrices;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public CarOwner getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(CarOwner carOwner) {
        this.carOwner = carOwner;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }
}
