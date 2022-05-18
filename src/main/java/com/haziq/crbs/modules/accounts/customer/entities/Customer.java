package com.haziq.crbs.modules.accounts.customer.entities;

import com.haziq.crbs.common.GenericEntity;
import com.haziq.crbs.modules.booking.entities.Booking;
import com.haziq.crbs.modules.accounts.generic.ERole;
import com.haziq.crbs.modules.accounts.generic.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@DiscriminatorValue(ERole.Values.ROLE_CUSTOMER)
@Data
public class Customer extends User implements Serializable, GenericEntity<Customer> {

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

    @Override
    public void update(Customer source) {
        super.setUsername(source.getUsername());
        super.setEmail(source.getEmail());
        super.setPassword(source.getPassword());
        super.setPhoneNumber(source.getPhoneNumber());
        this.customerIc = source.getCustomerIc();
    }

    @Override
    public Long getId() {
        return this.getUserId();
    }

    @Override
    public Customer createNewInstance() {
        Customer newInstance = new Customer();
        newInstance.update(this);

        return newInstance;
    }
}
