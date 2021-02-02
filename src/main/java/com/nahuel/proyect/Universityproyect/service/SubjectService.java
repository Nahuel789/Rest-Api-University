package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.model.Subject;
import com.nahuel.proyect.Universityproyect.exception.SubjectNotFoundException;

import java.util.List;

/**
 * interface in which it is sought to decouple
 * the code with respect to the implementation of the service
 */
public interface SubjectService {
    List<Subject> findAll();

    Long save(Subject subject);

    Subject findById(Long aLong) throws SubjectNotFoundException;

    void enroleStudentToSubject(Long id1, Long id2);

    void addTeacherToSubject(Long id1, Long id2);
}
