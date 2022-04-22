package com.haziq.crbs.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="car_status")
public class CarStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_status_id")
    private Long  carStatusId;

    @Column(name="status_name")
    @Enumerated(EnumType.STRING)
    private ECarStatus carStatusName;

    @OneToMany(mappedBy = "carStatus")
    private Set<Car> cars;

    public Long getCarStatusId() {
        return carStatusId;
    }

    public void setCarStatusId(Long carStatusId) {
        this.carStatusId = carStatusId;
    }

    public ECarStatus getCarStatusName() {
        return carStatusName;
    }

    public void setCarStatusName(ECarStatus carStatusName) {
        this.carStatusName = carStatusName;
    }
}
