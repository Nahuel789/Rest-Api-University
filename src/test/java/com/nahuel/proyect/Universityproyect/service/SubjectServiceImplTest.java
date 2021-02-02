package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.exception.SubjectNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Subject;
import com.nahuel.proyect.Universityproyect.repository.SubjectDao;
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
class SubjectServiceImplTest {

    @Autowired
    private SubjectServiceImpl subjectService;
    @MockBean
    private SubjectDao subjectDao;

    @Test
    void findAll() {
        List<Subject> list = new ArrayList<>();

        list.add(new Subject(1L, "Maths"));
        list.add(new Subject(2L, "Geography"));
        list.add(new Subject(3L, "History"));

        when(subjectDao.findAll()).thenReturn(list);

        assertEquals(3, subjectService.findAll().size());
    }

    @Test
    void save() {
        Subject subject = new Subject();

        subject.setId(1L);
        subject.setName("History");

        when(subjectDao.save(subject)).thenReturn(subject);

        assertEquals(subject.getId(), subjectService.save(subject));
    }

    @Test
    void findById() throws SubjectNotFoundException {
        List<Subject> list = new ArrayList<>();

        list.add(new Subject(1L, "Maths"));
        list.add(new Subject(2L, "Programming"));

        when(subjectDao.findById(2L)).thenReturn(Optional.ofNullable(list.get(1)));

        assertEquals("Programming", subjectService.findById(2L).getName());
    }
}