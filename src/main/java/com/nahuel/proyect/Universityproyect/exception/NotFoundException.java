package com.nahuel.proyect.Universityproyect.exception;

/**
 * Class responsible for creating an exception not found
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
public class NotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * method that indicating  not found
     *
     * @param message message obtain
     */
    public NotFoundException(String message) {
        super(message);
    }
}
