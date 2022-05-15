package com.haziq.crbs.modules.accounts.admin.entities;

import com.haziq.crbs.modules.accounts.generic.ERole;
import com.haziq.crbs.modules.accounts.generic.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="admin")
@DiscriminatorValue(ERole.Values.ROLE_ADMIN)
public class Admin extends User {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="added_by", nullable = true)
    private Admin admin;

    @OneToMany(mappedBy = "admin")
    private Set<Admin> adminSet;


}
