package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.Ids;
import com.nahuel.proyect.Universityproyect.model.Teacher;
import com.nahuel.proyect.Universityproyect.service.ScheduleServiceImpl;
import com.nahuel.proyect.Universityproyect.service.SubjectServiceImpl;
import com.nahuel.proyect.Universityproyect.service.TeacherServiceImpl;
import com.nahuel.proyect.Universityproyect.exception.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class of the entity teacher
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@RestController
public class TeacherController {

    @Autowired
    TeacherServiceImpl teacherServiceImpl;
    @Autowired
    ScheduleServiceImpl scheduleServiceImpl;
    @Autowired
    SubjectServiceImpl subjectServiceImpl;

    /**
     * Controller that gets list of teachers returned by the service
     *
     * @return List of teachers
     */
    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> list = teacherServiceImpl.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Controller that get a teacher returned by the service
     *
     * @param id of teacher
     * @return a teacher
     */
    @GetMapping(value = "/teachers/{id}")
    public ResponseEntity<Teacher> teacherById(@PathVariable("id") Long id) throws TeacherNotFoundException {
        Teacher teacher = teacherServiceImpl.findById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    /**
     * Controller that with the post method passes the teacher to the service
     *
     * @param teacher created
     * @return new id teacher
     */
    @PostMapping(value = "/teachers")
    public ResponseEntity<Long> create(@RequestBody Teacher teacher) {
        Long idReturned = teacherServiceImpl.save(teacher);
        return new ResponseEntity<>(idReturned, HttpStatus.CREATED);
    }

    /**
     * Controller that with the post method assigns a schedule to the teacher
     *
     * @param id id teacher - id schedule
     */
    @PostMapping(value = "/teachers/schedules")
    public void addScheduleToTeacher(@RequestBody Ids id) {
        teacherServiceImpl.addScheduleToTeacher(id.getId_1(), id.getId_2());
    }

    /**
     * Controller that with the post method assigns a subject to the teacher
     *
     * @param ids id teacher - id subject
     */
    @PostMapping(value = "/teachers/subjects")
    public void addSubjectToTeacher(@RequestBody Ids ids) {
        teacherServiceImpl.addSubjectToTeacher(ids.getId_1(), ids.getId_2());
    }
}
