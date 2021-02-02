package com.nahuel.proyect.Universityproyect.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class of entity subject
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(
            name = "subject_teacher",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teachers = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "subject_student",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> students = new HashSet<>();
    @ManyToMany(mappedBy = "subjectHashSet")
    private Set<Classroom> classroomHashSet = new HashSet<>();

    /**
     * Parameterless constructor of subject
     */
    public Subject() {
    }

    /**
     * Constructor with params of subject
     *
     * @param id   subject
     * @param name subject
     */
    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * method to obtain the id
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * method to set the id
     *
     * @param id student
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * method to obtain the name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * method to set the name
     *
     * @param name student
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to add student
     *
     * @param student added
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * method to add teacher
     *
     * @param teacher added
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
}
