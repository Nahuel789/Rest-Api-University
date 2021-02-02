package com.nahuel.proyect.Universityproyect.exception;

/**
 * class responsible for creating an exception when a teacher is not found
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
public class TeacherNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 1L;

    /**
     * class of the exception indicating that a teacher was not found
     *
     * @param id to search
     */
    public TeacherNotFoundException(Long id) {
        super(String.format("The teacher with id %d not found", id));
    }

}
