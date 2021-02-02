package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.model.Schedule;
import com.nahuel.proyect.Universityproyect.model.Subject;
import com.nahuel.proyect.Universityproyect.model.Teacher;
import com.nahuel.proyect.Universityproyect.repository.ScheduleDao;
import com.nahuel.proyect.Universityproyect.repository.SubjectDao;
import com.nahuel.proyect.Universityproyect.repository.TeacherDao;
import com.nahuel.proyect.Universityproyect.exception.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the service interface of a Teacher
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private ScheduleDao scheduleDao;

    @Autowired
    private SubjectDao subjectDao;

    /**
     * Method that returns the list of teachers from the database
     *
     * @return List of teachers
     */
    @Transactional(readOnly = true)
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    /**
     * method to save a subject in the database
     *
     * @param teacher to save
     * @return long id subject
     */
    @Transactional
    public Long save(Teacher teacher) {
        Teacher teacher1 = new Teacher();
        teacher1.setName(teacher.getName());
        teacher1.setLastName(teacher.getLastName());
        return teacherDao.save(teacher1).getId();
    }

    /**
     * method to search a teacher by id in the database
     *
     * @param aLong id subject
     * @return a subject
     */
    @Transactional(readOnly = true)
    @Override
    public Teacher findById(Long aLong) throws TeacherNotFoundException {
        return teacherDao.findById(aLong).orElseThrow(() -> new TeacherNotFoundException(aLong));
    }

    /**
     * method method that adds a schedule to a teacher
     *
     * @param id1 id teacher
     * @param id2 id schedule
     */
    public void addScheduleToTeacher(Long id1, Long id2) {
        Optional<Teacher> teacher = teacherDao.findById(id1);
        Optional<Schedule> schedule = scheduleDao.findById(id2);
        if (teacher.isPresent() && schedule.isPresent()) {
            teacher.get().addSchedule(schedule.get());
            teacherDao.save(teacher.get());
        }
    }

    /**
     * method method that adds a subjects to a teacher
     *
     * @param id1 id teacher
     * @param id2 id subject
     */
    public void addSubjectToTeacher(Long id1, Long id2) {
        Optional<Teacher> teacher = teacherDao.findById(id1);
        Optional<Subject> subject = subjectDao.findById(id2);
        if (teacher.isPresent() && subject.isPresent()) {
            teacher.get().addSubject(subject.get());
            teacherDao.save(teacher.get());
        }
    }
}
