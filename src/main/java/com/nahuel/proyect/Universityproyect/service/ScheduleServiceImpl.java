package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.exception.ScheduleNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Schedule;
import com.nahuel.proyect.Universityproyect.repository.ScheduleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of the service interface of a schedule
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    /**
     * Method that returns the list from the database
     *
     * @return List of schedules
     */
    @Transactional(readOnly = true)
    public List<Schedule> findAll() {
        return scheduleDao.findAll();
    }

    /**
     * method to save a schedule in the database
     *
     * @param schedule to save
     * @return long id schedule
     */
    @Transactional
    public Long save(Schedule schedule) {
        Schedule schedule1 = new Schedule();
        schedule1.setId(schedule.getId());
        schedule1.setStartTime(schedule.getStartTime());
        schedule1.setEndTime(schedule.getEndTime());
        schedule1.setMonday(schedule.isMonday());
        schedule1.setTuesday(schedule.isTuesday());
        schedule1.setWednesday(schedule.isWednesday());
        schedule1.setThursday(schedule.isThursday());
        schedule1.setFriday(schedule.isFriday());
        return scheduleDao.save(schedule1).getId();
    }

    /**
     * method that search a schedule in the database
     *
     * @param aLong id to search
     * @return schedule
     */
    @Transactional(readOnly = true)
    public Schedule findById(Long aLong) throws ScheduleNotFoundException {
        return scheduleDao.findById(aLong).orElseThrow(() -> new ScheduleNotFoundException(aLong));
    }
}
