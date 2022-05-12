package com.haziq.crbs.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="car_types")
public class CarType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_type_id")
    private Long carTypeId;

    @Column(name="type_name")
    @Enumerated(EnumType.STRING)
    private ECarType carTypeName;

    @OneToMany(mappedBy = "carType")
    private Set<Car> carType;

    public Long getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(Long carTypeId) {
        this.carTypeId = carTypeId;
    }

    public ECarType getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(ECarType carTypeName) {
        this.carTypeName = carTypeName;
    }

    public Set<Car> getCarType() {
        return carType;
    }

    public void setCarType(Set<Car> carType) {
        this.carType = carType;
    }
}
