package com.nahuel.proyect.Universityproyect.repository;

import com.nahuel.proyect.Universityproyect.model.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SubjectDaoTest {

    @Autowired
    private SubjectDao subjectDao;

    @Test
    public void findAllSubjectsFromDB() {

        Subject subject = new Subject();
        subject.setId(1L);
        subject.setName("Maths");
        subjectDao.save(subject);

        Subject subject2 = new Subject();
        subject2.setId(2L);
        subject2.setName("History");
        subjectDao.save(subject2);

        List<Subject> subjects = subjectDao.findAll();

        assertEquals(2, subjects.size());
        assertEquals(1L, subjects.get(0).getId());
        assertEquals("Maths", subjects.get(0).getName());
        assertEquals(2L, subjects.get(1).getId());
        assertEquals("History", subjects.get(1).getName());
    }

    @Test
    public void FindTeacherById() {

        Subject subject = new Subject();
        subject.setId(1L);
        subject.setName("Geography");
        subjectDao.save(subject);

        Subject subject2 = new Subject();
        subject2.setId(2L);
        subject2.setName("Programming");
        subjectDao.save(subject2);

        Optional<Subject> subjectDaoById = subjectDao.findById(2L);

        if (subjectDaoById.isPresent()) {
            assertEquals(2L, subjectDaoById.get().getId());
            assertEquals("Programming", subjectDaoById.get().getName());
        }
    }
}