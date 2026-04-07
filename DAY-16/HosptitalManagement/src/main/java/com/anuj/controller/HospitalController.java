package com.anuj.controller;

import com.anuj.entity.Hospital;
import com.anuj.service.HospitalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    // Constructor Injection
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @PostMapping("/add")
    public Hospital addHospital(@RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);
    }

    @GetMapping("/all")
    public List<Hospital> getAll() {
        return hospitalService.getAllHospitals();
    }
}