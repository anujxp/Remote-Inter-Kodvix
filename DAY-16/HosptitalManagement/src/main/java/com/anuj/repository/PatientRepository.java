package com.anuj.repository;

import com.anuj.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Magic: Spring parses "findBy" + "Name"
    List<Patient> findByName(String name);

    // Magic: Spring parses "findBy" + "Email"
    Optional<Patient> findByEmail(String email);

    // Magic: Spring parses "findBy" + "Gender"
    List<Patient> findByGender(String gender);

    // Advanced Example: Find by Name AND Gender
    List<Patient> findByNameAndGender(String name, String gender);
}