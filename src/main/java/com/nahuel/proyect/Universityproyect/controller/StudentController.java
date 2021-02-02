package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.Ids;
import com.nahuel.proyect.Universityproyect.model.Student;
import com.nahuel.proyect.Universityproyect.service.ScheduleServiceImpl;
import com.nahuel.proyect.Universityproyect.service.StudentServiceImpl;
import com.nahuel.proyect.Universityproyect.exception.StudentNotFoundException;
import com.nahuel.proyect.Universityproyect.service.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class of the entity Student
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;
    @Autowired
    private ScheduleServiceImpl scheduleServiceImpl;
    @Autowired
    private SubjectServiceImpl subjectServiceImpl;

    /**
     * Controller that gets list of students returned by the service
     *
     * @return list of students
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> list = studentServiceImpl.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Controller that get one student returned by the service
     *
     * @param id student
     * @return a student
     */
    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> studentById(@PathVariable("id") Long id) throws StudentNotFoundException {
        Student user = studentServiceImpl.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Controller that with the post method passes the student to the service
     *
     * @param student in the body
     * @return new id student
     */
    @PostMapping(value = "/students")
    public ResponseEntity<Long> create(@RequestBody Student student) {
        Long id = studentServiceImpl.save(student);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    /**
     * Controller that with the post method assigns a subjects to the a students
     *
     * @param ids object with id1 students - id2 subjects
     */
    @PostMapping(value = "/students/subjects")
    public void addSubjectToStudent(@RequestBody Ids ids) {
        studentServiceImpl.addSubjectToStudent(ids.getId_1(), ids.getId_2());
    }

    /**
     * Controller that with the post method assigns a schedules to the a students
     *
     * @param ids object with id1 students - id2 schedules
     */
    @PostMapping(value = "/students/schedules")
    public void addScheduleToStudent(@RequestBody Ids ids) {
        studentServiceImpl.addScheduleToStudent(ids.getId_1(), ids.getId_2());
    }
}
