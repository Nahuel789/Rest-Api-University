package com.nahuel.proyect.Universityproyect.model;

import javax.persistence.*;
import java.util.*;

/**
 * Class of entity student
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastname;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "passportNumber", nullable = false)
    private String passportNumber;
    @ManyToMany(mappedBy = "students")
    private Set<Subject> subjectHashSet = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "student_schedule",
            joinColumns = @JoinColumn(name = "schedule_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Schedule> scheduleHashSet = new HashSet<>();

    /**
     * Parameterless constructor of student
     */
    public Student() {
    }

    /**
     * Constructor with params of student
     *
     * @param id             student
     * @param name           student
     * @param lastname       student
     * @param age            student
     * @param passportNumber student
     */
    public Student(Long id, String name, String lastname, int age, String passportNumber) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.passportNumber = passportNumber;
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
     * @param id long
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
     * method to obtain the last name
     *
     * @return last name
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * method to set last name
     *
     * @param lastname student
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * method to obtain the age
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * method to set the age
     *
     * @param age student
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * method to obtain the number passport
     *
     * @return passport number
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * method to set passport number
     *
     * @param passportNumber student
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void addSubject(Subject subject) {
        subjectHashSet.add(subject);
    }

    public void addSchedule(Schedule schedule) {
        scheduleHashSet.add(schedule);
    }
}

