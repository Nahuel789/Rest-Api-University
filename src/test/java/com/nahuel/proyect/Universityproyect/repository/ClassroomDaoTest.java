package com.nahuel.proyect.Universityproyect.repository;

import com.nahuel.proyect.Universityproyect.model.Classroom;
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
public class ClassroomDaoTest {

    @Autowired
    private ClassroomDao classroomDao;

    @Test
    public void findAllClassroomsFromDB() {

        Classroom classroom = new Classroom();
        classroom.setId(1L);
        classroom.setName("classroom_1");
        classroomDao.save(classroom);

        Classroom classroom2 = new Classroom();
        classroom2.setId(2L);
        classroom2.setName("classroom_2");
        classroomDao.save(classroom2);

        List<Classroom> classroomList = classroomDao.findAll();

        assertEquals(2, classroomList.size());

        assertEquals(1L, classroomList.get(0).getId());
        assertEquals("classroom_1", classroomList.get(0).getName());

        assertEquals(2L, classroomList.get(1).getId());
        assertEquals("classroom_2", classroomList.get(1).getName());

    }

    @Test
    public void findClassroomByIdFromDB() {

        Classroom classroom = new Classroom();
        classroom.setId(1L);
        classroom.setName("classroom_1");
        classroomDao.save(classroom);

        Classroom classroom2 = new Classroom();
        classroom2.setId(2L);
        classroom2.setName("classroom_2");
        classroomDao.save(classroom2);

        Optional<Classroom> classroomDaoById = classroomDao.findById(2L);

        if (classroomDaoById.isPresent()) {
            assertEquals(2L, classroomDaoById.get().getId());
            assertEquals("classroom_2", classroomDaoById.get().getName());

        }
    }

}