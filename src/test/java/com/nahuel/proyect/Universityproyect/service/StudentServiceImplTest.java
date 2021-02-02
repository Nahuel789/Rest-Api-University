package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.exception.StudentNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Student;
import com.nahuel.proyect.Universityproyect.repository.StudentDao;
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
class StudentServiceImplTest {

    @Autowired
    private StudentServiceImpl studentService;
    @MockBean
    private StudentDao studentDao;

    @Test
    void findAll() {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1L, "Tomas", "Salvo", 22, "343434343"));
        list.add(new Student(2L, "Juan", "Diaz", 23, "2342342344"));
        list.add(new Student(3L, "Pedro", "Gomez", 30, "345345455"));

        when(studentDao.findAll()).thenReturn(list);

        assertEquals(3, studentService.findAll().size());
        assertEquals("Tomas", studentService.findAll().get(0).getName());
    }

    @Test
    void save() {
        Student student = new Student();

        student.setId(1L);
        student.setName("History");

        when(studentDao.save(student)).thenReturn(student);

        assertEquals(student.getId(), studentService.save(student));
    }

    @Test
    void findById() throws StudentNotFoundException {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1L, "Lucho", "Torvalds", 67, "345454545"));
        list.add(new Student(2L, "Mario", "Kempes", 56, "4545454545"));

        when(studentDao.findById(1L)).thenReturn(Optional.ofNullable(list.get(0)));

        assertEquals("Lucho", studentService.findById(1L).getName());
    }
}