package com.haziq.crbs.models;

public enum ERole {
    ROLE_CUSTOMER (Values.ROLE_CUSTOMER),
    ROLE_CAR_OWNER(Values.ROLE_CAR_OWNER),
    ROLE_ADMIN(Values.ROLE_ADMIN);

    private String value;

    ERole(String roleCustomer) {
    }

    public static class Values {
        public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
        public static final String ROLE_CAR_OWNER = "ROLE_CAR_OWNER";
        public static final String ROLE_ADMIN="ROLE_ADMIN";
    }
}
