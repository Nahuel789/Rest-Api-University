package com.nahuel.proyect.Universityproyect.service;

import com.nahuel.proyect.Universityproyect.model.Schedule;
import com.nahuel.proyect.Universityproyect.model.Student;
import com.nahuel.proyect.Universityproyect.model.Subject;
import com.nahuel.proyect.Universityproyect.repository.ScheduleDao;
import com.nahuel.proyect.Universityproyect.repository.StudentDao;
import com.nahuel.proyect.Universityproyect.exception.StudentNotFoundException;
import com.nahuel.proyect.Universityproyect.repository.SubjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the service interface of a schedule
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private ScheduleDao scheduleDao;

    /**
     * Method that returns the list from the database
     *
     * @return List of students
     */
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    /**
     * method to save a student in the database
     *
     * @param student to save
     * @return long id student
     */
    @Transactional
    public Long save(Student student) {
        Student student1 = new Student();
        student1.setName(student.getName());
        student1.setLastname(student.getLastname());
        student1.setAge(student.getAge());
        student1.setPassportNumber(student.getPassportNumber());
        return studentDao.save(student1).getId();
    }

    /**
     * method to search a student by id in the database
     *
     * @param aLong id student
     * @return a student
     */
    @Transactional(readOnly = true)
    public Student findById(Long aLong) throws StudentNotFoundException {
        return studentDao.findById(aLong).orElseThrow(() -> new StudentNotFoundException(aLong));
    }

    /**
     * method that adds a subject to a student
     *
     * @param id1 id student
     * @param id2 id subject
     */
    public void addSubjectToStudent(Long id1, Long id2) {
        Optional<Student> student = studentDao.findById(id1);
        Optional<Subject> subject = subjectDao.findById(id2);
        if (student.isPresent() && subject.isPresent()) {
            student.get().addSubject(subject.get());
            studentDao.save(student.get());
        }
    }

    /**
     * method that adds a schedule to a student
     *
     * @param id1 id student
     * @param id2 id schedule
     */
    public void addScheduleToStudent(Long id1, Long id2) {
        Optional<Student> student = studentDao.findById(id1);
        Optional<Schedule> schedule = scheduleDao.findById(id2);
        if (student.isPresent() && schedule.isPresent()) {
            student.get().addSchedule(schedule.get());
            studentDao.save(student.get());
        }
    }
}
