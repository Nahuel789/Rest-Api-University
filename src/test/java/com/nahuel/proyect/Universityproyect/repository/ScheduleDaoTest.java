package com.nahuel.proyect.Universityproyect.repository;

import com.nahuel.proyect.Universityproyect.model.Schedule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ScheduleDaoTest {

    @Autowired
    private ScheduleDao scheduleDao;

    @Test
    public void findAllSchedulesFromDB() {

        Schedule schedule = new Schedule();
        schedule.setId(1L);
        schedule.setStartTime("08:30");
        schedule.setEndTime("10:30");
        schedule.setMonday(true);
        schedule.setTuesday(true);
        schedule.setWednesday(true);
        schedule.setThursday(false);
        schedule.setFriday(true);
        scheduleDao.save(schedule);

        Schedule schedule2 = new Schedule();
        schedule2.setId(2L);
        schedule2.setStartTime("10:30");
        schedule2.setEndTime("12:30");
        schedule2.setMonday(true);
        schedule2.setTuesday(false);
        schedule2.setWednesday(true);
        schedule2.setThursday(false);
        schedule2.setFriday(true);
        scheduleDao.save(schedule2);

        List<Schedule> schedules = scheduleDao.findAll();

        assertEquals(2, schedules.size());

        assertEquals(1L, schedules.get(0).getId());
        assertEquals("08:30", schedules.get(0).getStartTime());
        assertEquals("10:30", schedules.get(0).getEndTime());
        assertTrue(schedules.get(0).isMonday());
        assertTrue(schedules.get(0).isTuesday());
        assertTrue(schedules.get(0).isWednesday());
        assertFalse(schedules.get(0).isThursday());
        assertTrue(schedules.get(0).isFriday());

        assertEquals(2L, schedules.get(1).getId());
        assertEquals("10:30", schedules.get(1).getStartTime());
        assertEquals("12:30", schedules.get(1).getEndTime());
        assertTrue(schedules.get(1).isMonday());
        assertFalse(schedules.get(1).isTuesday());
        assertTrue(schedules.get(1).isWednesday());
        assertFalse(schedules.get(1).isThursday());
        assertTrue(schedules.get(1).isFriday());
    }

    @Test
    public void findScheduleByIdFromDB() {

        Schedule schedule = new Schedule();
        schedule.setId(1L);
        schedule.setStartTime("08:30");
        schedule.setEndTime("10:30");
        schedule.setMonday(true);
        schedule.setTuesday(true);
        schedule.setWednesday(true);
        schedule.setThursday(false);
        schedule.setFriday(true);
        scheduleDao.save(schedule);

        Schedule schedule2 = new Schedule();
        schedule2.setId(2L);
        schedule2.setStartTime("10:30");
        schedule2.setEndTime("12:30");
        schedule2.setMonday(true);
        schedule2.setTuesday(false);
        schedule2.setWednesday(true);
        schedule2.setThursday(false);
        schedule2.setFriday(true);
        scheduleDao.save(schedule2);

        Optional<Schedule> scheduleDaoById = scheduleDao.findById(2L);

        if (scheduleDaoById.isPresent()) {
            assertEquals(2L, scheduleDaoById.get().getId());
            assertEquals("10:30", scheduleDaoById.get().getStartTime());
            assertEquals("12:30", scheduleDaoById.get().getEndTime());
            assertTrue(scheduleDaoById.get().isMonday());
            assertFalse(scheduleDaoById.get().isTuesday());
            assertTrue(scheduleDaoById.get().isWednesday());
            assertFalse(scheduleDaoById.get().isThursday());
            assertTrue(scheduleDaoById.get().isFriday());
        }
    }

}