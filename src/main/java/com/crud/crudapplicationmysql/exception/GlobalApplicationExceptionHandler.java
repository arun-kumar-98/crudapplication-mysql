package com.crud.crudapplicationmysql.exception;

import com.crud.crudapplicationmysql.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;
import java.util.Date;

@RestControllerAdvice
public class GlobalApplicationExceptionHandler implements Serializable {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleProductNotFoundException(ProductNotFoundException e) {

        return new ResponseEntity<ErrorDetails>(new ErrorDetails(e.getMessage(), new Date(), "product-not found"),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
