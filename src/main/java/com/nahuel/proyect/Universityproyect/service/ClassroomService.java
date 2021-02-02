package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.model.Classroom;
import com.nahuel.proyect.Universityproyect.exception.ClassroomNotFoundException;

import java.util.List;

/**
 * interface in which it is sought to decouple
 * the code with respect to the implementation service
 */
public interface ClassroomService {
    List<Classroom> findAll();

    Long save(Classroom classroom);

    Classroom findById(Long aLong) throws ClassroomNotFoundException;
}
