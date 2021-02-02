package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.Ids;
import com.nahuel.proyect.Universityproyect.model.Subject;
import com.nahuel.proyect.Universityproyect.service.StudentServiceImpl;
import com.nahuel.proyect.Universityproyect.service.SubjectServiceImpl;
import com.nahuel.proyect.Universityproyect.service.TeacherServiceImpl;
import com.nahuel.proyect.Universityproyect.exception.SubjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class of the entity subject
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@RestController
public class SubjectController {

    @Autowired
    private SubjectServiceImpl subjectServiceImpl;
    @Autowired
    private StudentServiceImpl studentServiceImpl;
    @Autowired
    private TeacherServiceImpl teacherServiceImpl;

    /**
     * Controller that gets list of subjects returned by the service
     *
     * @return list of subjects
     */
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> list = subjectServiceImpl.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Controller that get a subject returned by the service
     *
     * @param id subject
     * @return a subject
     * @throws SubjectNotFoundException aaa
     */
    @GetMapping(value = "/subjects/{id}")
    public ResponseEntity<Subject> subjectsById(@PathVariable("id") Long id) throws SubjectNotFoundException {
        Subject subject = subjectServiceImpl.findById(id);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    /**
     * Controller that with the post method passes the subject to the service
     *
     * @param subject aaaaa
     * @return new id subject
     */
    @PostMapping(value = "/subjects")
    public ResponseEntity<Long> create(@RequestBody Subject subject) {
        Long id = subjectServiceImpl.save(subject);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    /**
     * Controller that with the post method assigns a student to the a subject
     *
     * @param ids object with id1 and id2
     */
    @PostMapping(value = "/subjects/students")
    public void addStudentToSubject(@RequestBody Ids ids) {
        subjectServiceImpl.enroleStudentToSubject(ids.getId_1(), ids.getId_2());
    }

    /**
     * Controller that with the post method assigns a teacher to the a subject
     *
     * @param ids object with id subject - id teacher
     */
    @PostMapping(value = "/subjects/{id}/teachers/{idTeacher}")
    public void addTeacherToSubject(@RequestBody Ids ids) {
        subjectServiceImpl.addTeacherToSubject(ids.getId_1(), ids.getId_2());
    }
}
