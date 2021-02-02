package com.nahuel.proyect.Universityproyect.exception;

import java.util.Date;

/**
 * Class responsible for reporting the details of the error at runtime
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;

    /**
     * Constructor of error details
     *
     * @param timestamp horario actual
     * @param message   de error
     * @param details   de error
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * method that gets the timestamp
     *
     * @return timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * method that gets the message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * method that gets the details
     *
     * @return details
     */
    public String getDetails() {
        return details;
    }
}