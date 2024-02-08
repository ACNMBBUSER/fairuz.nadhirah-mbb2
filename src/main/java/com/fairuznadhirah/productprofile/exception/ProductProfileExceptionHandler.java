package com.fairuznadhirah.productprofile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductProfileExceptionHandler {

    @ExceptionHandler(value = {ProductProfileNotFoundException.class})
    public ResponseEntity<Object> handleProductProfileNotFoundException
            (ProductProfileNotFoundException productProfileNotFoundException)
    {
        ProductProfileException productProfileException = new ProductProfileException(
                productProfileNotFoundException.getMessage(),
                productProfileNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(productProfileException, HttpStatus.NOT_FOUND);
    }
}
