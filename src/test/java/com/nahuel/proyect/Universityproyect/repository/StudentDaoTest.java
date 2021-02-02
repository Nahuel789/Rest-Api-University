package com.nahuel.proyect.Universityproyect.repository;

import com.nahuel.proyect.Universityproyect.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void findAllTeachersFromDB() {

        Student student = new Student();
        student.setId(1L);
        student.setName("Pedro");
        student.setLastname("Gomez");
        student.setAge(22);
        student.setPassportNumber("8080808080");
        studentDao.save(student);

        Student student1 = new Student();
        student1.setId(2L);
        student1.setName("Tomas");
        student1.setLastname("Sanchez");
        student1.setAge(23);
        student1.setPassportNumber("80808080808");
        studentDao.save(student1);

        List<Student> students = studentDao.findAll();

        assertEquals(2, students.size());
        assertEquals(1L, students.get(0).getId());
        assertEquals("Pedro", students.get(0).getName());
        assertEquals("Gomez", students.get(0).getLastname());
        assertEquals(22, students.get(0).getAge());
        assertEquals("8080808080", students.get(0).getPassportNumber());

        assertEquals(2L, students.get(1).getId());
        assertEquals("Tomas", students.get(1).getName());
        assertEquals("Sanchez", students.get(1).getLastname());
        assertEquals(23, students.get(1).getAge());
        assertEquals("80808080808", students.get(1).getPassportNumber());
    }

    @Test
    public void findStudentByIdFromDB() {

        Student student = new Student();
        student.setId(1L);
        student.setName("Pedro");
        student.setLastname("Gomez");
        student.setAge(22);
        student.setPassportNumber("8080808080");
        studentDao.save(student);

        Student student1 = new Student();
        student1.setId(2L);
        student1.setName("Tomas");
        student1.setLastname("Sanchez");
        student1.setAge(23);
        student1.setPassportNumber("80808080808");
        studentDao.save(student);

        Optional<Student> teacher_2 = studentDao.findById(2L);

        if (teacher_2.isPresent()) {
            assertEquals(2L, teacher_2.get().getId());
            assertEquals("Tomas", teacher_2.get().getName());
            assertEquals("Sanchez", teacher_2.get().getLastname());
            assertEquals(23, teacher_2.get().getAge());
            assertEquals("80808080808", teacher_2.get().getPassportNumber());
        }
    }

}