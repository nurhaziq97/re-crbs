package com.haziq.crbs.common;

public interface GenericEntity <T> {
    // update current instance with provided data
    void update(T source);

    Long getId();

    // create an instance based on current data with new id
    T createNewInstance();
}
