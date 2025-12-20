package com.example.Practice.utills;

import com.example.Practice.utills.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Collections;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseWrapper<ErrorDetails>> handleNotFound(EmployeeNotFoundException ex) {

        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                "4001" // your custom error code
        );

        ResponseWrapper<ErrorDetails> response = new ResponseWrapper<>(
                400,
                "Failed",
                Collections.singletonList(error)
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseWrapper<ErrorDetails>> handleGlobal(Exception ex) {

        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                "5000"
        );

        ResponseWrapper<ErrorDetails> response = new ResponseWrapper<>(
                500,
                "Error",
                Collections.singletonList(error)
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseWrapper<ErrorDetails>> handleBadJson(Exception ex) {

        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                "Invalid JSON format. Please check request body.",
                "4002"
        );

        ResponseWrapper<ErrorDetails> response =
                new ResponseWrapper<>(400, "Failed", Collections.singletonList(error));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseWrapper<ErrorDetails>> handleTypeMismatch(Exception ex) {

        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                "Invalid Path Variable Type (ID must be a number)",
                "4003"
        );



        ResponseWrapper<ErrorDetails> response =
                new ResponseWrapper<>(400, "Failed", Collections.singletonList(error));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    

}

