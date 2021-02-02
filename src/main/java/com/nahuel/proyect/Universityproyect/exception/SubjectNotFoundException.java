package com.nahuel.proyect.Universityproyect.exception;

/**
 * class responsible for creating an exception when a subject is not found
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
public class SubjectNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 1L;

    /**
     * method that indicating that a subject was not found
     *
     * @param id to search
     */
    public SubjectNotFoundException(Long id) {
        super(String.format("The subject with id %d is not found", id));
    }
}
