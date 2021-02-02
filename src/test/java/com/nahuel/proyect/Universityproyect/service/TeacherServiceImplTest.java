package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.exception.TeacherNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Teacher;
import com.nahuel.proyect.Universityproyect.repository.TeacherDao;
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
class TeacherServiceImplTest {

    @Autowired
    private TeacherServiceImpl teacherService;
    @MockBean
    private TeacherDao teacherDao;

    @Test
    void findAll() {
        List<Teacher> list = new ArrayList<>();

        list.add(new Teacher(1L, "Pedro", "Diaz"));
        list.add(new Teacher(2L, "Juan", "Gomez"));

        when(teacherDao.findAll()).thenReturn(list);

        assertEquals(2, teacherService.findAll().size());
    }

    @Test
    void save() {
        Teacher teacher = new Teacher();

        teacher.setId(1L);
        teacher.setName("Roberto");
        teacher.setLastName("Carlos");

        when(teacherDao.save(teacher)).thenReturn(teacher);

        assertEquals(teacher.getId(), teacherService.save(teacher));
    }

    @Test
    void findById() throws TeacherNotFoundException {
        List<Teacher> list = new ArrayList<>();

        list.add(new Teacher(1L, "Pedro", "Diaz"));
        list.add(new Teacher(2L, "Juan", "Gomez"));

        when(teacherDao.findById(2L)).thenReturn(Optional.ofNullable(list.get(1)));

        assertEquals("Juan", teacherService.findById(2L).getName());
    }
}