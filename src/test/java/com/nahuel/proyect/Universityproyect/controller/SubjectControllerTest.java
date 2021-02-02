package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.exception.SubjectNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Subject;
import com.nahuel.proyect.Universityproyect.service.SubjectServiceImpl;
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
class SubjectControllerTest {

    @Autowired
    private SubjectController subjectController;

    @MockBean
    private SubjectServiceImpl subjectService;


    @Test
    void getAllSubjects() {

        List<Subject> list = new ArrayList<>();

        list.add(new Subject(1L, "Geography"));
        list.add(new Subject(2L, "Maths"));
        list.add(new Subject(3L, "Programming"));

        when(subjectService.findAll()).thenReturn(list);

        assertEquals(3, Objects.requireNonNull(subjectController.getAllSubjects().getBody()).size());

        assertEquals(1L, Objects.requireNonNull(subjectController.getAllSubjects().getBody().get(0).getId()));
        assertEquals("Geography", Objects.requireNonNull(subjectController.getAllSubjects().getBody().get(0).getName()));

        assertEquals(2L, Objects.requireNonNull(subjectController.getAllSubjects().getBody().get(1).getId()));
        assertEquals("Maths", Objects.requireNonNull(subjectController.getAllSubjects().getBody().get(1).getName()));

        assertEquals(3L, Objects.requireNonNull(subjectController.getAllSubjects().getBody().get(2).getId()));
        assertEquals("Programming", Objects.requireNonNull(subjectController.getAllSubjects().getBody().get(2).getName()));
    }

    @Test
    void subjectsById() throws SubjectNotFoundException {
        List<Subject> list = new ArrayList<>();

        list.add(new Subject(1L, "Geography"));
        list.add(new Subject(2L, "Maths"));
        list.add(new Subject(3L, "Programming"));

        when(subjectService.findById(2L)).thenReturn(list.get(1));

        assertEquals(2L, Objects.requireNonNull(subjectController.subjectsById(2L).getBody()).getId());
        assertEquals("Maths", Objects.requireNonNull(subjectController.subjectsById(2L).getBody()).getName());
    }

    @Test
    void create() {
        Subject subject = new Subject();

        subject.setId(1L);
        subject.setName("History");

        when(subjectService.save(subject)).thenReturn(subject.getId());

        assertEquals(1L, Objects.requireNonNull(subjectController.create(subject).getBody()).longValue());
    }
}