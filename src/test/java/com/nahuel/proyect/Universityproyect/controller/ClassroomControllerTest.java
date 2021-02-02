package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.exception.ClassroomNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Classroom;
import com.nahuel.proyect.Universityproyect.service.ClassroomServiceImpl;
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
class ClassroomControllerTest {

    @Autowired
    private ClassroomController classroomController;

    @MockBean
    private ClassroomServiceImpl classroomService;


    @Test
    void getAllClassrooms() {
        List<Classroom> list = new ArrayList<>();
        list.add(new Classroom(1L, "classroom_1"));
        list.add(new Classroom(2L, "classroom_2"));
        list.add(new Classroom(3L, "classroom_3"));

        when(classroomService.findAll()).thenReturn(list);

        assertEquals(1L, Objects.requireNonNull(classroomController.getAllClassrooms().getBody()).get(0).getId());
        assertEquals("classroom_1", classroomController.getAllClassrooms().getBody().get(0).getName());

        assertEquals(2L, classroomController.getAllClassrooms().getBody().get(1).getId());
        assertEquals("classroom_2", classroomController.getAllClassrooms().getBody().get(1).getName());

        assertEquals(3L, classroomController.getAllClassrooms().getBody().get(2).getId());
        assertEquals("classroom_3", classroomController.getAllClassrooms().getBody().get(2).getName());

    }

    @Test
    void classroomById() throws ClassroomNotFoundException {

        List<Classroom> list = new ArrayList<>();
        list.add(new Classroom(1L, "classroom_1"));
        list.add(new Classroom(2L, "classroom_2"));
        list.add(new Classroom(3L, "classroom_3"));

        when(classroomService.findById(3L)).thenReturn(list.get(2));

        assertEquals(3L, Objects.requireNonNull(classroomController.classroomById(3L).getBody()).getId());
        assertEquals("classroom_3", Objects.requireNonNull(classroomController.classroomById(3L).getBody()).getName());
    }

    @Test
    void create() {
        Classroom classroom = new Classroom();

        classroom.setId(1L);
        classroom.setName("classroom_1");

        when(classroomService.save(classroom)).thenReturn(classroom.getId());

        assertEquals(1L, Objects.requireNonNull(classroomController.create(classroom).getBody()).longValue());
    }
}