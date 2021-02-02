package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.model.Student;
import com.nahuel.proyect.Universityproyect.exception.StudentNotFoundException;

import java.util.List;

/**
 * interface in which it is sought to decouple
 * the code with respect to the implementation of the service
 */
public interface StudentService {
    List<Student> findAll();

    Long save(Student user);

    Student findById(Long aLong) throws StudentNotFoundException;

    void addSubjectToStudent(Long id1, Long id2);

    void addScheduleToStudent(Long id1, Long id2);
}
