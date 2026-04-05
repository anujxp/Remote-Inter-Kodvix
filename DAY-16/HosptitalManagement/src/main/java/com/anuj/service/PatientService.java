package com.anuj.service;

import com.anuj.entity.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    // Basic CRUD
    Patient savePatient(Patient patient);
    List<Patient> getAllPatients();
    Optional<Patient> getPatientById(Long id);
    void deletePatient(Long id);

    // JPA Query Methods (Custom Logic)
    List<Patient> findPatientsByName(String name);
    Patient findPatientByEmail(String email);
    List<Patient> findPatientsByGender(String gender);
}