package com.nahuel.proyect.Universityproyect.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class of entity Classroom
 *
 * @author Nahuel Carbajal
 * @version 21/1/2021
 */
@Entity
@Table(name = "classroom")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToMany
    @JoinTable(
            name = "classroom_subject",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjectHashSet = new HashSet<>();

    /**
     * Parameterless constructor of classroom
     */
    public Classroom() {
    }

    /**
     * Constructor of classroom with params
     *
     * @param id   classroom
     * @param name classroom
     */
    public Classroom(Long id, String name) {
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
     * method to set name classroom
     *
     * @param name classroom
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method to add subject in hashset
     *
     * @param subject added
     */
    public void addSubject(Subject subject) {
        subjectHashSet.add(subject);
    }
}
