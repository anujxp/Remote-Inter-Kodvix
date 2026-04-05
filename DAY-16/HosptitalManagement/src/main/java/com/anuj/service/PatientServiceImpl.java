package com.anuj.service;

import com.anuj.entity.Patient;
import com.anuj.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Lombok: Automatically injects PatientRepository
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    // Using Custom Query Methods from Repository
    @Override
    public List<Patient> findPatientsByName(String name) {
        return patientRepository.findByName(name);
    }

    @Override
    public Patient findPatientByEmail(String email) {
        return patientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Patient not found with email: " + email));
    }

    @Override
    public List<Patient> findPatientsByGender(String gender) {
        return patientRepository.findByGender(gender);
    }
}