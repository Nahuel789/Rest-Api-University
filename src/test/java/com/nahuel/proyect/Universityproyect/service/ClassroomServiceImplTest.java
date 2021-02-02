package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.exception.ClassroomNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Classroom;
import com.nahuel.proyect.Universityproyect.repository.ClassroomDao;
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
class ClassroomServiceImplTest {

    @Autowired
    private ClassroomServiceImpl classroomService;
    @MockBean
    private ClassroomDao classroomDao;

    @Test
    void findAll() {
        List<Classroom> list = new ArrayList<>();

        list.add(new Classroom(1L, "classroom_1"));
        list.add(new Classroom(2L, "classroom_2"));
        list.add(new Classroom(3L, "classroom_3"));
        list.add(new Classroom(4L, "classroom_4"));

        when(classroomDao.findAll()).thenReturn(list);

        assertEquals(4, classroomService.findAll().size());
    }

    @Test
    void save() {
        Classroom classroom = new Classroom();

        classroom.setId(1L);
        classroom.setName("classroom_1");

        when(classroomDao.save(classroom)).thenReturn(classroom);

        assertEquals(classroom.getId(), classroomService.save(classroom));
    }

    @Test
    void findById() throws ClassroomNotFoundException {
        List<Classroom> list = new ArrayList<>();

        list.add(new Classroom(1L, "classroom_1"));
        list.add(new Classroom(2L, "classroom_2"));

        when(classroomDao.findById(1L)).thenReturn(Optional.ofNullable((list.get(0))));

        assertEquals("classroom_1", classroomService.findById(1L).getName());
    }
}