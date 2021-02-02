package com.nahuel.proyect.Universityproyect.exception;

/**
 * Class responsible for creating an exception when a schedule is not found
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
public class ScheduleNotFoundException extends NotFoundException {
    private static final long serialVersionUID = 1L;

    /**
     * method that indicating that a schedule was not found
     *
     * @param id to search
     */
    public ScheduleNotFoundException(Long id) {
        super(String.format("The schedule with id %d is not found", id));
    }

}
