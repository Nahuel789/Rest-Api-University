package com.nahuel.proyect.Universityproyect.exception;

/**
 * class responsible for creating an exception when a student is not found
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
public class StudentNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 1L;

    /**
     * method that indicating that a student was not found
     *
     * @param id to search
     */
    public StudentNotFoundException(Long id) {
        super(String.format("The student with id %d is not found", id));
    }

}
