package com.haziq.crbs.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@DiscriminatorValue(ERole.Values.ROLE_CUSTOMER)
public class Customer extends User {

    @Column(name="ic", nullable = false)
    @NotBlank
    private String customerIc;

    @Column(name="license")
    private String customerLicense;

    @Column(name="license_exp_date")
    private Date customerExpLicense;

    @OneToMany(mappedBy = "customer")
    private Set<Booking> bookingSet;

    public Customer() {
    }

    public Customer(String username,
                    String password,
                    String email,
                    String phoneNumber,
                    String customerIc) {
        super(username, password, email, phoneNumber);
        this.customerIc = customerIc;
    }

    public String getCustomerIc() {
        return customerIc;
    }

    public void setCustomerIc(String customerIc) {
        this.customerIc = customerIc;
    }

    public String getCustomerLicense() {
        return customerLicense;
    }

    public void setCustomerLicense(String customerLicense) {
        this.customerLicense = customerLicense;
    }

    public Date getCustomerExpLicense() {
        return customerExpLicense;
    }

    public void setCustomerExpLicense(Date customerExpLicense) {
        this.customerExpLicense = customerExpLicense;
    }
}
