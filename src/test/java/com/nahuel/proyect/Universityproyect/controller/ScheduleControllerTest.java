package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.exception.ScheduleNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Schedule;
import com.nahuel.proyect.Universityproyect.service.ScheduleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class ScheduleControllerTest {

    @Autowired
    private ScheduleController scheduleController;

    @MockBean
    private ScheduleServiceImpl scheduleService;


    @Test
    void getAllSchedules() {

        List<Schedule> list = new ArrayList<>();

        list.add(new Schedule(1L, "08:30", "10:30", true, true, false, true, false));
        list.add(new Schedule(2L, "09:30", "11:30", true, false, true, false, true));

        when(scheduleService.findAll()).thenReturn(list);

        assertEquals(2, Objects.requireNonNull(scheduleController.getAllSchedules().getBody()).size());

        assertEquals(1L, Objects.requireNonNull(scheduleController.getAllSchedules().getBody().get(0).getId()));
        assertEquals("08:30", Objects.requireNonNull(scheduleController.getAllSchedules().getBody().get(0).getStartTime()));
        assertEquals("10:30", Objects.requireNonNull(scheduleController.getAllSchedules().getBody().get(0).getEndTime()));
        assertTrue(scheduleController.getAllSchedules().getBody().get(0).isMonday());
        assertTrue(scheduleController.getAllSchedules().getBody().get(0).isTuesday());
        assertFalse(scheduleController.getAllSchedules().getBody().get(0).isWednesday());
        assertTrue(scheduleController.getAllSchedules().getBody().get(0).isThursday());
        assertFalse(scheduleController.getAllSchedules().getBody().get(0).isFriday());

        assertEquals(2L, Objects.requireNonNull(scheduleController.getAllSchedules().getBody().get(1).getId()));
        assertEquals("09:30", Objects.requireNonNull(scheduleController.getAllSchedules().getBody().get(1).getStartTime()));
        assertEquals("11:30", Objects.requireNonNull(scheduleController.getAllSchedules().getBody().get(1).getEndTime()));
        assertTrue(scheduleController.getAllSchedules().getBody().get(1).isMonday());
        assertFalse(scheduleController.getAllSchedules().getBody().get(1).isTuesday());
        assertTrue(scheduleController.getAllSchedules().getBody().get(1).isWednesday());
        assertFalse(scheduleController.getAllSchedules().getBody().get(1).isThursday());
        assertTrue(scheduleController.getAllSchedules().getBody().get(1).isFriday());

    }

    @Test
    void scheduleById() throws ScheduleNotFoundException {
        List<Schedule> list = new ArrayList<>();

        list.add(new Schedule(1L, "08:30", "10:30", true, true, false, true, false));
        list.add(new Schedule(2L, "09:30", "11:30", true, false, true, false, true));

        when(scheduleService.findById(2L)).thenReturn(list.get(1));

        assertEquals(2L, Objects.requireNonNull(scheduleController.scheduleById(2L).getBody()).getId());
        assertEquals("09:30", (Objects.requireNonNull(scheduleController.scheduleById(2L).getBody()).getStartTime()));
        assertEquals("11:30", (Objects.requireNonNull(scheduleController.scheduleById(2L).getBody()).getEndTime()));
        assertTrue(Objects.requireNonNull(scheduleController.scheduleById(2L).getBody()).isMonday());
        assertFalse(Objects.requireNonNull(scheduleController.scheduleById(2L).getBody()).isTuesday());
        assertTrue(Objects.requireNonNull(scheduleController.scheduleById(2L).getBody()).isWednesday());
        assertFalse(Objects.requireNonNull(scheduleController.scheduleById(2L).getBody()).isThursday());
        assertTrue(Objects.requireNonNull(scheduleController.scheduleById(2L).getBody()).isFriday());
    }

    @Test
    void create() {
        Schedule schedule = new Schedule();

        schedule.setId(1L);
        schedule.setStartTime("14:30");
        schedule.setEndTime("16:30");
        schedule.setMonday(true);
        schedule.setTuesday(true);
        schedule.setWednesday(true);
        schedule.setThursday(false);
        schedule.setFriday(false);

        when(scheduleService.save(schedule)).thenReturn(schedule.getId());

        assertEquals(1L, Objects.requireNonNull(scheduleController.create(schedule).getBody()).longValue());
    }
}