package com.fairuznadhirah.productprofile.exception;

import org.springframework.http.HttpStatus;

public class ProductProfileException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

    public ProductProfileException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }
}
