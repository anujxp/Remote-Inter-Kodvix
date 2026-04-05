package com.anuj.controller;

import com.anuj.entity.Patient;
import com.anuj.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients") // Base URL for all methods in this class
@RequiredArgsConstructor // Injects PatientService automatically
public class PatientController {

    private final PatientService patientService;

    // 1. Create a Patient (POST http://localhost:8080/api/patients)
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.savePatient(patient));
    }

    // 2. Get All Patients (GET http://localhost:8080/api/patients)
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    // 3. Search by Name (GET http://localhost:8080/api/patients/search?name=Anuj)
    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(patientService.findPatientsByName(name));
    }

    // 4. Delete Patient (DELETE http://localhost:8080/api/patients/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully!");
    }
}