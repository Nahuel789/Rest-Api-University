package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.exception.ScheduleNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Schedule;

import java.util.List;

/**
 * interface in which it is sought to decouple
 * the code with respect to the implementation of the service
 */
public interface ScheduleService {

    List<Schedule> findAll();

    Long save(Schedule schedule);

    Schedule findById(Long aLong) throws ScheduleNotFoundException;
}
