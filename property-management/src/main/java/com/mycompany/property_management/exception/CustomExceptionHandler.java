package com.mycompany.property_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(BuisnessException.class)
    public ResponseEntity<List<ErrorModal>> handleBuisnessException(BuisnessException bex)
    {
      System.out.println("Buisness exception is thrown");
      return new ResponseEntity<List<ErrorModal>>(bex.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
