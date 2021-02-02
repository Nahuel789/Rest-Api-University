package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.exception.TeacherNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Teacher;
import com.nahuel.proyect.Universityproyect.service.TeacherServiceImpl;
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
class TeacherControllerTest {

    @Autowired
    private TeacherController teacherController;

    @MockBean
    private TeacherServiceImpl teacherService;

    @Test
    void getAllTeachers() {

        List<Teacher> list = new ArrayList<>();

        list.add(new Teacher(1L, "Pedro", "Diaz"));
        list.add(new Teacher(2L, "Juan", "Gomez"));

        when(teacherService.findAll()).thenReturn(list);

        assertEquals(2, Objects.requireNonNull(teacherController.getAllTeachers().getBody()).size());
    }

    @Test
    void teacherById() throws TeacherNotFoundException {
        List<Teacher> list = new ArrayList<>();

        list.add(new Teacher(1L, "Pedro", "Diaz"));
        list.add(new Teacher(2L, "Juan", "Gomez"));

        when(teacherService.findById(2L)).thenReturn(list.get(1));

        assertEquals("Juan", Objects.requireNonNull(teacherController.teacherById(2L).getBody()).getName());
    }

    @Test
    void create() {
        Teacher teacher = new Teacher();

        teacher.setId(1L);
        teacher.setName("Roberto");
        teacher.setLastName("Carlos");

        when(teacherService.save(teacher)).thenReturn(teacher.getId());

        assertEquals(teacher.getId(), Objects.requireNonNull(teacherController.create(teacher).getBody()).longValue());
    }
}