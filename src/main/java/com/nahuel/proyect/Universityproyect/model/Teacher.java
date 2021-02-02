package com.nahuel.proyect.Universityproyect.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class of entity teacher
 */
@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @ManyToMany(mappedBy = "teachers")
    private Set<Subject> subjectHashSet = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "teacher_schedule",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id"))
    private Set<Schedule> scheduleHashSet = new HashSet<>();

    /**
     * Parameterless constructor of teacher
     */
    public Teacher() {
    }

    /**
     * Constructor with params of teacher
     *
     * @param id       teacher
     * @param name     teacher
     * @param lastName teacher
     */
    public Teacher(Long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
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
     * @param id teacher
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
     * @param name teacher
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to obtain the last name
     *
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * method to set the last name
     *
     * @param lastName teacher
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * method to add schedule
     *
     * @param schedule added
     */
    public void addSchedule(Schedule schedule) {
        scheduleHashSet.add(schedule);
    }

    /**
     * method to add subject
     *
     * @param subject added
     */
    public void addSubject(Subject subject) {
        subjectHashSet.add(subject);
    }

    public Set<Subject> getSubjectHashSet() {
        return subjectHashSet;
    }

    public Set<Schedule> getScheduleHashSet() {
        return scheduleHashSet;
    }
}
