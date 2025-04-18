package com.nit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomerExceptionHandler {
        @ExceptionHandler(value = {Exception .class})
        public ResponseEntity<String> getAllQuestions() {
            return new ResponseEntity<>("Some error occurred,. Please try again", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


