package com.haziq.crbs.modules.accounts.admin.entities;

import com.haziq.crbs.common.GenericEntity;
import com.haziq.crbs.modules.accounts.generic.ERole;
import com.haziq.crbs.modules.accounts.generic.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="admin")
@DiscriminatorValue(ERole.Values.ROLE_ADMIN)
@Data
public class Admin extends User implements Serializable, GenericEntity<Admin> {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="added_by", nullable = true)
    private Admin admin;

    @OneToMany(mappedBy = "admin")
    private Set<Admin> adminSet;


    @Override
    public void update(Admin source) {
        super.setUsername(source.getUsername());
        super.setEmail(source.getEmail());
        super.setPassword(source.getPassword());
        super.setPhoneNumber(source.getPhoneNumber());
        this.admin = source.getAdmin();
        this.setAdminSet(source.getAdminSet());
    }

    @Override
    public Long getId() {
        return super.getUserId();
    }

    @Override
    public Admin createNewInstance() {
        Admin newInstance = new Admin();
        newInstance.update(this);

        return newInstance;
    }
}
