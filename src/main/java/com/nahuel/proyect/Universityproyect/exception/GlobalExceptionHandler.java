package com.nahuel.proyect.Universityproyect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Class responsible to handle the errors
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * method that handle the exception ClassNotFoundException
     *
     * @param exception ClassNotFoundException
     * @param request   web
     * @return the error details
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> NotFoundException(Exception exception, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * method that handle all the exceptions
     *
     * @param ex      all exceptions
     * @param request web
     * @return the error details
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
