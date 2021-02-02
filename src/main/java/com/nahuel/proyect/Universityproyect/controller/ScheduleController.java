package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.exception.ScheduleNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Schedule;
import com.nahuel.proyect.Universityproyect.service.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class of the entity schedule
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl scheduleServiceImpl;

    /**
     * Controller that gets list of schedules returned by the service
     *
     * @return List of schedules
     */
    @GetMapping("/schedules")
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> list = scheduleServiceImpl.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * Controller that get one schedule returned by the service
     *
     * @param id schedule
     * @return a schedule
     */
    @GetMapping(value = "/schedules/{id}")
    public ResponseEntity<Schedule> scheduleById(@PathVariable("id") Long id) throws ScheduleNotFoundException {
        Schedule schedule = scheduleServiceImpl.findById(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    /**
     * Controller that with the post method passes the classroom to the service
     *
     * @param schedule in the body
     * @return new id schedule
     */
    @PostMapping(value = "/schedules")
    public ResponseEntity<Long> create(@RequestBody Schedule schedule) {
        Long id = scheduleServiceImpl.save(schedule);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }
}
