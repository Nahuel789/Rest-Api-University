package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.exception.ScheduleNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Schedule;
import com.nahuel.proyect.Universityproyect.repository.ScheduleDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ScheduleServiceImplTest {
    @Autowired
    private ScheduleServiceImpl scheduleService;
    @MockBean
    private ScheduleDao scheduleDao;

    @Test
    void findAll() {
        List<Schedule> list = new ArrayList<>();

        list.add(new Schedule(1L, "08:30", "12:30", true, true, true, true, true));
        list.add(new Schedule(2L, "16:30", "20:30", true, true, true, true, true));
        list.add(new Schedule(3L, "20:30", "22:30", true, true, true, true, true));

        when(scheduleDao.findAll()).thenReturn(list);

        assertEquals(3, scheduleService.findAll().size());
    }

    @Test
    void save() {
        Schedule schedule = new Schedule(1L, "08:30", "12:30", true, true, true, true, true);

        when(scheduleDao.save(schedule)).thenReturn(schedule);

        assertEquals(schedule.getId(), scheduleService.save(schedule));
    }

    @Test
    void findById() throws ScheduleNotFoundException {
        List<Schedule> list = new ArrayList<>();

        list.add(new Schedule(1L, "08:30", "12:30", true, true, true, true, true));
        list.add(new Schedule(2L, "16:30", "20:30", true, true, true, true, true));

        when(scheduleDao.findById(1L)).thenReturn(Optional.ofNullable(list.get(0)));

        assertEquals("08:30", scheduleService.findById(1L).getStartTime());
    }
}