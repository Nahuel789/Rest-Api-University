package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.model.Teacher;
import com.nahuel.proyect.Universityproyect.exception.TeacherNotFoundException;

import java.util.List;

/**
 * interface in which it is sought to decouple
 * the code with respect to the implementation of the service
 */
public interface TeacherService {
    List<Teacher> findAll();

    Long save(Teacher user);

    Teacher findById(Long aLong) throws TeacherNotFoundException;

    void addScheduleToTeacher(Long idTeacher, Long idSchedule);

    void addSubjectToTeacher(Long idTeacher, Long idSubject);
}

