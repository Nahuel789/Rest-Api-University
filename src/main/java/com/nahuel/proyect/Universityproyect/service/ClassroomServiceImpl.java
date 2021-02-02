package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.model.Classroom;
import com.nahuel.proyect.Universityproyect.model.Subject;
import com.nahuel.proyect.Universityproyect.repository.ClassroomDao;
import com.nahuel.proyect.Universityproyect.exception.ClassroomNotFoundException;
import com.nahuel.proyect.Universityproyect.repository.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the service interface of a classroom
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomDao classroomDao;
    @Autowired
    private SubjectDao subjectDao;

    /**
     * method that returns the list from the database
     *
     * @return List of classrooms
     */
    @Transactional(readOnly = true)
    public List<Classroom> findAll() {
        return classroomDao.findAll();
    }

    /**
     * method that save a classroom in the database
     *
     * @param classroom to saved
     * @return Long id classroom
     */
    @Transactional
    public Long save(Classroom classroom) {
        Classroom classroom1 = new Classroom();
        classroom1.setName(classroom.getName());
        return classroomDao.save(classroom1).getId();
    }

    /**
     * method that search a classroom in the database
     *
     * @param aLong id to search
     * @return a classroom
     * @throws ClassroomNotFoundException .
     */
    @Transactional(readOnly = true)
    public Classroom findById(Long aLong) throws ClassroomNotFoundException {
        return classroomDao.findById(aLong).orElseThrow(() -> new ClassroomNotFoundException(aLong));
    }

    /**
     * method that adds a subject to a classroom
     *
     * @param id1 id classroom
     * @param id2 id subject
     */
    public void addSubjectToClassroom(Long id1, Long id2) {
        Optional<Classroom> classroom = classroomDao.findById(id1);
        Optional<Subject> subject = subjectDao.findById(id2);
        if (classroom.isPresent() && subject.isPresent()) {
            classroom.get().addSubject(subject.get());
            classroomDao.save(classroom.get());
        }
    }
}
