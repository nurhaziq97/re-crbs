package com.haziq.crbs.payload.request;

import javax.validation.constraints.NotBlank;

public class RegisterCarOwnerRequest extends RegisterRequest{
    @NotBlank
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
