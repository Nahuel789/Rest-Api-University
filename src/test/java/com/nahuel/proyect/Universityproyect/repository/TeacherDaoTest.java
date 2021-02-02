package com.nahuel.proyect.Universityproyect.repository;

import com.nahuel.proyect.Universityproyect.model.Teacher;
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
public class TeacherDaoTest {

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void findAllTeachersFromDB() {

        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("Pedro");
        teacher.setLastName("Gomez");
        teacherDao.save(teacher);

        Teacher teacher2 = new Teacher();
        teacher2.setId(2L);
        teacher2.setName("Juan");
        teacher2.setLastName("Gomez");
        teacherDao.save(teacher2);

        List<Teacher> teacherList = teacherDao.findAll();

        assertEquals(2, teacherList.size());
        assertEquals("Juan", teacherList.get(1).getName());
    }

    @Test
    public void FindTeacherById() {

        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("Pedro");
        teacher.setLastName("Gomez");
        teacherDao.save(teacher);

        Teacher teacher2 = new Teacher();
        teacher2.setId(2L);
        teacher2.setName("Juan");
        teacher2.setLastName("Gomez");
        teacherDao.save(teacher2);

        Optional<Teacher> teacher_2 = teacherDao.findById(2L);

        if (teacher_2.isPresent()) {
            assertEquals(2L, teacher_2.get().getId());
            assertEquals("Juan", teacher_2.get().getName());
            assertEquals("Gomez", teacher_2.get().getLastName());
        }
    }
}