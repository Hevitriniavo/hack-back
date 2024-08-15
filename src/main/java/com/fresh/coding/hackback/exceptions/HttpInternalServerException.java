package com.fresh.coding.hackback.exceptions;

public class HttpInternalServerException extends RuntimeException {
    public HttpInternalServerException(String message) {
        super(message);
    }
}
