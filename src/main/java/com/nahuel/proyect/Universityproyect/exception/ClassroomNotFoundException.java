package com.nahuel.proyect.Universityproyect.exception;

/**
 * Class responsible for creating an exception when a classroom is not found
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
public class ClassroomNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 1L;

    /**
     * method that indicating that a classroom was not found
     *
     * @param id to search
     */
    public ClassroomNotFoundException(Long id) {
        super(String.format("The classroom with id :%d is not found", id));
    }
}
