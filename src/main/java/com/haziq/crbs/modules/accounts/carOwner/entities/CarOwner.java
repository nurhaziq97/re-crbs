package com.haziq.crbs.modules.accounts.carOwner.entities;

import com.haziq.crbs.common.GenericEntity;
import com.haziq.crbs.modules.car.entities.Car;
import com.haziq.crbs.modules.accounts.generic.ERole;
import com.haziq.crbs.modules.accounts.generic.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="car_owner")
@DiscriminatorValue(ERole.Values.ROLE_CAR_OWNER)
@Data
public class CarOwner extends User implements Serializable, GenericEntity<CarOwner> {
    @NotBlank
    @Column(name="company_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String companyName;

    @OneToMany(mappedBy = "carOwner")
    private Set<Car> cars;


    public CarOwner() {
    }

    public CarOwner(String username, String password, String email, String phoneNumber, String companyName) {
        super(username, password, email, phoneNumber);
        this.companyName = companyName;
    }

    @Override
    public void update(CarOwner source) {
        super.setUsername(source.getUsername());
        super.setEmail(source.getEmail());
        super.setPassword(source.getPassword());
        super.setPhoneNumber(source.getPhoneNumber());
        this.companyName = source.getCompanyName();
    }

    @Override
    public Long getId() {
        return this.getUserId();
    }

    @Override
    public CarOwner createNewInstance() {
        CarOwner newInstance = new CarOwner();
        newInstance.update(this);

        return newInstance;
    }
}
