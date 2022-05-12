package com.haziq.crbs.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="admin")
@DiscriminatorValue(ERole.Values.ROLE_ADMIN)
public class Admin extends User{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="added_by", nullable = true)
    private Admin admin;

    @OneToMany(mappedBy = "admin")
    private Set<Admin> adminSet;


}
