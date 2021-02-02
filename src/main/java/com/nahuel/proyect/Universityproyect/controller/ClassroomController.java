package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.model.Classroom;
import com.nahuel.proyect.Universityproyect.Ids;
import com.nahuel.proyect.Universityproyect.service.ClassroomServiceImpl;
import com.nahuel.proyect.Universityproyect.exception.ClassroomNotFoundException;
import com.nahuel.proyect.Universityproyect.service.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class of the entity classroom
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@RestController
public class ClassroomController {

    @Autowired
    private ClassroomServiceImpl classroomServiceImpl;
    @Autowired
    private SubjectServiceImpl subjectServiceImpl;

    /**
     * Controller that gets list of classrooms returned by the service
     *
     * @return list of classrooms
     */
    @GetMapping("/classrooms")
    public ResponseEntity<List<Classroom>> getAllClassrooms() {
        List<Classroom> list = classroomServiceImpl.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Controller that get one classroom returned by the service
     *
     * @param id classroom
     * @return classroom
     */
    @GetMapping(value = "/classrooms/{id}")
    public ResponseEntity<Classroom> classroomById(@PathVariable("id") Long id) throws ClassroomNotFoundException {
        Classroom classroom = classroomServiceImpl.findById(id);
        return new ResponseEntity<>(classroom, HttpStatus.OK);
    }

    /**
     * Controller that with the post method passes the classroom to the service
     *
     * @param classroom in the body
     * @return new classroom id
     */
    @PostMapping(value = "/classrooms")
    public ResponseEntity<Long> create(@RequestBody Classroom classroom) {
        Long id = classroomServiceImpl.save(classroom);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    /**
     * Controller that with the post method assigns a subject to the a classroom
     *
     * @param ids id classroom - id subject
     */
    @PostMapping(value = "/classrooms/subjects")
    public void addSubjectToClassroom(@RequestBody Ids ids) {
        classroomServiceImpl.addSubjectToClassroom(ids.getId_1(), ids.getId_2());

    }
}
