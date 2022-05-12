package com.haziq.crbs.security.services;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

public class CustomerDetailsImpl extends UserDetailsImpl{
    private String license;
    private Date licenseExpiredDate;
    private String icNumber;

    public CustomerDetailsImpl(Long id,
                               String username,
                               String email, String password,
                               Collection<? extends GrantedAuthority> authorities) {
        super(id, username, email, password, authorities);
    }

    public CustomerDetailsImpl(UserDetailsImpl user,
                               String license,
                               Date licenseExpiredDate,
                               String icNumber) {
        super(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getAuthorities());
        this.license = license;
        this.licenseExpiredDate = licenseExpiredDate;
        this.icNumber = icNumber;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Date getLicenseExpiredDate() {
        return licenseExpiredDate;
    }

    public void setLicenseExpiredDate(Date licenseExpiredDate) {
        this.licenseExpiredDate = licenseExpiredDate;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }
}
