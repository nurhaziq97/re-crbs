package com.haziq.crbs.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="car_owner")
@DiscriminatorValue(ERole.Values.ROLE_CAR_OWNER)
public class CarOwner extends User{
    @NotBlank
    @Column(name="company_name")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String companyName;

    @OneToMany(mappedBy = "carOwner")
    private Set<Car> cars;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
