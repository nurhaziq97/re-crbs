package com.haziq.crbs.payload.request;

import javax.validation.constraints.NotBlank;

public class RegisterCustomerRequest extends RegisterRequest{
    @NotBlank
    private String icNumber;

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }
}
