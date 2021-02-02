package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.model.Student;
import com.nahuel.proyect.Universityproyect.model.Subject;
import com.nahuel.proyect.Universityproyect.model.Teacher;
import com.nahuel.proyect.Universityproyect.repository.StudentDao;
import com.nahuel.proyect.Universityproyect.repository.SubjectDao;
import com.nahuel.proyect.Universityproyect.exception.SubjectNotFoundException;
import com.nahuel.proyect.Universityproyect.repository.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the service interface of a Subject
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    /**
     * Method that returns the list from the database
     *
     * @return List of subjects
     */
    @Transactional(readOnly = true)
    public List<Subject> findAll() {
        return subjectDao.findAll();
    }

    /**
     * method to save a subject in the database
     *
     * @param subject to save
     * @return long id subject
     */
    @Transactional
    public Long save(Subject subject) {
        Subject subject1 = new Subject();
        subject1.setId(subject.getId());
        subject1.setName(subject.getName());
        return subjectDao.save(subject1).getId();
    }

    /**
     * method to search a subject by id in the database
     *
     * @param aLong id subject
     * @return a subject
     */
    @Transactional(readOnly = true)
    public Subject findById(Long aLong) throws SubjectNotFoundException {
        return subjectDao.findById(aLong).orElseThrow(() -> new SubjectNotFoundException(aLong));
    }

    /**
     * method method that adds a student to a subject
     *
     * @param id1 id subject
     * @param id2 id student
     */
    public void enroleStudentToSubject(Long id1, Long id2) {
        Optional<Subject> subject = subjectDao.findById(id1);
        Optional<Student> student = studentDao.findById(id2);
        if (subject.isPresent() && student.isPresent()) {
            subject.get().addStudent(student.get());
            subjectDao.save(subject.get());
        }
    }

    /**
     * method that adds a teacher to a subject
     *
     * @param id1 id subject
     * @param id2 id teacher
     */
    public void addTeacherToSubject(Long id1, Long id2) {
        Optional<Subject> subject = subjectDao.findById(id1);
        Optional<Teacher> teacher = teacherDao.findById(id2);
        if (subject.isPresent() && teacher.isPresent()) {
            subject.get().addTeacher(teacher.get());
            subjectDao.save(subject.get());
        }
    }
}
