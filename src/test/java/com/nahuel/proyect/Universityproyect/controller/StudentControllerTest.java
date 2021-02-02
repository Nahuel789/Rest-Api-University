package com.nahuel.proyect.Universityproyect.controller;

import com.nahuel.proyect.Universityproyect.exception.StudentNotFoundException;
import com.nahuel.proyect.Universityproyect.model.Student;
import com.nahuel.proyect.Universityproyect.service.StudentServiceImpl;
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
class StudentControllerTest {

    @Autowired
    private StudentController studentController;

    @MockBean
    private StudentServiceImpl studentService;


    @Test
    void getAllStudents() {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1L, "Pedro", "Diaz", 23, "4545454545"));
        list.add(new Student(2L, "Juan", "Gomez", 32, "54545454545"));

        when(studentService.findAll()).thenReturn(list);

        assertEquals(2, Objects.requireNonNull(studentController.getAllStudents().getBody()).size());

        assertEquals(1L, Objects.requireNonNull(studentController.getAllStudents().getBody().get(0).getId()));
        assertEquals("Pedro", Objects.requireNonNull(studentController.getAllStudents().getBody().get(0).getName()));
        assertEquals("Diaz", Objects.requireNonNull(studentController.getAllStudents().getBody().get(0).getLastname()));
        assertEquals(23, studentController.getAllStudents().getBody().get(0).getAge());
        assertEquals("4545454545", Objects.requireNonNull(studentController.getAllStudents().getBody().get(0).getPassportNumber()));

        assertEquals(2L, Objects.requireNonNull(studentController.getAllStudents().getBody().get(1).getId()));
        assertEquals("Juan", Objects.requireNonNull(studentController.getAllStudents().getBody().get(1).getName()));
        assertEquals("Gomez", Objects.requireNonNull(studentController.getAllStudents().getBody().get(1).getLastname()));
        assertEquals(32, studentController.getAllStudents().getBody().get(1).getAge());
        assertEquals("54545454545", Objects.requireNonNull(studentController.getAllStudents().getBody().get(1).getPassportNumber()));

    }

    @Test
    void userById() throws StudentNotFoundException {
        List<Student> list = new ArrayList<>();

        list.add(new Student(1L, "Pedro", "Diaz", 23, "350505054"));
        list.add(new Student(2L, "Juan", "Gomez", 24, "434343433"));

        when(studentService.findById(2L)).thenReturn(list.get(1));

        assertEquals(2L, (Objects.requireNonNull(studentController.studentById(2L).getBody()).getId()));
        assertEquals("Juan", Objects.requireNonNull(studentController.studentById(2L).getBody()).getName());
        assertEquals("Gomez", (Objects.requireNonNull(studentController.studentById(2L).getBody()).getLastname()));
        assertEquals(24, Objects.requireNonNull(studentController.studentById(2L).getBody()).getAge());
        assertEquals("434343433", (Objects.requireNonNull(studentController.studentById(2L).getBody()).getPassportNumber()));

    }

    @Test
    void create() {
        Student student = new Student();

        student.setId(1L);
        student.setName("Roberto");
        student.setLastname("Carlos");
        student.setAge(22);
        student.setPassportNumber("4545454545");

        when(studentService.save(student)).thenReturn(student.getId());

        assertEquals(1L, Objects.requireNonNull(studentController.create(student).getBody()).longValue());
    }
}