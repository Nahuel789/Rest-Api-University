package com.nahuel.proyect.Universityproyect.repository;

import com.nahuel.proyect.Universityproyect.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * this interface intends to persist the data with Spring JPA
 */
@Repository
public interface SubjectDao extends JpaRepository<Subject,Long> {
}
