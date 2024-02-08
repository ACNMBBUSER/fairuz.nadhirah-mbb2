package com.fairuznadhirah.productprofile.exception;

public class ProductProfileNotFoundException extends RuntimeException{
    public ProductProfileNotFoundException() {
    }

    public ProductProfileNotFoundException(String message) {
        super(message);
    }

    public ProductProfileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
