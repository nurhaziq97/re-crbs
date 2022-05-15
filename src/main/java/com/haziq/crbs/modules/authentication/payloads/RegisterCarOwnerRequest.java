package com.haziq.crbs.modules.authentication.payloads;

import javax.validation.constraints.NotBlank;

public class RegisterCarOwnerRequest extends RegisterRequest {
    @NotBlank
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
