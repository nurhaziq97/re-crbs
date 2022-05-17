package com.haziq.crbs.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse<T> {
    private String message;
    private int code;
    private T data;
    private boolean success;

    /**
     * Success response
     *
     * @param data
     * the data that will be delivered on api request success
     * @param message
     * message that will be sent together
     */
    public MessageResponse(T data, String message) {
        this.data = data;
        this.message = message;
        this.code = 200;
        this.success = true;
    }

    /**
     * Success Response
     *
     * @param data
     * Send data on success
     */
    public MessageResponse(T data) {
        this.data = data;
        this.code = 200;
        this.success = true;
    }

    /**
     * Error Response
     *
     * @param message
     * Message that will be sent when request failed
     */
    public MessageResponse(String message) {
        this.success = false;
    }
}
